#ifdef Z_SL_OPENGLES

#if 0
	#ifdef GL_EXT_shader_framebuffer_fetch
		#extension GL_EXT_shader_framebuffer_fetch : require
		#define Z_FRAMEBUFFER_FETCH
	#endif
#endif

	#ifndef Z_FRAMEBUFFER_FETCH
		uniform lowp sampler2D u_Texture;
		uniform mediump vec2 u_TextureSize;
	#endif

	uniform highp float u_Time;

	uniform lowp vec4 u_Colour;
		
	// --- Attributes
	
	#ifdef Z_SHADER_VERTEX 

		attribute highp vec4 a_Position;
	
		#ifndef Z_FRAMEBUFFER_FETCH
			attribute mediump vec2 a_TexCoords;
		#endif
		
	#endif
		
	// --- Varyings
	
	#ifndef Z_FRAMEBUFFER_FETCH
		varying mediump vec2 v_TexCoords;
	#endif
		
	// --- Main
	
	#ifdef Z_SHADER_VERTEX

		void main()
		{
			gl_Position = a_Position;
			#ifndef Z_FRAMEBUFFER_FETCH
				v_TexCoords = a_TexCoords;
			#endif
		}
		
	#else

		lowp float Luminance(lowp vec3 colour)
		{
			lowp vec3 luminanceFunc = vec3(0.299, 0.587, 0.114);
			lowp float luminance = dot(luminanceFunc, colour);
			return luminance;
		}

		lowp vec4 Highlight(lowp vec3 colour)
		{
			lowp float luminance = Luminance(colour);

			lowp float alpha = clamp((luminance - 0.25) / 0.47, 0.0, 1.0);

			return vec4(colour, alpha);
		}

		mediump vec4 ToPreMultipliedAlpha(mediump vec4 colour)
		{
			return vec4(colour.rgb * colour.a, colour.a);
		}

		mediump vec4 FromPreMultipliedAlpha(mediump vec4 colour)
		{
			if (colour.a == 0.0)
			{
				return vec4(colour.rgb, 0.0);
			}
			return vec4(colour.rgb / colour.a, colour.a);
		}

		mediump vec4 GaussianHighlightSample(mediump float dx, mediump float dy, mediump float kernel)
		{
			lowp vec3 texValue = texture2D(u_Texture, v_TexCoords + vec2(dx / u_TextureSize.x, dy / u_TextureSize.y)).rgb;
			mediump vec4 highlight = ToPreMultipliedAlpha(Highlight(texValue));
			return kernel * highlight;
		}

		lowp vec4 GaussianHighlight()
		{
			const int radius = 5;
			mediump float sigmaSquared = float(radius) * float(radius);
			mediump float scale = 1.0 / (2.0 * 3.14159 * sigmaSquared);
			mediump float expScale = -1.0 / (2.0 * sigmaSquared);

			mediump vec4 result = vec4(0.0);

			mediump float gaussianTotal = 0.0;
			for (int i = -radius; i <= radius; ++i)
			{
                mediump float iF = float(i);
                mediump float iF2 = iF * iF;
				for (int j = -radius; j <= radius; ++j)
				{
                    mediump float jF = float(j);
                    mediump float jF2 = jF * jF;
					mediump float gaussian = scale * exp(expScale * (iF2 + jF2));
					gaussianTotal += gaussian;
					result += GaussianHighlightSample(iF, jF, gaussian);
				}
			}
			result /= gaussianTotal;
			result = FromPreMultipliedAlpha(result);


			return result;
		}

		lowp vec3 Lighten(lowp vec3 colour)
		{
			return mix(colour, vec3(1.0), 0.5);
		}
		
		lowp vec4 ScreenColour()
		{
			#ifdef Z_FRAMEBUFFER_FETCH
				return gl_LastFragData[0];
			#else
				return texture2D(u_Texture, v_TexCoords);
			#endif
		}

		mediump float rand(mediump vec2 co){
            mediump vec2 a = vec2(12.9898,78.233);
            mediump float b = dot(co.xy, a);
            mediump float c = sin(b);
            mediump float d = 43758.5453;
            mediump float e = c * d;
            mediump float f = fract(e);
			return f;
		}
				
		void main()
		{
			lowp float intensity = u_Colour.a;
		
			lowp vec3 screenColour = ScreenColour().rgb;

			lowp vec4 highlight = Highlight(screenColour); // Seems to match.

			lowp vec4 gaussianHighlight = highlight; //GaussianHighlight();

			//gaussianHighlight.a *= rand(v_TexCoords + u_Time);

			lowp vec4 brightGaussianHighlight = vec4(Lighten(gaussianHighlight.rgb), gaussianHighlight.a);
						
			lowp vec3 alphaed = mix(screenColour, brightGaussianHighlight.rgb, brightGaussianHighlight.a);
			
			lowp vec3 singleColoured = mix(alphaed, vec3(0.6, 0.8, 1.0), 0.25);
			
			gl_FragColor = vec4(mix(screenColour, singleColoured, intensity), 1.0);
			
			// Preview highlight over white
			//gl_FragColor = vec4(mix(vec3(1.0, 1.0, 1.0), highlight.rgb, highlight.a), 1.0);

			// Preview gaussian highlight over white
			//gl_FragColor = vec4(mix(vec3(1.0, 1.0, 1.0), gaussianHighlight.rgb, gaussianHighlight.a), 1.0);

			// Preview bright gaussian highlight over white
			//gl_FragColor = vec4(mix(vec3(1.0, 1.0, 1.0), brightGaussianHighlight.rgb, brightGaussianHighlight.a), 1.0);

			// Preview show 25 percent colour fill.
			//gl_FragColor = vec4(mix(vec3(1.0, 1.0, 1.0), brightGaussianHighlight.rgb, brightGaussianHighlight.a), 1.0);
		}
		
		
	#endif
		
#endif
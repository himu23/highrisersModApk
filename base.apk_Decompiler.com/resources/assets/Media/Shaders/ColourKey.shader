#ifdef Z_SL_OPENGLES

	#ifdef GL_EXT_shader_framebuffer_fetch
        #extension GL_EXT_shader_framebuffer_fetch : require
        #define Z_FRAMEBUFFER_FETCH
    #endif

	// --- Uniforms

	uniform highp mat4 u_ModelViewProjection;

	#ifndef Z_FRAMEBUFFER_FETCH
		uniform lowp sampler2D u_ScreenTexture;  
	#endif

	uniform lowp sampler2D u_Texture;

	// --- Attributes
	
	#ifdef Z_SHADER_VERTEX 

		attribute highp vec4 a_Position;

		attribute mediump vec2 a_TexCoords;
	
		#ifndef Z_FRAMEBUFFER_FETCH
			attribute mediump vec2 a_TexCoords2;
		#endif
		
	#endif
		
	// --- Varyings
	
	varying mediump vec2 v_TexCoords;
	#ifndef Z_FRAMEBUFFER_FETCH
		varying mediump vec2 v_TexCoords2;
	#endif
		
	// --- Main
	
	#ifdef Z_SHADER_VERTEX

		void main()
		{
			gl_Position = u_ModelViewProjection * a_Position;
			v_TexCoords = a_TexCoords;
			#ifndef Z_FRAMEBUFFER_FETCH
				v_TexCoords2 = a_TexCoords2;
			#endif
		}
		
	#else

		lowp float Luminance(lowp vec3 colour)
		{
			lowp vec3 luminanceFunc = vec3(0.299, 0.587, 0.114);
			lowp float luminance = dot(luminanceFunc, colour);
			return luminance;
		}

		lowp vec3 ColourKey(lowp vec3 colour, lowp vec3 keyColour, lowp float intensity)
		{
			lowp float luminance = Luminance(colour);
			return mix(colour, luminance * keyColour, intensity);
		}

		lowp vec3 ScreenColour()
		{
			#ifdef Z_FRAMEBUFFER_FETCH
				return gl_LastFragData[0].rgb;
			#else
				return texture2D(u_ScreenTexture, v_TexCoords2).rgb;
			#endif
		}

		void main()
		{
			lowp vec3 screenColour = ScreenColour();
			
			lowp vec4 colourKeyTexValue = texture2D(u_Texture, v_TexCoords);

			lowp vec4 colourKey = colourKeyTexValue;

			lowp vec3 withColourKey = ColourKey(screenColour, colourKey.rgb, colourKey.a);

			gl_FragColor = vec4(withColourKey, 1.0);
		}
		
	#endif
		
#endif
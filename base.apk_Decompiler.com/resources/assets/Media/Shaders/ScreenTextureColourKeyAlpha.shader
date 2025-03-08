// 1. Reads from a screen texture. 
// 2. Applies a colour key.
// 3. Applies an alpha. 

#ifdef Z_SL_OPENGLES

	// --- Uniforms

	uniform highp mat4 u_ModelViewProjection;

	uniform lowp sampler2D u_ScreenTexture;

	uniform lowp sampler2D u_ColourKeyTexture;

	uniform lowp sampler2D u_AlphaTexture;

	uniform lowp vec4 u_ColourKey;

	uniform lowp float u_Alpha;

	// --- Attributes
	
	#ifdef Z_SHADER_VERTEX 

		attribute highp vec4 a_Position;

		attribute highp vec2 a_TexCoords;  // ColourKeyTexture

		attribute highp vec2 a_TexCoords2; // AlphaTexture
	
		attribute highp vec2 a_TexCoords3; // ScreenTexture
		
	#endif
		
	// --- Varyings
	
	varying highp vec2 v_TexCoords;
	varying highp vec2 v_TexCoords2;
	varying highp vec2 v_TexCoords3;
		
	// --- Main
	
	#ifdef Z_SHADER_VERTEX

		void main()
		{
			gl_Position = u_ModelViewProjection * a_Position;
			v_TexCoords = a_TexCoords;
			v_TexCoords2 = a_TexCoords2;
			v_TexCoords3 = a_TexCoords3;
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

		void main()
		{
			lowp vec4 colourKeyTexValue = texture2D(u_ColourKeyTexture, v_TexCoords);
			lowp float alphaTexValue = texture2D(u_AlphaTexture, v_TexCoords2).r;
			lowp vec3 screenTexValue = texture2D(u_ScreenTexture, v_TexCoords3).rgb;

			lowp vec4 colourKey = colourKeyTexValue * u_ColourKey;
			lowp vec3 withColourKey = ColourKey(screenTexValue, colourKey.rgb, colourKey.a);
			
			lowp float alpha = u_Alpha * alphaTexValue;

			gl_FragColor = vec4(withColourKey, alpha);

			//gl_FragColor = vec4(v_TexCoords3.x, v_TexCoords3.y, 0.5f, 1.0f);
		}
		
	#endif
		
#endif
#ifdef Z_SL_OPENGLES

	// --- Uniforms

	uniform lowp sampler2D u_Texture;
	uniform lowp sampler2D u_SineTexture;
	uniform highp float u_Offset;
	uniform highp float u_SinOffset;
	uniform highp vec2 u_SinOffsetByPosition;

	// --- Attributes
	
	#ifdef Z_SHADER_VERTEX 
		attribute highp vec4 a_Position;
		attribute highp vec2 a_TexCoords;
	#endif
		
	// --- Varyings
	
	varying highp vec2 v_TexCoords;
	varying highp vec2 v_SinOffset;
		
	// --- Main
	
	#ifdef Z_SHADER_VERTEX

		void main()
		{
			gl_Position = a_Position;
			v_TexCoords = a_TexCoords;
			v_SinOffset = vec2(u_SinOffset + dot(u_SinOffsetByPosition, a_Position.xy), 0.0);
		}
		
	#else

		void main()
		{
			highp vec2 screenTexCoords = v_TexCoords;

			lowp float sineTexValue = texture2D(u_SineTexture, v_SinOffset).a;
            lowp float sineValue = (sineTexValue - 1.0) + sineTexValue;
			screenTexCoords.x += u_Offset * sineValue;

			lowp vec3 texValue = texture2D(u_Texture, screenTexCoords).rgb;
			gl_FragColor = vec4(texValue, 1.0);
		}
		
	#endif
		
#endif
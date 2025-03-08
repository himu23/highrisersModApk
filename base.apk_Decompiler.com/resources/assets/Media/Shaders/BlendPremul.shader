#ifdef Z_SL_OPENGLES

    uniform lowp sampler2D u_Texture;
	uniform lowp sampler2D u_Texture2;
		
	// --- Attributes
	
	#ifdef Z_SHADER_VERTEX 

		attribute highp vec4 a_Position;
	
		attribute highp vec2 a_TexCoords;
		
	#endif
		
	// --- Varyings
	
	varying highp vec2 v_TexCoords;

	// --- Main
	
	#ifdef Z_SHADER_VERTEX

		void main()
		{
			gl_Position = a_Position;
			v_TexCoords = a_TexCoords;
		}
		
	#else
		
		void main()
		{
			lowp vec3 texValue = texture2D(u_Texture, v_TexCoords).rgb;
			lowp vec4 texValue2 = texture2D(u_Texture2, v_TexCoords);

			gl_FragColor = vec4((1.0 - texValue2.a) * texValue + texValue2.rgb, 1.0);
			//gl_FragColor = vec4(texValue2.rgb, 1.0);
		}
		
		
	#endif
		
#endif
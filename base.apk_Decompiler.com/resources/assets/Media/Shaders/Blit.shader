#ifdef Z_SL_OPENGLES

	uniform lowp sampler2D u_Texture;
		
	// --- Attributes
	
	#ifdef Z_SHADER_VERTEX 

		attribute highp vec4 a_Position;
	
		attribute mediump vec2 a_TexCoords;
		
	#endif
		
	// --- Varyings
	
	varying mediump vec2 v_TexCoords;
		
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
			gl_FragColor = texture2D(u_Texture, v_TexCoords);
		}
		
	#endif
		
#endif
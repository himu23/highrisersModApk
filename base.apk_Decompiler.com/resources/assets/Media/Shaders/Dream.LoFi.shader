#ifdef Z_SL_OPENGLES

	uniform lowp vec4 u_OverlayColour;
		
	// --- Attributes
	
	#ifdef Z_SHADER_VERTEX 

		attribute highp vec4 a_Position;

	#endif
		
	// --- Varyings

	// --- Main
	
	#ifdef Z_SHADER_VERTEX

		void main()
		{
			gl_Position = a_Position;
		}
		
	#else
				
		void main()
		{
			gl_FragColor = u_OverlayColour;
		}
		
	#endif
		
#endif
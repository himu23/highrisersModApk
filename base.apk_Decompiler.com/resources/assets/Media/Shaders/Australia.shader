#ifdef Z_SL_OPENGLES

	uniform lowp sampler2D u_Texture;

#	ifdef Z_SHADER_VERTEX 
		attribute highp vec4 a_Position;
		attribute highp vec2 a_TexCoords;
#	endif
		
	varying highp vec2 v_TexCoords;

#	ifdef Z_SHADER_VERTEX
		void main()
		{
			gl_Position = a_Position;
			v_TexCoords = a_TexCoords;
		}
#	else
		void main()
		{
			lowp vec4 texValue = texture2D(u_Texture, v_TexCoords);
			gl_FragColor = texValue;
		}
#	endif
#endif
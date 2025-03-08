#ifdef Z_SL_OPENGLES

	uniform lowp sampler2D u_Texture;

#	ifdef Z_SHADER_VERTEX 
		attribute highp vec4 a_Position;
		attribute lowp vec4 a_Colour;
		attribute highp vec2 a_TexCoords;
#	endif
		
	varying lowp vec4 v_Colour;
	varying highp vec2 v_TexCoords;

#	ifdef Z_SHADER_VERTEX
		void main()
		{
			gl_Position = a_Position;
			v_Colour = a_Colour;
			v_TexCoords = a_TexCoords;
		}
#	else
		void main()
		{
			lowp vec4 texValue = texture2D(u_Texture, v_TexCoords);
			gl_FragColor = v_Colour * texValue;
		}
#	endif
#endif
#ifdef Z_SL_OPENGLES

	// --- Uniforms

	uniform highp mat4 u_ModelViewProjection;
	
	uniform lowp sampler2D u_Texture;
	uniform lowp sampler2D u_ShimmerTexture;

	uniform lowp float u_Alpha;

	// --- Attributes
	
	#ifdef Z_SHADER_VERTEX 

		attribute highp vec4 a_Position;

		attribute mediump vec2 a_TexCoords;

		attribute mediump vec2 a_TexCoords2;
		
	#endif
		
	// --- Varyings
	
	varying mediump vec2 v_TexCoords;
	varying mediump vec2 v_TexCoords2;
		
	// --- Main
	
	#ifdef Z_SHADER_VERTEX

		void main()
		{
			gl_Position = u_ModelViewProjection * a_Position;
			v_TexCoords = a_TexCoords;
			v_TexCoords2 = a_TexCoords2;
		}
		
	#else

		void main()
		{
			lowp vec4 mainTexValue = texture2D(u_Texture, v_TexCoords);

			lowp vec4 shimmerTexValue = texture2D(u_ShimmerTexture, v_TexCoords2);

			lowp float alphaOut = mainTexValue.a * shimmerTexValue.a;

			lowp vec3 rgbOut = mainTexValue.rgb + shimmerTexValue.rgb * alphaOut;

			gl_FragColor = vec4(rgbOut, alphaOut * u_Alpha);
		}
		
	#endif
		
#endif
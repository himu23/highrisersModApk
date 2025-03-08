#ifdef Z_SL_OPENGLES

	// --- Uniforms

	uniform highp mat4 u_ModelViewProjection;
	
	uniform lowp sampler2D u_Texture;
	uniform lowp sampler2D u_ShimmerTexture;
	uniform lowp sampler2D u_RippleTexture;

	uniform lowp float u_Alpha;

	uniform mediump vec2 u_RippleMagnitude;

	// --- Attributes
	
	#ifdef Z_SHADER_VERTEX 

		attribute highp vec4 a_Position;

		attribute mediump vec2 a_TexCoords;

		attribute mediump vec2 a_TexCoords2;

		attribute mediump vec2 a_TexCoords3;
		
	#endif
		
	// --- Varyings
	
	varying mediump vec2 v_TexCoords;
	varying mediump vec2 v_TexCoords2;
	varying mediump vec2 v_TexCoords3;
		
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

		void main()
		{
			lowp vec4 rippleTexValue = texture2D(u_RippleTexture, v_TexCoords3);

			mediump vec2 texCoords = v_TexCoords;
			mediump vec2 texCoordsOffset = rippleTexValue.xy;
			texCoordsOffset -= vec2(0.5);
			texCoordsOffset *= u_RippleMagnitude;
			texCoords += texCoordsOffset;

			lowp vec4 mainTexValue = texture2D(u_Texture, texCoords);

			lowp vec4 shimmerTexValue = texture2D(u_ShimmerTexture, v_TexCoords2);

			lowp float alphaOut = mainTexValue.a * shimmerTexValue.a;

			lowp vec3 rgbOut = mainTexValue.rgb + shimmerTexValue.rgb * alphaOut;

			gl_FragColor = vec4(rgbOut, alphaOut * u_Alpha);

			//gl_FragColor = shimmerTexValue;
		}
		
	#endif
		
#endif
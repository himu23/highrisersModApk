#ifdef Z_SL_OPENGLES

	// TO GENERATE KERNEL, GO HERE: http://dev.theomader.com/gaussian-kernel-calculator/
	// CURRENT SETTINGS: Sigma 2 Kernel Size 9

	const mediump float kernel_0 = 0.20236;
	const mediump float kernel_1 = 0.179044;
	const mediump float kernel_2 = 0.124009;
	const mediump float kernel_3 = 0.067234;
	const mediump float kernel_4 = 0.028532;
	
	const mediump float kernel_1_2 = kernel_1 + kernel_2;
	const mediump float kernel_3_4 = kernel_3 + kernel_4;
	
	const mediump float kernel_1_2_offset = 1.0 + kernel_2 / kernel_1_2;
	const mediump float kernel_3_4_offset = 3.0 + kernel_4 / kernel_3_4;

	uniform lowp sampler2D u_Texture;
	uniform mediump vec2 u_TextureInvSize;
		
	// --- Attributes
	
	#ifdef Z_SHADER_VERTEX 

		attribute highp vec4 a_Position;
	
		attribute mediump vec2 a_TexCoords;
		
	#endif
		
	// --- Varyings
	
	varying mediump vec2 v_TexCoordsNeg34;
	varying mediump vec2 v_TexCoordsNeg12;
	varying mediump vec2 v_TexCoords0;
	varying mediump vec2 v_TexCoordsPos12;
	varying mediump vec2 v_TexCoordsPos34;

	// --- Main
	
	#ifdef Z_SHADER_VERTEX

		void main()
		{
			gl_Position = a_Position;

			v_TexCoordsNeg34 = a_TexCoords;
			v_TexCoordsNeg12 = a_TexCoords;
			v_TexCoords0 = a_TexCoords;
			v_TexCoordsPos12 = a_TexCoords;
			v_TexCoordsPos34 = a_TexCoords;

			v_TexCoordsNeg34.x -= kernel_3_4_offset * u_TextureInvSize.x;
			v_TexCoordsNeg12.x -= kernel_1_2_offset * u_TextureInvSize.x;
			v_TexCoordsPos12.x += kernel_1_2_offset * u_TextureInvSize.x;
			v_TexCoordsPos34.x += kernel_3_4_offset * u_TextureInvSize.x;
		}
		
	#else
				
		void main()
		{
			lowp vec4 texValueNeg34 = texture2D(u_Texture, v_TexCoordsNeg34);
			lowp vec4 texValueNeg12 = texture2D(u_Texture, v_TexCoordsNeg12);
			lowp vec4 texValue0 = texture2D(u_Texture, v_TexCoords0);
			lowp vec4 texValuePos12 = texture2D(u_Texture, v_TexCoordsPos12);
			lowp vec4 texValuePos34 = texture2D(u_Texture, v_TexCoordsPos34);
			lowp vec4 blurred = kernel_3_4 * texValueNeg34 + kernel_1_2 * texValueNeg12 + kernel_0 * texValue0 + kernel_1_2 * texValuePos12 + kernel_3_4 * texValuePos34;

			gl_FragColor = blurred;//mix(texValue0, blurred, 0.5 + sin(2.0 * u_Time) + 0.5);
		}
		
	#endif
		
#endif
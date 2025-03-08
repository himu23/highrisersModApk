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
	
		lowp float Luminance(lowp vec3 colour)
		{
			lowp vec3 luminanceFunc = vec3(0.299, 0.587, 0.114);
			lowp float luminance = dot(luminanceFunc, colour);
			return luminance;
		}

		lowp float Highlight(lowp vec3 colour)
		{
			lowp float luminance = Luminance(colour);
			lowp float alpha = clamp((luminance - 0.25) / 0.47, 0.0, 1.0);
			return alpha;
		}

		lowp vec3 Lighten(lowp vec3 colour)
		{
			lowp vec3 lowpwhite = vec3(1.0, 1.0, 1.0);
			return mix(colour, lowpwhite, 0.5);
		}
				
		void main()
		{
			lowp vec3 texValue = texture2D(u_Texture, v_TexCoords).rgb;
			lowp vec3 lightened = Lighten(texValue);
			lowp float highlight = Highlight(texValue.rgb);
			lowp vec4 result = vec4(lightened * highlight, highlight);
			gl_FragColor = result;
		}
		
	#endif
		
#endif
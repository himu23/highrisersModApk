#ifdef Z_SL_OPENGLES

	// --- Uniforms

	uniform highp mat4 u_ModelViewProjection;

	uniform highp mat4 u_Model; 

	uniform lowp sampler2D u_ScreenTexture;

	uniform lowp sampler2D u_Texture;

	uniform lowp sampler2D u_SineTexture;

	uniform highp vec2 u_Offset1;

	uniform highp vec2 u_SinOffset1;

	uniform highp vec2 u_SinOffsetXByPosition1;

	uniform highp vec2 u_SinOffsetYByPosition1;

	uniform highp vec2 u_Offset2;

	uniform highp vec2 u_SinOffset2;

	uniform highp vec2 u_SinOffsetXByPosition2;

	uniform highp vec2 u_SinOffsetYByPosition2;

	uniform highp float u_ReflectionY;

	uniform highp float u_ReflectionHeight;

	uniform lowp float u_ReflectionAlpha;

	uniform highp float u_ScreenTopY;

	uniform highp float u_ScreenFadeHeight;

	uniform lowp vec4 u_ColourKey;
		

	// --- Attributes
	
	#ifdef Z_SHADER_VERTEX 

		attribute highp vec4 a_Position;

		attribute highp vec2 a_TexCoords;
	
		attribute highp vec2 a_TexCoords2;
		
	#endif
		
	// --- Varyings
	
	varying highp vec2 v_TexCoords2;
	varying highp vec2 v_TexCoords;
	varying highp vec2 v_SinOffsetX1;
	varying highp vec2 v_SinOffsetY1;
	varying highp vec2 v_SinOffsetX2;
	varying highp vec2 v_SinOffsetY2;
	varying lowp float v_Alpha;
	varying lowp float v_ScreenFadeAlpha;
		
	// --- Main
	
	#ifdef Z_SHADER_VERTEX

		void main()
		{
			gl_Position = u_ModelViewProjection * a_Position;
			highp vec4 worldPosition = u_Model * a_Position;

			v_SinOffsetX1 = vec2(u_SinOffset1.x + dot(u_SinOffsetXByPosition1, worldPosition.xy), 0.0);
			v_SinOffsetY1 = vec2(u_SinOffset1.y + dot(u_SinOffsetYByPosition1, worldPosition.xy), 0.0);
			v_SinOffsetX2 = vec2(u_SinOffset2.x + dot(u_SinOffsetXByPosition2, worldPosition.xy), 0.0);
			v_SinOffsetY2 = vec2(u_SinOffset2.y + dot(u_SinOffsetYByPosition2, worldPosition.xy), 0.0);

			v_TexCoords2 = a_TexCoords2;
			v_TexCoords = a_TexCoords;

			highp float offset = u_ReflectionY - worldPosition.y;
			v_Alpha = 1.0 - offset / u_ReflectionHeight;

			highp float reflectedY = u_ReflectionY + offset;
			highp float screenFadeOffset = u_ScreenTopY - reflectedY;
			v_ScreenFadeAlpha = screenFadeOffset / u_ScreenFadeHeight;
		}
		
	#else
	
		lowp float Luminance(lowp vec3 colour)
		{
			lowp vec3 luminanceFunc = vec3(0.299, 0.587, 0.114);
			lowp float luminance = dot(luminanceFunc, colour);
			return luminance;
		}

		lowp vec3 ColourKey(lowp vec3 colour, lowp vec3 keyColour, lowp float intensity)
		{
			lowp float luminance = Luminance(colour);
			return mix(colour, luminance * keyColour, intensity);
		}

		void main()
		{
			lowp float texValue = texture2D(u_Texture, v_TexCoords).r;

			highp vec2 screenTexCoords = v_TexCoords2;
			
			lowp float sineTexValueX1 = texture2D(u_SineTexture, v_SinOffsetX1).a;
			lowp float sineTexValueY1 = texture2D(u_SineTexture, v_SinOffsetY1).a;
            // lowp float sineValue = (2.0 * sineTexValue - 1.0); // 2.0 overflows lowp.
            lowp float sineValueX1 = (sineTexValueX1 - 1.0) + sineTexValueX1;
            lowp float sineValueY1 = (sineTexValueY1 - 1.0) + sineTexValueY1;
			screenTexCoords.x += texValue * u_Offset1.x * sineValueX1;
			screenTexCoords.y += texValue * u_Offset1.y * sineValueY1;
			
			lowp float sineTexValueX2 = texture2D(u_SineTexture, v_SinOffsetX2).a;
			lowp float sineTexValueY2 = texture2D(u_SineTexture, v_SinOffsetY2).a;
            // lowp float sineValue = (2.0 * sineTexValue - 1.0); // 2.0 overflows lowp.
            lowp float sineValueX2 = (sineTexValueX2 - 1.0) + sineTexValueX2;
            lowp float sineValueY2 = (sineTexValueY2 - 1.0) + sineTexValueY2;
			screenTexCoords.x += texValue * u_Offset2.x * sineValueX2;
			screenTexCoords.y += texValue * u_Offset2.y * sineValueY2;

			lowp vec3 screenTexValue = texture2D(u_ScreenTexture, screenTexCoords).rgb;

			lowp vec3 withColourKey = ColourKey(screenTexValue, u_ColourKey.rgb, u_ColourKey.a);

			lowp float alpha = clamp(v_Alpha, 0.0, 1.0);

			lowp float screenFadeAlpha = clamp(v_ScreenFadeAlpha, 0.0, 1.0);

			alpha = alpha * screenFadeAlpha * u_ReflectionAlpha;

			gl_FragColor = vec4(withColourKey, texValue * alpha);

			//gl_FragColor = vec4(screenFadeAlpha, screenFadeAlpha, screenFadeAlpha, 0.5);

			//gl_FragColor = vec4(v_Alpha, v_Alpha, v_Alpha, 1.0);
			//gl_FragColor = vec4(sineTexValue, sineTexValue, sineTexValue, 1.0);
		}
		
	#endif
		
#endif
#ifdef Z_SL_OPENGLES

	#define USE_SPOTLIGHT
	
    uniform lowp sampler2D u_OverlayTexture0;
    uniform lowp sampler2D u_OverlayTexture1;
    uniform lowp sampler2D u_OverlayTexture2;
	
	uniform mediump float u_BloomIntensity;
	
	uniform lowp vec4 u_OverlayColour;

	#ifdef USE_SPOTLIGHT
	uniform lowp sampler2D u_SpotlightTexture;
	uniform highp vec2 u_SpotlightTexCoordsOffset;
	uniform highp vec2 u_SpotlightTexCoordsScale;
	#endif

	uniform lowp float u_Intensity;
	uniform lowp float u_SpotlightIntensity;
		
	// --- Attributes
	
	#ifdef Z_SHADER_VERTEX 

		attribute highp vec4 a_Position;
	
		attribute highp vec2 a_TexCoords;
		
	#endif
		
	// --- Varyings
	
	varying highp vec2 v_TexCoords;
	#ifdef USE_SPOTLIGHT
	varying highp vec2 v_SpotlightTexCoords;
	#endif

	// --- Main
	
	#ifdef Z_SHADER_VERTEX

		void main()
		{
			gl_Position = a_Position;
			v_TexCoords = a_TexCoords;
			#ifdef USE_SPOTLIGHT
			v_SpotlightTexCoords = (a_TexCoords + u_SpotlightTexCoordsOffset) * u_SpotlightTexCoordsScale;
			#endif
		}
		
	#else

		lowp vec4 PreMix(lowp vec4 a, lowp vec4 b)
		{
			return (1.0 - b.a) * a + b;
		}

		lowp vec3 PreMix(lowp vec3 a, lowp vec4 b)
		{
			return (1.0 - b.a) * a + b.rgb;
		}

		void main()
		{
            lowp vec4 overlay0 = texture2D(u_OverlayTexture0, v_TexCoords);
            lowp vec4 overlay1 = texture2D(u_OverlayTexture1, v_TexCoords);
            lowp vec4 overlay2 = texture2D(u_OverlayTexture2, v_TexCoords);

			lowp vec4 bloomOverlay = 0.3 * overlay0 + 0.3 * overlay1 + 0.4 * overlay2;
			
			#ifdef USE_SPOTLIGHT
			lowp float spotlightValue = texture2D(u_SpotlightTexture, v_SpotlightTexCoords).r; // Note: spotlight is black in the spotlight and white elsewhere, so we can use the normal white texture when there's no spotlight.
			spotlightValue = mix(1.0, spotlightValue, u_SpotlightIntensity);
			#endif
			
			lowp vec4 overlayColour = u_OverlayColour;
			lowp vec4 withColour = PreMix(bloomOverlay, overlayColour);

			#ifdef USE_SPOTLIGHT
			lowp float intensity = u_Intensity * spotlightValue;
			#else
			lowp float intensity = u_Intensity;
			#endif

			lowp vec4 withIntensity = withColour * intensity;
			gl_FragColor = withIntensity;
		}
		
		
	#endif
		
#endif
#ifdef Z_SL_OPENGLES

	// --- Uniforms

	uniform highp mat4 u_ModelViewProjection;

	uniform lowp sampler2D u_Texture;

	uniform lowp sampler2D u_RefractionMask;

	uniform lowp sampler2D u_ReflectionMask;

	uniform lowp sampler2D u_ScreenTexture;

	uniform lowp vec4 u_Colour;

	uniform highp vec2 u_RefractionMin;

	uniform highp vec2 u_RefractionMax;

	uniform lowp float u_RefractionAlpha;

	uniform lowp float u_RefractionAdd;

	uniform highp vec2 u_ReflectionMin;

	uniform highp vec2 u_ReflectionMax;

	uniform lowp float u_ReflectionAlpha;

	uniform lowp float u_ReflectionAdd;

	// --- Attributes
	
	#ifdef Z_SHADER_VERTEX 

		attribute highp vec4 a_Position;

		attribute highp vec2 a_TexCoords;  // Sprite
	
		attribute highp vec2 a_TexCoords2; // Refraction mask
	
		attribute highp vec2 a_TexCoords3; // Reflection mask
	
		attribute highp vec2 a_TexCoords4; // Screen
		
	#endif
		
	// --- Varyings
	
	varying highp vec2 v_SpriteTexCoords;
	varying highp vec2 v_RefractionMaskTexCoords;
	varying highp vec2 v_ReflectionMaskTexCoords;
	varying highp vec2 v_ScreenTexCoords;
		
	// --- Main
	
	#ifdef Z_SHADER_VERTEX

		void main()
		{
			gl_Position = u_ModelViewProjection * a_Position;
			
			v_SpriteTexCoords = a_TexCoords;
			v_RefractionMaskTexCoords = a_TexCoords2;
			v_ReflectionMaskTexCoords = a_TexCoords3;
			v_ScreenTexCoords = a_TexCoords4;
		}
		
	#else

		// Converts an RGBA for normal blending to premultiplied.
		lowp vec4 toPremul(lowp vec4 normal)
		{
			return vec4(normal.rgb * normal.a, normal.a);
		}
	
		// Blends two values with pre-multiplied alpha.
		lowp vec4 premix(lowp vec4 a, lowp vec4 b)
		{
			return (1.0 - b.a) * a + b;
		}

		lowp vec4 refract(lowp vec4 mask, lowp float alpha, lowp float add, highp vec2 offsetMin, highp vec2 offsetMax)
		{
			lowp vec2 normal = mask.rg;
			add *= mask.b;
			alpha *= mask.a;

			highp vec2 offset;
			offset.x = mix(offsetMin.x, offsetMax.x, normal.x);
			offset.y = mix(offsetMin.y, offsetMax.y, normal.y);
			lowp vec3 screenTexValue = texture2D(u_ScreenTexture, v_ScreenTexCoords + offset).rgb;

			return vec4(screenTexValue * (alpha + add), alpha);
		}

		void main()
		{
			lowp vec4 texValue = texture2D(u_Texture, v_SpriteTexCoords);
			lowp vec4 refractionMaskTexValue = texture2D(u_RefractionMask, v_RefractionMaskTexCoords);
			lowp vec4 reflectionMaskTexValue = texture2D(u_ReflectionMask, v_RefractionMaskTexCoords);
			lowp vec3 screenTexValue = texture2D(u_ScreenTexture, v_ScreenTexCoords).rgb;

			lowp vec4 refractionPart = refract(refractionMaskTexValue, u_RefractionAlpha, u_RefractionAdd, u_RefractionMin, u_RefractionMax);
			lowp vec4 spritePart = toPremul(u_Colour * texValue);
			lowp vec4 reflectionPart = refract(reflectionMaskTexValue, u_ReflectionAlpha, u_ReflectionAdd, u_ReflectionMin, u_ReflectionMax);
			
			lowp vec4 result = refractionPart;
			result = premix(result, spritePart);
			result = premix(result, reflectionPart);

			gl_FragColor = result;
		}
		
	#endif
		
#endif
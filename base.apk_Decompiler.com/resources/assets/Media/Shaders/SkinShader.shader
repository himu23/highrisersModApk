#ifdef Z_SL_OPENGLES

	uniform highp mat4 u_ModelViewProjection;
	uniform highp mat4 u_ModelView;
	uniform lowp vec4 u_Colour;  
	uniform lowp sampler2D u_Texture;
	uniform lowp vec3 u_SkinMod;

	#ifdef Z_SHADER_VERTEX 

		attribute highp vec4 a_Position;
		attribute lowp vec4 a_Colour;
		attribute highp vec2 a_TexCoords;
		
	#endif
		
	varying lowp vec4 v_Colour;
	varying highp vec2 v_TexCoords;
		
	#ifdef Z_SHADER_VERTEX

		void main()
		{
			highp vec4 projPosition = u_ModelViewProjection * a_Position;
			gl_Position = projPosition;
			v_Colour = u_Colour * a_Colour;
			v_TexCoords = a_TexCoords;
		}
		
	#else

		vec3 rgb2hsv(vec3 c)
		{
			vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);
			vec4 p = c.g < c.b ? vec4(c.bg, K.wz) : vec4(c.gb, K.xy);
			vec4 q = c.r < p.x ? vec4(p.xyw, c.r) : vec4(c.r, p.yzx);
			float d = q.x - min(q.w, q.y);
			float e = 1.0e-10;
			return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);
		}

		vec3 hsv2rgb(vec3 c)
		{
			vec4 K = vec4(1.0, 2.0 / 3.0, 1.0 / 3.0, 3.0);
			vec3 p = abs(fract(c.xxx + K.xyz) * 6.0 - K.www);
			return c.z * mix(K.xxx, clamp(p - K.xxx, 0.0, 1.0), c.y);
		}

		void main()
		{
			lowp vec4 texValue = texture2D(u_Texture, v_TexCoords);
			lowp vec3 hsv = rgb2hsv(texValue.rgb);
			if (hsv.x >= 0.04 && hsv.x <= 0.11 && hsv.y < 0.7)
			{
				hsv.x += u_SkinMod.x;
				hsv.y *= u_SkinMod.y;
				hsv.z *= u_SkinMod.z;
				texValue.rgb = hsv2rgb(hsv);
			}
			gl_FragColor = v_Colour * texValue;
		}
		
	#endif
		
#endif
#ifdef Z_SL_OPENGLES

	// --- Uniforms

	/** The combined model/view/projection matrix. 
	 *  	(Global)
	 */
	uniform highp mat4 u_ModelViewProjection;

	/** The combined model/view matrix. 
	 *  	(Global)
	 */
	uniform highp mat4 u_ModelView;

	/** Clipping Plane in post-projection space.
	 *		(Global)
	 *  	Default: (0, 0, 0, 1)
	 */
	//uniform highp vec4 u_ClipPlane;  

	/** Colour
	 *		(Standard Material)
	 *  	Default: (1, 1, 1, 1)
	 */
	uniform lowp vec4 u_Colour;  

	/** Time
	 *		(Global)
	 *  	Time is the same across all materials so may be used to synchronize effects.
	 *  
	 */
	//uniform highp float u_Time;  

	/** Texture
	 *		(Standard Material)
	 *  	Default: (1, 1, 1, 1)
	 */
	uniform lowp sampler2D u_Texture;  
		

	// --- Attributes
	
	#ifdef Z_SHADER_VERTEX 

		/** Position
		 *  	(Standard Vertex Buffer)
		 *  	Default: (0, 0, 0, 1)
		 */
		attribute highp vec4 a_Position;
	
		/** Colour
		 *  	(Standard Vertex Buffer)
		 *  	Default: (1, 1, 1, 1)
		 */
		attribute lowp vec4 a_Colour;
	
		/** Texture coordinates
		 *  	(Standard Vertex Buffer)
		 *  	Default: (0, 0)
		 */
		attribute highp vec2 a_TexCoords;
		
	#endif
		
	// --- Varyings
	
	varying lowp vec4 v_Colour;
	varying highp vec2 v_TexCoords;
	//varying highp float v_ClipDistance;
		
	// --- Main
	
	#ifdef Z_SHADER_VERTEX

		void main()
		{
			highp vec4 projPosition = u_ModelViewProjection * a_Position;
			//highp vec4 eyePosition = u_ModelView * a_Position;
			gl_Position = projPosition;
			v_Colour = u_Colour * a_Colour;
			v_TexCoords = a_TexCoords;
			//v_ClipDistance = dot(eyePosition, u_ClipPlane);
		}
		
	#else

		void main()
		{
			lowp vec4 texValue = texture2D(u_Texture, v_TexCoords);
			gl_FragColor = v_Colour * texValue;
			/*if (v_ClipDistance < 0.0)
			{
				// HACK - Should be discard, but we never use depth and clipping so far...
				gl_FragColor.a = 0.0;
			}*/
		}
		
	#endif
		
#endif
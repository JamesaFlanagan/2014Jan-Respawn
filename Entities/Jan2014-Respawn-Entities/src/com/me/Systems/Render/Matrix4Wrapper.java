package com.me.Systems.Render;

import com.badlogic.gdx.math.Matrix4;

public class Matrix4Wrapper implements IMatrix4 {

	public Matrix4Wrapper(Matrix4 matrix)
	{
		Matrix = matrix;
	}
	
	public final Matrix4 Matrix;
	
}

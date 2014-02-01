package com.me.Systems.Render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.me.ScreenView;

public class CameraWrapper implements ICamera {
	
	private final OrthographicCamera _camera;
	
	public CameraWrapper()
	{
		_camera = new OrthographicCamera(1, Gdx.graphics.getHeight()/Gdx.graphics.getWidth());
		_camera.setToOrtho(false, ScreenView.Width, ScreenView.Height);		
	}
	
	@Override
	public IMatrix4 Combined() {
		return new Matrix4Wrapper(_camera.combined);
	}

}

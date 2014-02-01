package com.me.Systems.Render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class RenderRequirements implements IRenderRequirements {

	TextureAtlasWrapper _atlas = new TextureAtlasWrapper(new TextureAtlas(Gdx.files.internal("textureAtlas.atlas")));
	ISpriteBatch _batch = new SpriteBatchWrapper(new SpriteBatch());
	ICamera _camera = new CameraWrapper();
	
	@Override
	public ITextureAtlas GetTextureAtlas() {
		return _atlas;
	}

	@Override
	public ISpriteBatch GetSpriteBatch() {
		return _batch;
	}

	@Override
	public ICamera GetCamera() {
		return _camera;
	}

}

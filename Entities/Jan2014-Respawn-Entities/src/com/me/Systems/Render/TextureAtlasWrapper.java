package com.me.Systems.Render;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class TextureAtlasWrapper implements ITextureAtlas {

	private final TextureAtlas _atlas;
	
	public TextureAtlasWrapper(TextureAtlas atlas)
	{
		_atlas = atlas;
	}
	
	@Override
	public ITextureRegion findRegion(String name) {
		return new TextureRegionWrapper(_atlas.findRegion(name));
	}

	@Override
	public void Dispose() {
		_atlas.dispose();
	}

}

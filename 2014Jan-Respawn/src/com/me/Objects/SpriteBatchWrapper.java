package com.me.Objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.me.Interfaces.ISpriteBatch;
import com.me.Interfaces.ITextureRegion;

public class SpriteBatchWrapper implements ISpriteBatch{

	private final SpriteBatch _batch;
	
	public SpriteBatchWrapper(SpriteBatch batch)
	{
		_batch = batch;
	}
	
	@Override
	public void Draw(ITextureRegion region, int x, int y, int width, int height) {
		
		TextureRegion textureRegion = ((TextureRegionWrapper) region).Region;
		
		_batch.draw(textureRegion, x,y, width,height);
	}

}

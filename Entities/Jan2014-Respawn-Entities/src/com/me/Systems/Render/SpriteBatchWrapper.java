package com.me.Systems.Render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

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

	@Override
	public void SetProjectionMatrix(IMatrix4 matrix) {
		_batch.setProjectionMatrix(((Matrix4Wrapper) matrix).Matrix); 
	}

	@Override
	public void Begin() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		_batch.begin();
		
	}

	@Override
	public void End() {
		_batch.end();		
	}

	@Override
	public void Dispose() {
		_batch.dispose();		
	}

}

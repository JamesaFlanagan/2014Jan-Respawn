package com.me.Objects;

import com.me.Interfaces.ISpriteBatch;
import com.me.Interfaces.ITextureDrawer;
import com.me.Interfaces.ITextureRegion;

public class TextureDrawer implements ITextureDrawer{

	public static final int TileSize = 32;
	public final ISpriteBatch _batch; 
	
	public TextureDrawer(ISpriteBatch batch)
	{
		_batch = batch;
	}

	@Override
	public void TileDraw(ITextureRegion textureregion, int x, int y) {
		
		Draw(textureregion, x* TileSize, y * TileSize, TileSize, TileSize);
	}
	
	@Override
	public void Draw(ITextureRegion textureRegion, int x, int y, int width, int height)
	{
		_batch.Draw(textureRegion, x , y , width, height);
	}	

}

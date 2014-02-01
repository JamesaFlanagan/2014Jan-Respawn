package com.me.Interfaces;


public interface ITextureDrawer {

	void TileDraw(ITextureRegion textureregion, int x, int y);
	
	void Draw(ITextureRegion textureRegion, int x, int y, int width, int height);
	
}

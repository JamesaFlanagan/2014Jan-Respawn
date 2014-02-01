package com.me.Systems.Render;

public interface ISpriteBatch {

	void Draw(ITextureRegion region, int x, int y, int width, int height);
	
	void SetProjectionMatrix(IMatrix4 matrix);
		
	void Begin();
	
	void End();
	
	void Dispose();
}

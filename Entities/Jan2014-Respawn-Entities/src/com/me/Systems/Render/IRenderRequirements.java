package com.me.Systems.Render;

public interface IRenderRequirements {
	
	ITextureAtlas GetTextureAtlas();
	ISpriteBatch GetSpriteBatch();	
	ICamera GetCamera();
}

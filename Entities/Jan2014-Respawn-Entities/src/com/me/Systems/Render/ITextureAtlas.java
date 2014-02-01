package com.me.Systems.Render;

public interface ITextureAtlas {

	ITextureRegion findRegion(String name);
	
	void Dispose();
}

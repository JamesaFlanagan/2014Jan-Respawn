package com.me.Systems.Render;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureRegionWrapper implements ITextureRegion {

	public final TextureRegion Region;
	
	public TextureRegionWrapper(TextureRegion region)
	{
		Region = region;
	}
		
	
}

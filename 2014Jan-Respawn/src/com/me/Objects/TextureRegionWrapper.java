package com.me.Objects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.me.Interfaces.ITextureRegion;

public class TextureRegionWrapper implements ITextureRegion {

	public final TextureRegion Region;
	
	public TextureRegionWrapper(TextureRegion region)
	{
		Region = region;
	}
	
	
	
}

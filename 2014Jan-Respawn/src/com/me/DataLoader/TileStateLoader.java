package com.me.DataLoader;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;
import com.me.Interfaces.ITextureDrawer;
import com.me.Interfaces.ITextureRegion;
import com.me.Interfaces.ITileState;
import com.me.Objects.TextureRegionWrapper;

class TileStateLoader {

	private final TextureAtlas _atlas;
	private final ITextureDrawer _drawer;
	
	public TileStateLoader(TextureAtlas atlas, ITextureDrawer drawer)
	{
		_atlas = atlas;
		_drawer = drawer;
	}
	
	public TileState CreateTileState(String name, boolean blocks)
	{	
		Array<AtlasRegion> atlasRegions = _atlas.findRegions(name);
		
		ITextureRegion[] regions = new ITextureRegion[atlasRegions.size];
		
		for (int i = 0; i < atlasRegions.size; ++i)
		{			
			regions[i] = new TextureRegionWrapper(atlasRegions.get(i));
		}
		
		return new TileState(name, regions, _drawer, blocks);
	}
	
}

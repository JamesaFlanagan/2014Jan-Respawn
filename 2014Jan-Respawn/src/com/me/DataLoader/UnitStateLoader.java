package com.me.DataLoader;

import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;
import com.me.Actions.RespawnUnit;
import com.me.Interfaces.IAction;
import com.me.Interfaces.IActionManager;
import com.me.Interfaces.ITextureDrawer;
import com.me.Interfaces.ITextureRegion;
import com.me.Interfaces.IUnitAction;
import com.me.Interfaces.IUnitState;
import com.me.Objects.TextureRegionWrapper;

class UnitStateLoader {

	HashMap<String, IUnitState> _index = new HashMap<String, IUnitState>();
	
	public UnitStateLoader(TextureAtlas atlas, ITextureDrawer drawer, IActionManager manager)
	{
		UnitState player =  LoadState("Player", atlas, drawer);
		player.SetEnterActions(new IUnitAction[]{ new RespawnUnit(manager, "Spikes"), new RespawnUnit(manager, "BloodySpikes")});
		player.SetCollideActions(new IAction[]{new RespawnUnit(manager)});
		
		_index.put("Player", player);	
		
		
		_index.put("Soldier", LoadState("Soldier", atlas, drawer));
	}
	
	public IUnitState GetUnitState(String key)
	{
		return _index.get(key);
	}	
	
	private UnitState LoadState(String name, TextureAtlas atlas, ITextureDrawer drawer)
	{		 
		Array<AtlasRegion> atlasRegions = atlas.findRegions(name);
		
		ITextureRegion[] regions = new ITextureRegion[atlasRegions.size]; 
		
		for(int i = 0; i < atlasRegions.size; ++i)
		{
			regions[i] = new TextureRegionWrapper(atlasRegions.get(i));
		}
		
		return new UnitState(name, regions, drawer);
	}
}

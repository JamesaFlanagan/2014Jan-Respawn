package com.me.DataLoader;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.me.Actions.RespawnUnit;
import com.me.Actions.SpikesTriggeredAction;
import com.me.Actions.StateTransition;
import com.me.Interfaces.IAction;
import com.me.Interfaces.IActionManager;
import com.me.Interfaces.ITextureDrawer;

class TileStateManager {

	public final TileStateHashMap Index = new TileStateHashMap();
	
	private final TileStateLoader _loader;
	
	public TileStateManager(TextureAtlas atlas, ITextureDrawer drawer, IActionManager manager)
	{
		_loader = new TileStateLoader(atlas,drawer);
	
		LoadStates(manager);
	}
	
	private void LoadStates(IActionManager manager)
	{
		Index.Add("Floor", _loader.CreateTileState("Floor", false));
		Index.Add("Void", _loader.CreateTileState("Void", true));
		
		Index.Add("BloodySpikes", _loader.CreateTileState("BloodySpikes", false));
		
		TileState spikes = _loader.CreateTileState("Spikes", false);
		spikes.SetEntryActions(new IAction[]{ new SpikesTriggeredAction(manager), new StateTransition(manager, Index.Get("BloodySpikes"))});
		
		Index.Add("Spikes", spikes);
	}
	
}

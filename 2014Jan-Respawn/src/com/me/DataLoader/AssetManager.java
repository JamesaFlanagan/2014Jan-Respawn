 package com.me.DataLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.me.Input.KeyPad;
import com.me.Input.PlayerInputProcessor;
import com.me.Interfaces.IActionManager;
import com.me.Interfaces.ISpriteBatch;
import com.me.Interfaces.ITextureDrawer;
import com.me.Interfaces.ITileState;
import com.me.Interfaces.IUnitState;
import com.me.Objects.TextureDrawer;

public class AssetManager {
	
	private final TileStateManager _tileManager; 
	private final UnitStateLoader _unitStateManager;
	private final TextureAtlas _atlas;
	private final ITextureDrawer _drawer;
	
	public AssetManager(ISpriteBatch batch, IActionManager manager)
	{
		_atlas = new TextureAtlas(Gdx.files.internal("textureAtlas.atlas"));
		_drawer = new TextureDrawer(batch);
		
		_tileManager = new TileStateManager(_atlas, _drawer, manager);
		_unitStateManager = new UnitStateLoader(_atlas, _drawer, manager);
	}	

	public ITileState GetTileState(String key)
	{
		return _tileManager.Index.Get(key);
	}
	
	public IUnitState GetUnitState(String key)
	{
		return _unitStateManager.GetUnitState(key);
	}
	
	public PlayerInputProcessor GetPlayerInput(int x, int y, int width, int height)
	{
		return new PlayerInputProcessor(new KeyPad(_atlas, _drawer, x, y, width, height));
	}
	
}

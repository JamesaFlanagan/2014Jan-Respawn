package com.me.Objects;

import com.me.Interfaces.ITile;
import com.me.Levels.ITileData;

public class TileData implements ITileData {

	private final ITile _tile;
	private final Location _location;
	
	
	public TileData(ITile tile, Location location)
	{
		_tile = tile;
		_location = location;
	}
	
	@Override
	public ITile GetTile() {
		return _tile;
	}

	@Override
	public Location GetLocation() {
		return _location;
	}  

}

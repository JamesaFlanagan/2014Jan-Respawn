package com.me.Levels;

import com.me.DataLoader.AssetManager;
import com.me.Objects.Tile;
import com.me.Objects.Unit;
import com.me.Objects.Location;

public class Level2 extends BaseLevel {

	public Level2(AssetManager manager) {
		super(manager);
		
	}

	@Override
	protected void CreateLevel() {
		
		Grid[5][1] = new Tile(Manager.GetTileState("Spikes"));
		Grid[5][2] = new Tile(Manager.GetTileState("Floor"));
		Grid[5][3] = new Tile(Manager.GetTileState("Floor"));
		Grid[5][4] = new Tile(Manager.GetTileState("Floor"));
		Grid[5][5] = new Tile(Manager.GetTileState("Floor"));
		Grid[5][6] = new Tile(Manager.GetTileState("Floor"));
		Grid[5][7] = new Tile(Manager.GetTileState("Floor"));
		Grid[5][8] = new Tile(Manager.GetTileState("Spikes"));		
	}

	@Override
	public int GetNumberOfSpikesOnLevel() {
		return 2;
	}

	@Override
	protected IUnitData[] CreateEnemies() {		
		return new IUnitData[0];
	}

	@Override
	public Location GetRespawnPoint() {
		return new Location(4,5);
	}
	
}

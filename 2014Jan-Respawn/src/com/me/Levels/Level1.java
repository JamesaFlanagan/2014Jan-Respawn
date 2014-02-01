package com.me.Levels;

import com.me.DataLoader.AssetManager;
import com.me.Objects.Tile;
import com.me.Objects.Location;

public class Level1 extends BaseLevel {

	public Level1(AssetManager manager) {
		super(manager);
	}
	
	@Override
	protected void CreateLevel() {
		
		Grid[6][5] = new Tile(Manager.GetTileState("Floor"));
		Grid[5][5] = new Tile(Manager.GetTileState("Floor"));
		Grid[4][5] = new Tile(Manager.GetTileState("Floor"));
		Grid[3][5] = new Tile(Manager.GetTileState("Floor"));
		Grid[7][5] = new Tile(Manager.GetTileState("Floor"));
		Grid[8][5] = new Tile(Manager.GetTileState("Spikes"));
	}

	@Override
	public int GetNumberOfSpikesOnLevel() {
		return 1;
	}

	@Override
	protected IUnitData[] CreateEnemies() {		
		return new IUnitData[0];
	}

	@Override
	public Location GetRespawnPoint() {
		return new Location(5,3);
	}

}

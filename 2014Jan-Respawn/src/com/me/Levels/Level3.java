package com.me.Levels;

import com.me.DataLoader.AssetManager;
import com.me.Objects.Tile;
import com.me.Objects.Unit;
import com.me.Objects.UnitData;
import com.me.Objects.Location;

public class Level3 extends BaseLevel {

	public Level3(AssetManager manager) {
		super(manager);
	}

	@Override
	protected void CreateLevel() {
		
		Grid[1][5] = new Tile(Manager.GetTileState("Floor"));		
		
		Grid[2][5] = new Tile(Manager.GetTileState("Floor"));
		Grid[3][5] = new Tile(Manager.GetTileState("Floor"));
		Grid[4][5] = new Tile(Manager.GetTileState("Floor"));
		Grid[5][5] = new Tile(Manager.GetTileState("Floor"));
		Grid[6][5] = new Tile(Manager.GetTileState("Floor"));
		Grid[7][5] = new Tile(Manager.GetTileState("Floor"));
		Grid[8][5] = new Tile(Manager.GetTileState("Spikes"));
		
		Grid[3][6] = new Tile(Manager.GetTileState("Floor"));
		Grid[3][7] = new Tile(Manager.GetTileState("Floor"));
		Grid[4][7] = new Tile(Manager.GetTileState("Floor"));
		Grid[5][7] = new Tile(Manager.GetTileState("Floor"));
		Grid[6][7] = new Tile(Manager.GetTileState("Floor"));
		Grid[7][7] = new Tile(Manager.GetTileState("Floor"));
		Grid[7][6] = new Tile(Manager.GetTileState("Floor"));
	}

	@Override
	public int GetNumberOfSpikesOnLevel() {
		return 1;
	}

	@Override
	protected IUnitData[] CreateEnemies() {
		return new IUnitData[]{new UnitData(new Unit(Manager.GetUnitState("Soldier")), new Location(5,5))} ;
	}

	@Override
	public Location GetRespawnPoint() {
		return new Location(5,1);
	}

}

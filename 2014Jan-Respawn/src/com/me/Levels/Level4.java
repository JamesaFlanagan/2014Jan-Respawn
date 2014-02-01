package com.me.Levels;

import com.me.AiModes.AIMoveHorizontally;
import com.me.DataLoader.AssetManager;
import com.me.Objects.Location;
import com.me.Objects.Tile;
import com.me.Objects.Unit;
import com.me.Objects.UnitData;

public class Level4 extends BaseLevel {

	public Level4(AssetManager manager) {
		super(manager);
		
	}

	@Override
	protected void CreateLevel() {
		
		Grid[3][5] = new Tile(Manager.GetTileState("Floor"));
		Grid[4][5] = new Tile(Manager.GetTileState("Floor"));
		Grid[5][5] = new Tile(Manager.GetTileState("Floor"));
		Grid[6][5] = new Tile(Manager.GetTileState("Floor"));
		Grid[7][5] = new Tile(Manager.GetTileState("Floor"));
		Grid[8][5] = new Tile(Manager.GetTileState("Spikes"));
		
		Grid[6][3] = new Tile(Manager.GetTileState("Floor"));
		Grid[6][4] = new Tile(Manager.GetTileState("Floor"));
		Grid[6][6] = new Tile(Manager.GetTileState("Floor"));
		Grid[6][7] = new Tile(Manager.GetTileState("Floor"));
	}

	@Override
	public int GetNumberOfSpikesOnLevel() {
		return 1;
	}

	@Override
	protected IUnitData[] CreateEnemies() {
		return new IUnitData[]{new UnitData(new Unit(Manager.GetUnitState("Soldier"), new AIMoveHorizontally(this, true)), new Location(7,6))};
	}

	@Override
	protected Location GetRespawnPoint() {
		return new Location(5,3);
	}

}

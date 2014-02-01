package com.me.Levels;

import com.me.AiModes.AIMoveVertically;
import com.me.DataLoader.AssetManager;
import com.me.Objects.Location;
import com.me.Objects.Tile;
import com.me.Objects.Unit;
import com.me.Objects.UnitData;

public class Level5 extends BaseLevel {

	public Level5(AssetManager manager) {
		super(manager);
	}

	@Override
	protected void CreateLevel() {
		
		Grid[5][1] = new Tile(Manager.GetTileState("Floor"));
		Grid[5][2] = new Tile(Manager.GetTileState("Floor"));
		Grid[5][3] = new Tile(Manager.GetTileState("Floor"));
		Grid[5][4] = new Tile(Manager.GetTileState("Floor"));
		Grid[5][5] = new Tile(Manager.GetTileState("Floor"));
		Grid[5][6] = new Tile(Manager.GetTileState("Floor"));
		Grid[5][7] = new Tile(Manager.GetTileState("Floor"));
		Grid[5][8] = new Tile(Manager.GetTileState("Floor"));
		Grid[5][9] = new Tile(Manager.GetTileState("Spikes"));
		
		Grid[6][4] = new Tile(Manager.GetTileState("Floor"));
		Grid[4][4] = new Tile(Manager.GetTileState("Floor"));
		Grid[3][4] = new Tile(Manager.GetTileState("Floor"));
		
		Grid[6][7] = new Tile(Manager.GetTileState("Floor"));
		Grid[4][7] = new Tile(Manager.GetTileState("Floor"));
		Grid[7][7] = new Tile(Manager.GetTileState("Floor"));
	}

	@Override
	public int GetNumberOfSpikesOnLevel() {
		return 1;
	}

	@Override
	protected IUnitData[] CreateEnemies() {
		return new IUnitData[]{
			
				new UnitData(new Unit(Manager.GetUnitState("Soldier"), new AIMoveVertically(this, true)), new Location(7,5)),
				new UnitData(new Unit(Manager.GetUnitState("Soldier"), new AIMoveVertically(this, false)), new Location(4,5))
			
		};
	}

	@Override
	protected Location GetRespawnPoint() {
		return new Location(1,5);
	}

	
}

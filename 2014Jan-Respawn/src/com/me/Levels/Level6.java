package com.me.Levels;

import com.me.AiModes.AIModeCircle;
import com.me.AiModes.AIMoveHorizontally;
import com.me.AiModes.AIMoveVertically;
import com.me.AiModes.Direction;
import com.me.DataLoader.AssetManager;
import com.me.Objects.Location;
import com.me.Objects.Tile;
import com.me.Objects.Unit;
import com.me.Objects.UnitData;

public class Level6 extends BaseLevel {

	public Level6(AssetManager manager) {
		super(manager);
	}

	@Override
	protected void CreateLevel() {
		
		Grid[1][1] = new Tile(Manager.GetTileState("Floor"));
		Grid[1][2] = new Tile(Manager.GetTileState("Floor"));
		Grid[1][3] = new Tile(Manager.GetTileState("Floor"));
		Grid[1][4] = new Tile(Manager.GetTileState("Floor"));
		Grid[1][5] = new Tile(Manager.GetTileState("Floor"));
		Grid[1][6] = new Tile(Manager.GetTileState("Floor"));
		Grid[1][7] = new Tile(Manager.GetTileState("Floor"));
		Grid[1][8] = new Tile(Manager.GetTileState("Floor"));
		
		Grid[8][1] = new Tile(Manager.GetTileState("Floor"));
		Grid[8][2] = new Tile(Manager.GetTileState("Floor"));
		Grid[8][3] = new Tile(Manager.GetTileState("Floor"));
		Grid[8][4] = new Tile(Manager.GetTileState("Floor"));
		Grid[8][5] = new Tile(Manager.GetTileState("Floor"));
		Grid[8][6] = new Tile(Manager.GetTileState("Floor"));
		Grid[8][7] = new Tile(Manager.GetTileState("Floor"));
		Grid[8][8] = new Tile(Manager.GetTileState("Floor"));
		
		Grid[2][1] = new Tile(Manager.GetTileState("Floor"));
		Grid[3][1] = new Tile(Manager.GetTileState("Floor"));
		Grid[4][1] = new Tile(Manager.GetTileState("Floor"));
		Grid[5][1] = new Tile(Manager.GetTileState("Floor"));
		Grid[6][1] = new Tile(Manager.GetTileState("Floor"));
		Grid[7][1] = new Tile(Manager.GetTileState("Floor"));
		
		Grid[2][8] = new Tile(Manager.GetTileState("Floor"));
		Grid[3][8] = new Tile(Manager.GetTileState("Floor"));
		Grid[4][8] = new Tile(Manager.GetTileState("Floor"));
		Grid[5][8] = new Tile(Manager.GetTileState("Floor"));
		Grid[6][8] = new Tile(Manager.GetTileState("Floor"));
		Grid[7][8] = new Tile(Manager.GetTileState("Floor"));
		
		Grid[0][5] = new Tile(Manager.GetTileState("Floor"));
		Grid[0][4] = new Tile(Manager.GetTileState("Floor"));
		
		Grid[5][0] = new Tile(Manager.GetTileState("Spikes"));
		Grid[9][5] = new Tile(Manager.GetTileState("Spikes"));
		Grid[5][9] = new Tile(Manager.GetTileState("Spikes"));
	}

	@Override
	public int GetNumberOfSpikesOnLevel() {
		return 3;
	}

	@Override
	protected IUnitData[] CreateEnemies() {
		// TODO Auto-generated method stub
		return new IUnitData[]
				{
					new UnitData(new Unit(Manager.GetUnitState("Soldier"), new AIModeCircle(this, Direction.Right)), new Location(5,8)),
					new UnitData(new Unit(Manager.GetUnitState("Soldier"), new AIModeCircle(this, Direction.Left)), new Location(3,1)),
					new UnitData(new Unit(Manager.GetUnitState("Soldier"), new AIModeCircle(this, Direction.Up)), new Location(1,6)),
					new UnitData(new Unit(Manager.GetUnitState("Soldier"), new AIModeCircle(this, Direction.Down)), new Location(8,3))
				};
				
	}

	@Override
	protected Location GetRespawnPoint() {
		return new Location(5,0);
	}

}

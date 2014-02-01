      package com.me.Levels;

import com.me.DataLoader.AssetManager;
import com.me.Interfaces.ITile;
import com.me.Interfaces.IUnit;
import com.me.Objects.Location;
import com.me.Objects.Tile;
import com.me.Objects.TileData;
import com.me.Objects.Unit;
import com.me.Objects.UnitData;

public abstract class BaseLevel implements ILevel{
	
	protected ITile[][] Grid;
	protected final AssetManager Manager;
	protected IUnitData[] Enemies;
	private int _numberOfSpikesTriggered = 0;
	protected IUnitData Player;
	
	public BaseLevel(AssetManager manager)
	{
		Manager = manager;
	}
	
	public void Draw()
	{
		for (int y = 0; y < Grid.length; ++y)
		{
			for (int x = 0; x < Grid[y].length; ++x)
			{
				ITile tile = Grid[y][x];
						
				tile.GetState().Draw(tile.GetCurrentFrame(), x, y);
				
				IUnit unit = tile.GetUnit();
				
				if (unit != null)
				{
					unit.GetState().Draw(unit.GetCurrentFrame(), x, y);
				}
			}
		}
	}
	
	public void GenerateLevel()
	{
		Grid =  new ITile[Height()][Width()];
		
		for (int y = 0; y < Grid.length; ++y)
		{
			for (int x = 0; x < Grid[y].length; ++x)
			{
				Grid[y][x] = new Tile(Manager.GetTileState("Void"));
			}
		}
		
		CreateLevel();
		
		Player = new UnitData(new Unit(Manager.GetUnitState("Player")), GetRespawnPoint());
		Grid[Player.GetLocation().Y] [Player.GetLocation().X].SetUnit(Player.GetUnit());
		
		Enemies = CreateEnemies();
		
		for (IUnitData data : Enemies){
			Grid[data.GetLocation().Y][data.GetLocation().X].SetUnit(data.GetUnit());
		}
		
		_numberOfSpikesTriggered = 0;
		
	}
	
	public void ClearLevel()
	{
		Grid = null;
	}
	
	protected abstract void CreateLevel();
	
	public abstract int GetNumberOfSpikesOnLevel();
	
	protected abstract IUnitData[] CreateEnemies();
	
	protected abstract Location GetRespawnPoint();
	
	public ITile GetRespawnTile()
	{
		Location location = GetRespawnPoint();
		return Grid[location.Y][location.X];
	}
	
	public void IncrementSpikesTriggered()
	{
		_numberOfSpikesTriggered += 1;
	}
	
	public int CurrentNumberOfSpikesTriggered()
	{
		return _numberOfSpikesTriggered; 
	}
	
	public int Width()
	{
		return 10;
	}
	
	public int Height()
	{
		return 10;
	}
	
	public IUnit GetPlayer()
	{
		return Player.GetUnit();
	}
	
	public boolean MoveUp(IUnit unit)
	{
		IUnitData data = GetUnitData(unit);
		
		return Move(data, data.GetLocation().X, data.GetLocation().Y + 1);
	}
	
	public boolean MoveDown(IUnit unit)
	{
		IUnitData data = GetUnitData(unit);
		
		return Move(data, data.GetLocation().X, data.GetLocation().Y - 1);
	}
	
	public boolean MoveLeft(IUnit unit)
	{	
		IUnitData data = GetUnitData(unit);
		
		return Move(data, data.GetLocation().X - 1, data.GetLocation().Y);
	}
	
	public boolean MoveRight(IUnit unit)
	{
		IUnitData data = GetUnitData(unit);
		
		return Move(data, data.GetLocation().X + 1, data.GetLocation().Y);
	}
	
	private boolean Move(IUnitData unit, int newX, int newY)
	{
		if (!InBounds(newX, newY)) return false;
		
		return Move(unit, GetTileData(Grid[newY][newX]));
	}
	
	public boolean Move(IUnit unit, ITile destination)
	{
		return Move(GetUnitData(unit), GetTileData(destination));
	}
	
	private boolean Move(IUnitData unit, ITileData destination)
	{
		if (!destination.GetTile().GetState().BlocksMovement())
		{			
			ITile tile = Grid[unit.GetLocation().Y][unit.GetLocation().X];
		
			if (destination.GetTile().GetUnit() != null && destination.GetTile().GetUnit() != unit.GetUnit())
			{
				tile.GetUnit().GetState().OnCollide(tile);
				destination.GetTile().GetUnit().GetState().OnCollide(destination.GetTile());
				
				return true; 
			}
			
			tile.SetUnit(null);
			
			destination.GetTile().SetUnit(unit.GetUnit());
			unit.SetLocation(destination.GetLocation());
			
			unit.GetUnit().GetState().OnEnter(destination.GetTile());		
			
			destination.GetTile().GetState().OnEnter(destination.GetTile());
			
			return true;
		}		
		
		return false;
	}    
	
	private IUnitData GetUnitData(IUnit unit)
	{
		if (Player.GetUnit() == unit) return Player;
		
		for(IUnitData enemy : Enemies)
		{
			if (enemy.GetUnit() == unit) return enemy;
		}
		
		return null;
	}
	
	private ITileData GetTileData(ITile tile)
	{
		for (int y = 0; y < Grid.length; ++y)
		{
			for (int x = 0; x < Grid[y].length; ++x)
			{
				if (Grid[y][x] == tile) return new TileData(tile, new Location( x,y));			
			}
		}
		
		return null;
	}
	
	private boolean InBounds(int x, int y)
	{
		return (x >= 0 && x < Width()) &&  (y >= 0 && y < Height());
	}
	
	public void ProcessEnemies()
	{
		for (IUnitData enemy : Enemies)
		{
			enemy.GetUnit().DoTurn();
		}
	}
}

package com.me.Levels;

import com.me.DataLoader.AssetManager;
import com.me.Interfaces.IUnit;

public class LevelList{

	BaseLevel[] _levels;
	int _index = -1;
	
	public LevelList(AssetManager assets)
	{
		_levels = new BaseLevel[]{new Level1(assets), new Level2(assets), new Level3(assets), new Level4(assets),
			new Level5(assets), new Level6(assets)
		
		};
	}
	
	public BaseLevel getNextLevel()
	{
		if (_index >= 0)_levels[_index].ClearLevel();
		
		++_index;
		
		BaseLevel level = _levels[_index];
		
		level.GenerateLevel();
		
		return level;
	}
	
	private BaseLevel CurrentLevel()
	{
		return _levels[_index];
	}
	
	private IUnit GetPlayer()
	{
		return CurrentLevel().GetPlayer();
	}
	
	public boolean NextLevelExists()
	{
		return _index + 1 < _levels.length;
	}

	public void Draw() {
		CurrentLevel().Draw();		
	}

	public boolean MoveUp() {
		return CurrentLevel().MoveUp(GetPlayer());
	}

	public boolean MoveDown() {
		return CurrentLevel().MoveDown(GetPlayer());
	}

	public boolean MoveLeft() {
		return CurrentLevel().MoveLeft(GetPlayer());
	}

	public boolean MoveRight() {
		return CurrentLevel().MoveRight(GetPlayer());
	}
	
	public boolean LevelCompleted()
	{
		return CurrentLevel().CurrentNumberOfSpikesTriggered() == CurrentLevel().GetNumberOfSpikesOnLevel();
	}
	
	public void ProcessEnemies()
	{
		CurrentLevel().ProcessEnemies();
	}
	
}

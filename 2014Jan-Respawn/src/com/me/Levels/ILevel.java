package com.me.Levels;

import com.me.Interfaces.ITile;
import com.me.Interfaces.IUnit;

public interface ILevel {

	public void Draw();
	public IUnit GetPlayer();
	public boolean MoveUp(IUnit unit);
	public boolean MoveDown(IUnit unit);
	public boolean MoveLeft(IUnit unit);
	public boolean MoveRight(IUnit unit);
	public boolean Move(IUnit unit, ITile destination);
	
}

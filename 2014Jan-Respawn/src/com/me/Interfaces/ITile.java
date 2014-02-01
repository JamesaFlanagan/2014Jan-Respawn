package com.me.Interfaces;


public interface ITile {

	ITileState GetState();
	
	void SetState(ITileState state);
	
	int GetCurrentFrame();
	
	void SetCurrentFrame(int frame);
	
	IUnit GetUnit();
	
	void SetUnit(IUnit unit);

}

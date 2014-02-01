package com.me.Interfaces;

public interface IUnit {
	
	IUnitState GetState();
	
	int GetCurrentFrame();
	
	void SetCurrentFrame(int frame);
	
	void DoTurn();
}

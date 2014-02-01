package com.me.Interfaces;



public interface ITileState extends IState{	
	
	boolean BlocksMovement();
	
	void OnEnter(ITile tile);
}

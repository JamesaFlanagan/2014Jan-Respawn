package com.me.Interfaces;

public interface IUnitState extends IState{
	
	void OnEnter(ITile tile);
	
	void OnCollide(ITile tile);	
}

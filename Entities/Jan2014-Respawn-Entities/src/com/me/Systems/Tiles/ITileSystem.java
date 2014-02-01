 package com.me.Systems.Tiles;

import com.artemis.Entity;

public interface ITileSystem {

	boolean HasTile(int x, int y);
	
	void MoveUnitTo(Entity unit, int x, int y);
	
}

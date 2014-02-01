package com.me.Levels;

import com.me.Interfaces.IUnit;
import com.me.Objects.Location;

public interface IUnitData {

	IUnit GetUnit();
	Location GetLocation();
	void SetLocation(Location location);
	
}

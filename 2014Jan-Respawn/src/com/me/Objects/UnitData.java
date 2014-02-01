package com.me.Objects;

import com.me.Interfaces.IUnit;
import com.me.Levels.IUnitData;

public class UnitData implements IUnitData {

	private final IUnit _unit;
	private Location _location;
	
	public UnitData(IUnit unit, Location location)
	{
		_unit = unit;
		_location = location;
	}
	
	@Override
	public IUnit GetUnit() {
		return _unit;
	}

	@Override
	public Location GetLocation() {
		return _location;
	}

	@Override
	public void SetLocation(Location location) {
		_location = location;
	}

}

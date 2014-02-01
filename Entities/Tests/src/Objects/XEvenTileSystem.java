package Objects;

import com.artemis.Entity;
import com.me.Systems.Tiles.ITileSystem;

public class XEvenTileSystem implements ITileSystem {

	public Entity Unit;
	public int X;
	public int Y;
	
	
	@Override
	public boolean HasTile(int x, int y) {
		return x % 2 == 0;
	}

	@Override
	public void MoveUnitTo(Entity unit, int x, int y) {
		Unit = unit;
		X = x;
		Y = y;		
	}

}

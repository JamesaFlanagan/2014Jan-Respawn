package Objects;

import com.artemis.Entity;
import com.me.Systems.Tiles.ITileSystem;

public class AllTileSystem implements ITileSystem {

	@Override
	public boolean HasTile(int x, int y) {
		return true;
	}

	@Override
	public void MoveUnitTo(Entity unit, int x, int y) {
		
		
	}

}

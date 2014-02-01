package Tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ LibGdxRenderSystemTests.class, MovementSystemTests.class,
		PlayerInputTests.class, TileSystemTests.class, ScriptManagerTests.class,
		LevelWonSystemTests.class, AiSystemTests.class, UnitCollisionSystemTests.class })
public class AllTests {

}

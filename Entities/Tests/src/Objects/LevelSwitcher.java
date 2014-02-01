package Objects;

import com.me.Systems.Levels.ILevelSwitcher;

public class LevelSwitcher implements ILevelSwitcher {

	public boolean SwitchCalled = false;
	
	@Override
	public void SwitchToNextLevel() {
		SwitchCalled = true;
	}

}

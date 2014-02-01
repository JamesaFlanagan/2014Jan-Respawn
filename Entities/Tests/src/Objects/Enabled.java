package Objects;

import com.me.Systems.IEnabled;

public class Enabled implements IEnabled {

	public boolean Value;
	
	@Override
	public void SetEnabled(boolean enabled) {
		Value = enabled;
	}

}

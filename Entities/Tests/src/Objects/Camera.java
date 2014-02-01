package Objects;

import com.me.Systems.Render.ICamera;
import com.me.Systems.Render.IMatrix4;

public class Camera implements ICamera {

	@Override
	public IMatrix4 Combined() {
		
		return new Matrix4();
	}

}

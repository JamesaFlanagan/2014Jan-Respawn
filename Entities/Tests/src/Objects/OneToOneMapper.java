package Objects;

import com.me.Systems.Input.IInputMapper;

public class OneToOneMapper implements IInputMapper {

	@Override
	public int MapX(int X) {
		return X;
	}

	@Override
	public int MapY(int Y) {
		return Y;
	}

}

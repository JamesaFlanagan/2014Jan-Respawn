package Objects;

import com.me.Systems.Input.IInputMapper;

public class OneToHalfMapper implements IInputMapper {

	@Override
	public int MapX(int X) {
		return (int) X / 2;
	}

	@Override
	public int MapY(int Y) {		
		return (int) Y /2;
	}

}

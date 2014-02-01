/**
 * 
 */
package Objects;

import com.me.Systems.Render.IMatrix4;
import com.me.Systems.Render.ISpriteBatch;
import com.me.Systems.Render.ITextureRegion;

/**
 * @author james
 *
 */
public class SpriteBatch implements ISpriteBatch {

	public ITextureRegion Region;
	public  int  X;
	public int Y;
	public int Width;
	public int Height;
	
	public boolean DisposeCalled;
	
	public int DrawCalled = 0;
	
	/* (non-Javadoc)
	 * @see com.me.Objects.Interfaces.ISpriteBatch#Draw(com.me.Objects.Interfaces.ITextureRegion, int, int, int, int)
	 */
	@Override
	public void Draw(ITextureRegion region, int x, int y, int width, int height) {
	
		Region = region;
		X = x;
		Y = y;
		Width = width;
		Height = height;
		DrawCalled++;
	}

	/* (non-Javadoc)
	 * @see com.me.Objects.Interfaces.ISpriteBatch#SetProjectionMatrix(com.me.Objects.Interfaces.IMatrix4)
	 */
	@Override
	public void SetProjectionMatrix(IMatrix4 matrix) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.me.Objects.Interfaces.ISpriteBatch#Begin()
	 */
	@Override
	public void Begin() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.me.Objects.Interfaces.ISpriteBatch#End()
	 */
	@Override
	public void End() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.me.Objects.Interfaces.ISpriteBatch#Dispose()
	 */
	@Override
	public void Dispose() {
		DisposeCalled = true;
	}

}

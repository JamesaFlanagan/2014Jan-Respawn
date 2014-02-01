package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Objects.RenderRequirement;
import Objects.SpriteBatch;
import Objects.TextureAtlas;
import Objects.TextureRegion;

import com.artemis.World;
import com.me.Components.CPosition;
import com.me.Components.CRenderable;
import com.me.Components.CSize;
import com.me.Systems.Render.RenderPosition;
import com.me.Systems.Render.RenderSystem;

public class LibGdxRenderSystemTests {

	
	World world;
	SpriteBatch batch;
	RenderSystem target;
	
	@Before
	public void Setup()
	{
		world = new World();
		
		batch = new SpriteBatch();
		
		target = world.setSystem(new RenderSystem(new RenderRequirement(new TextureAtlas(), batch)));   
		
		world.initialize();		
	}
	
	
	
	@Test
	public void ShouldDrawAnEntity() {
			
		world.createEntity().addComponent(new CRenderable("one", RenderPosition.BackGround, 32,32)).addComponent(new CPosition(1,1)).addComponent(new CSize(32,32)).addToWorld();
		
		world.process();
		
		assertEquals(1, ((TextureRegion) batch.Region).Value);
		assertEquals(32, batch.X);
		assertEquals(32, batch.Y);
		assertEquals(32, batch.Width);
		assertEquals(32, batch.Height);
		assertEquals(1, batch.DrawCalled);
	}
	
	@Test
	public void ShouldDrawTwoEntities()
	{		
		world.createEntity().addComponent(new CRenderable("one", RenderPosition.BackGround, 32,32)).addComponent(new CSize(32,32)).addComponent(new CPosition(1,1)).addToWorld();
		
		world.createEntity().addComponent(new CRenderable("two", RenderPosition.ForeGround, 64,64)).addComponent(new CSize(128,64)).addComponent(new CPosition(2,2)).addToWorld();
		
		world.process();
		
		assertEquals(2, ((TextureRegion) batch.Region).Value);
		assertEquals(128, batch.X);
		assertEquals(128, batch.Y);
		assertEquals(128, batch.Width);
		assertEquals(64, batch.Height);
		assertEquals(2, batch.DrawCalled);				
	}
	
	@Test
	public void ShouldDrawTwoEntitiesBackgroundFirst()
	{
		world.createEntity().addComponent(new CRenderable("two", RenderPosition.ForeGround, 64,64)).addComponent(new CSize(128,64)).addComponent(new CPosition(2,2)).addToWorld();
		
		world.createEntity().addComponent(new CRenderable("one", RenderPosition.BackGround, 32,32)).addComponent(new CSize(32,32)).addComponent(new CPosition(1,1)).addToWorld();
		
		world.process();
		
		assertEquals(2, ((TextureRegion) batch.Region).Value);
		assertEquals(128, batch.X);
		assertEquals(128, batch.Y);
		assertEquals(128, batch.Width);
		assertEquals(64, batch.Height);
		assertEquals(2, batch.DrawCalled);	
	}
	
	@Test
	public void ShouldDrawFourEntitiesBackgroundFirst()
	{
		world.createEntity().addComponent(new CRenderable("two", RenderPosition.ForeGround, 64,64)).addComponent(new CSize(128,64)).addComponent(new CPosition(2,2)).addToWorld();
		world.createEntity().addComponent(new CRenderable("two", RenderPosition.ForeGround, 64,64)).addComponent(new CSize(128,64)).addComponent(new CPosition(2,2)).addToWorld();
		
		world.createEntity().addComponent(new CRenderable("one", RenderPosition.BackGround, 32,32)).addComponent(new CSize(32,32)).addComponent(new CPosition(1,1)).addToWorld();
		world.createEntity().addComponent(new CRenderable("one", RenderPosition.BackGround, 32,32)).addComponent(new CSize(32,32)).addComponent(new CPosition(1,1)).addToWorld();
		
		world.process();
		
		assertEquals(2, ((TextureRegion) batch.Region).Value);
		assertEquals(128, batch.X);
		assertEquals(128, batch.Y);
		assertEquals(128, batch.Width);
		assertEquals(64, batch.Height);
		assertEquals(4, batch.DrawCalled);	
	}
	
	
	

}


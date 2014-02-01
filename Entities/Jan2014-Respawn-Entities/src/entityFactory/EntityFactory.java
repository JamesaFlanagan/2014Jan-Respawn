package entityFactory;


import com.artemis.Entity;
import com.artemis.World;
import com.me.Components.CCollisionScript;
import com.me.Components.CInputButton;
import com.me.Components.CIntelligent;
import com.me.Components.CKillsPlayer;
import com.me.Components.CMovementIntent;
import com.me.Components.CPlayer;
import com.me.Components.CPosition;
import com.me.Components.CRenderable;
import com.me.Components.CRespawnLocation;
import com.me.Components.CSize;
import com.me.Components.CTile;
import com.me.Components.CUnit;
import com.me.Components.CWinCondition;
import com.me.Systems.AI.AIMode;
import com.me.Systems.Movement.MovementDirection;
import com.me.Systems.Render.RenderPosition;
import com.me.Systems.Scripts.Scripts.PlayerHitScript;
import com.me.Systems.Scripts.Scripts.SpikesBloodiedScript;


public class EntityFactory {

	public static void CreateFloor( int x, int y, World world)
	{
		world.createEntity().addComponent( new CRenderable("Floor", RenderPosition.BackGround, 32,32)).addComponent(new CSize(32,32)).addComponent(new CPosition(x, y  )).addComponent(new CTile()).addToWorld();
	}
	
	public static void CreateSpikes( int x, int y, World world)
	{
		world.createEntity().addComponent( new CRenderable("Spikes", RenderPosition.BackGround, 32,32)).addComponent(new CSize(32,32)).addComponent(new CPosition(x, y)).addComponent(new CTile()).addComponent(new CWinCondition()).addComponent(new CCollisionScript(SpikesBloodiedScript.Name)).addComponent(new CKillsPlayer()).addToWorld();
	}
	
	public static Entity CreatePlayer( int x, int y, World world)
	{
		Entity player =  world.createEntity().addComponent( new CRenderable("Player", RenderPosition.ForeGround, 32,32)).addComponent(new CSize(32,32)).addComponent(new CPosition(x, y)).addComponent(new CPlayer()).addComponent(new CMovementIntent(MovementDirection.None)).addComponent(new CRespawnLocation(x,y)).addComponent(new CCollisionScript(PlayerHitScript.Name)).addComponent(new CUnit());
		player.addToWorld();
		return player;
	}
	
	public static void CreateStationaryEnemy(int x, int y, World world)
	{
		world.createEntity().addComponent( new CRenderable("Soldier", RenderPosition.ForeGround, 32,32)).addComponent(new CSize(32,32)).addComponent(new CPosition(x, y)).addComponent(new CKillsPlayer()).addComponent(new CUnit()).addToWorld();  
	}
	
	public static void CreateHorizontalEnemy(int x, int y, boolean leftFirst, World world)
	{
		MovementDirection startingDirection;
		if (leftFirst) startingDirection = MovementDirection.Left;
		else startingDirection = MovementDirection.Right;
		
		world.createEntity().addComponent( new CRenderable("Soldier", RenderPosition.ForeGround, 32,32)).addComponent(new CSize(32,32)).addComponent(new CPosition(x, y)).addComponent(new CKillsPlayer()).addComponent(new CMovementIntent()).addComponent(new CIntelligent(AIMode.Horizontal, startingDirection)).addComponent(new CUnit()).addToWorld();
	}
	
	public static void CreateVerticalEnemy(int x, int y, boolean upFirst, World world)
	{
		MovementDirection startingDirection;
		if (upFirst) startingDirection = MovementDirection.Up;
		else startingDirection = MovementDirection.Down;
		
		world.createEntity().addComponent( new CRenderable("Soldier", RenderPosition.ForeGround, 32,32)).addComponent(new CSize(32,32)).addComponent(new CPosition(x, y)).addComponent(new CKillsPlayer()).addComponent(new CMovementIntent()).addComponent(new CIntelligent(AIMode.Vertical, startingDirection)).addComponent(new CUnit()).addToWorld();
	}
	
	public static void CreateClockWiseEnemy(int x, int y, MovementDirection startDirection, World world)
	{
		world.createEntity().addComponent( new CRenderable("Soldier", RenderPosition.ForeGround, 32,32)).addComponent(new CSize(32,32)).addComponent(new CPosition(x, y)).addComponent(new CKillsPlayer()).addComponent(new CMovementIntent()).addComponent(new CIntelligent(AIMode.ClockWise, startDirection)).addComponent(new CUnit()).addToWorld();
	}
	
	public static void CreateKeyPad(int x, int y, int width, int height, World world)
	{
		int horizontalWidth = (int) width * 4 / 10;
		int horizontalHeight = (int) height * 2 /10;
		
		int verticalWidth = (int) width * 2 / 10;
		int verticalHeight = (int) height * 4 /10;
		
		int verticalX = x + horizontalWidth;
		int horizontalY = y + verticalHeight;
		
		world.createEntity().addComponent(new CPosition(x, horizontalY)).addComponent(new CSize(horizontalWidth, horizontalHeight)).addComponent(new CRenderable("LeftArrow", RenderPosition.ForeGround, 1, 1)).addComponent(new CInputButton(MovementDirection.Left)).addToWorld();
		world.createEntity().addComponent(new CPosition(verticalX + verticalWidth, horizontalY)).addComponent(new CSize(horizontalWidth, horizontalHeight)).addComponent(new CRenderable("RightArrow", RenderPosition.ForeGround, 1, 1)).addComponent(new CInputButton(MovementDirection.Right)).addToWorld();
	
		world.createEntity().addComponent(new CPosition(verticalX, horizontalY + horizontalHeight)).addComponent(new CSize(verticalWidth, verticalHeight)).addComponent(new CRenderable("UpArrow", RenderPosition.ForeGround, 1, 1)).addComponent(new CInputButton(MovementDirection.Up)).addToWorld();
		world.createEntity().addComponent(new CPosition(verticalX, y)).addComponent(new CSize(verticalWidth, verticalHeight)).addComponent(new CRenderable("DownArrow", RenderPosition.ForeGround, 1, 1)).addComponent(new CInputButton(MovementDirection.Down)).addToWorld();
	}
	
	public static void CreateGameWonLabel(World world)
	{
		world.createEntity().addComponent(new CPosition(140, 200)).addComponent(new CSize(200, 64)).addComponent(new CRenderable("WinLabel", RenderPosition.ForeGround, 1, 1)).addComponent(new CWinCondition()).addToWorld();
	}
	
}

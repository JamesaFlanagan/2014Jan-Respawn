package Objects;

import com.artemis.Entity;
import com.artemis.World;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.me.Systems.Scripts.IScriptHandler;

public class ScriptHandler implements IScriptHandler {

	public World World;
	public String ScriptName;
	public Entity Me;
	public Entity Other;
	
	public String SecondScriptName;
	public Entity SecondMe;
	public Entity SecondOther;
	
	private boolean alreadyCalled = false; 
	
	@Override
	public void Initialise(World world) {
		
		World = world;
	}

	@Override
	public void ExecuteScript(String scriptName, Entity me, Entity other) {

		if (alreadyCalled)
		{
			SecondScriptName = scriptName;
			SecondMe = me;
			SecondOther = other;			
			
		}else{
		
		ScriptName = scriptName;
		Me = me;
		Other = other;
		}
		
		alreadyCalled = true;
	}

}

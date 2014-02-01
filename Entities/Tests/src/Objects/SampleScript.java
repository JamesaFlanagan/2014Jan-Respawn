package Objects;

import com.artemis.Entity;
import com.artemis.World;
import com.me.Systems.Scripts.IScript;

public class SampleScript implements IScript {

	public World World;
	public Entity Me;
	public Entity Other;
	
	public String Name = "Test";
	
	public SampleScript()
	{
		
	}
	
	public SampleScript(String name)
	{
		Name = name;
	}
	
	@Override
	public void Initialise(World world) {
		World = world;
	}

	@Override
	public void Execute(Entity me, Entity other) {
		
		Me = me;
		Other = other;
	}

	@Override
	public String Name() {
		return Name;
	}

}

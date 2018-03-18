package nl.jchmb.netspace.system.manager;

import java.util.stream.Stream;

import nl.jchmb.netspace.entity.manager.EntityManager;
import nl.jchmb.netspace.space.NetSpace;
import nl.jchmb.netspace.system.System;

public interface SystemManager {
	public void addSystem(
			final System system
	);
	
	public void removeSystem(
			final System system
	);
	
	public Stream<System> stream();
	
	public void onUpdate(
			final double dt
	);
}

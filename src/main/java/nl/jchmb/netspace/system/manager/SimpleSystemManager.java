package nl.jchmb.netspace.system.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import nl.jchmb.netspace.space.NetSpace;
import nl.jchmb.netspace.system.System;

public class SimpleSystemManager implements SystemManager {
	private final NetSpace space;
	private final List<System> systems = new ArrayList<>();
	
	public SimpleSystemManager(final NetSpace space) {
		this.space = space;
	}
	
	@Override
	public final void add(final System system) {
		this.systems.add(system);
	}

	@Override
	public final void remove(final System system) {
		this.systems.remove(system);
	}

	@Override
	public final Stream<System> stream() {
		return this.systems.stream();
	}

	@Override
	public void onUpdate(
			final double dt
	) {
		this.systems.forEach(
			system -> system.onUpdate(
				system.getEntityStream(this.space),
				dt
			)
		);
	}
	
}

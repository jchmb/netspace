package nl.jchmb.netspace.system.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import nl.jchmb.netspace.entity.manager.EntityManager;
import nl.jchmb.netspace.system.System;

public class SimpleSystemManager implements SystemManager {
	private final List<System<?>> systems = new ArrayList<>();
	
	@Override
	public final void addSystem(final System<?> system) {
		this.systems.add(system);
	}

	@Override
	public final void removeSystem(final System<?> system) {
		this.systems.remove(system);
	}

	@Override
	public final Stream<System<?>> stream() {
		return this.systems.stream();
	}

	@Override
	public void onUpdate(
			final EntityManager entities,
			final double dt
	) {
		this.systems.forEach(
			system -> system.update(entities, dt)
		);
	}
	
}

package nl.jchmb.netspace.entity;

import nl.jchmb.netspace.component.Component;
import nl.jchmb.netspace.component.manager.ComponentManager;
import nl.jchmb.netspace.component.manager.DefaultComponentManager;
import nl.jchmb.netspace.signal.manager.DefaultSignalManager;
import nl.jchmb.netspace.signal.manager.SignalManager;

public class BaseEntity implements Entity {
	private final ID id;
	protected final ComponentManager components = new DefaultComponentManager(this);
	protected final SignalManager signals = new DefaultSignalManager();
	
	protected BaseEntity(final ID id) {
		this.id = id;
	}
	
	@Override
	public final ComponentManager components() {
		return this.components;
	}

	@Override
	public final void onSpawn() {
		this.components.stream()
			.forEach(Component::onSpawn);
	}

	@Override
	public final void onDestroy() {
		this.components.stream()
			.forEach(Component::onDestroy);
	}

	@Override
	public final ID getID() {
		return this.id;
	}

	@Override
	public final SignalManager signals() {
		return this.signals;
	}

}

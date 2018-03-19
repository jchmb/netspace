package nl.jchmb.netspace.entity;

import nl.jchmb.netspace.component.Component;
import nl.jchmb.netspace.component.manager.ComponentManager;
import nl.jchmb.netspace.component.manager.DefaultComponentManager;
import nl.jchmb.netspace.signal.manager.DefaultSignalManager;
import nl.jchmb.netspace.signal.manager.SignalManager;
import nl.jchmb.netspace.space.NetSpace;

public class BaseEntity implements Entity {
	private ID id;
	private NetSpace space;
	protected final ComponentManager components = new DefaultComponentManager(this);
	protected final SignalManager signals = new DefaultSignalManager();
	
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

	@Override
	public final void setID(ID id) {
		this.id = id;
	}

	@Override
	public final NetSpace getSpace() {
		return this.space;
	}

	@Override
	public final void setSpace(final NetSpace space) {
		this.space = space;
	}

}

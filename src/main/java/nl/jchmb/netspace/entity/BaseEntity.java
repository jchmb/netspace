package nl.jchmb.netspace.entity;

import nl.jchmb.netspace.component.Component;
import nl.jchmb.netspace.component.manager.ComponentManager;
import nl.jchmb.netspace.component.manager.DefaultComponentManager;

public class BaseEntity implements Entity {
	protected final ComponentManager components = new DefaultComponentManager(this);
	
	@Override
	public ComponentManager components() {
		return this.components;
	}

	@Override
	public void onSpawn() {
		this.components.stream()
			.forEach(Component::onSpawn);
	}

	@Override
	public void onDestroy() {
		this.components.stream()
			.forEach(Component::onDestroy);
	}

}

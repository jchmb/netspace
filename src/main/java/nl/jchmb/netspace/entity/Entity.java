package nl.jchmb.netspace.entity;

import nl.jchmb.netspace.component.manager.ComponentManager;

public interface Entity {
	public ComponentManager components();
	
	public void onSpawn();
	public void onDestroy();
}

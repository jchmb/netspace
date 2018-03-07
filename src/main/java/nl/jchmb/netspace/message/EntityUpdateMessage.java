package nl.jchmb.netspace.message;

import nl.jchmb.netspace.entity.Entity;

public abstract class EntityUpdateMessage {
	public Entity.ID entityID;
	
	public abstract void doUpdate(final Entity entity);
}

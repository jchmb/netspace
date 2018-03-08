package nl.jchmb.netspace.message;

import nl.jchmb.netspace.entity.Entity;

public abstract class EntityUpdateMessage {
	public Entity.ID id;
	
	public abstract void onUpdate(final Entity entity);
}

package nl.jchmb.netspace.message;

import nl.jchmb.netspace.entity.Entity;

public class EntitySpawnMessage {
	public Class<? extends Entity> entityClass;
	public Entity.ID id;
}

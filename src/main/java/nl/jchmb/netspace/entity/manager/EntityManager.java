package nl.jchmb.netspace.entity.manager;

import java.util.stream.Stream;

import nl.jchmb.netspace.entity.Entity;

public interface EntityManager {
	public Stream<Entity> entities();
	public void addEntity(final Entity entity);
	public void removeEntity(final Entity entity);
}
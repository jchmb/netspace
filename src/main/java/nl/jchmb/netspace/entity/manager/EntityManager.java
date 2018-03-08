package nl.jchmb.netspace.entity.manager;

import java.util.Optional;
import java.util.stream.Stream;

import nl.jchmb.netspace.entity.Entity;

public interface EntityManager {
	public Optional<Entity> findByID(final Entity.ID id);
	public Stream<Entity> stream();
	public void addEntity(final Entity entity);
	public void removeEntity(final Entity entity);
	public void onUpdate(final float dt);
}
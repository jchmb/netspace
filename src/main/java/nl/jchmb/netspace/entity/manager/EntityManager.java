package nl.jchmb.netspace.entity.manager;

import java.util.Optional;
import java.util.stream.Stream;

import nl.jchmb.netspace.entity.Entity;

public interface EntityManager {
	public Optional<Entity> findByID(final Entity.ID id);
	public Stream<Entity> stream();
	public void add(final Entity entity);
	public void remove(final Entity entity);
	public void onUpdate(final double dt);
}
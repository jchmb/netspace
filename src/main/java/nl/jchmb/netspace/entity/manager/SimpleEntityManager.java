package nl.jchmb.netspace.entity.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import nl.jchmb.netspace.entity.Entity;
import nl.jchmb.netspace.entity.Entity.ID;

public class SimpleEntityManager implements EntityManager {
	private final List<Entity> entities = new ArrayList<>();
	private final List<Entity> entitiesToAdd = new ArrayList<>();
	private final List<Entity> entitiesToRemove = new ArrayList<>();
	
	@Override
	public Optional<Entity> findByID(final ID id) {
		/* Naive implementation. This is only acceptable with a low number of entities. */
		return this.entities.stream()
			.filter(
				entity -> entity.getID().equals(id)
			)
			.findAny();
	}

	@Override
	public Stream<Entity> stream() {
		return this.entities.stream();
	}

	@Override
	public void addEntity(final Entity entity) {
		this.entitiesToAdd.add(entity);
	}

	@Override
	public void removeEntity(final Entity entity) {
		this.entitiesToRemove.add(entity);
	}

	@Override
	public void onUpdate(final float dt) {
		this.entities.addAll(this.entitiesToAdd);
		this.entitiesToAdd.forEach(Entity::onSpawn);
		this.entities.removeAll(this.entitiesToRemove);
		this.entitiesToRemove.forEach(Entity::onDestroy);
		this.entitiesToAdd.clear();
		this.entitiesToRemove.clear();
	}

	
}

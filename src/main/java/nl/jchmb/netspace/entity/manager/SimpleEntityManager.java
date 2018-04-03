package nl.jchmb.netspace.entity.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import nl.jchmb.netspace.entity.Entity;
import nl.jchmb.netspace.entity.Entity.ID;
import nl.jchmb.netspace.entity.factory.EntityFactory;
import nl.jchmb.netspace.message.EntityDestroyMessage;
import nl.jchmb.netspace.message.EntitySpawnMessage;
import nl.jchmb.netspace.space.NetSpace;
import nl.jchmb.netspace.space.ServerNetSpace;

public class SimpleEntityManager implements EntityManager {
	private final NetSpace space;
	private final EntityFactory factory;
	private final List<Entity> entities = new ArrayList<>();
	private final List<EntityTypePair> entitiesToAdd = new ArrayList<>();
	private final List<Entity> entitiesToRemove = new ArrayList<>();
	private ID currentIndex = new ID(1);
	private ID currentPrivateIndex = new ID(-1);
	
	public SimpleEntityManager(
			final NetSpace space,
			final EntityFactory factory
	) {
		this.space = space;
		this.factory = factory;
	}
	
	@Override
	public Optional<Entity> findByID(final ID id) {
		/* Naive implementation. This is only acceptable with a low number of entities. */
		return this.entities.stream()
			.filter(
				entity -> entity.getID().equals(id)
			)
			.findAny();
	}
	
	public NetSpace getSpace() {
		return this.space;
	}

	@Override
	public Stream<Entity> stream() {
		return this.entities.stream();
	}

	@Override
	public Entity spawn(final Entity.Type type) {
		final Entity entity = this.factory.create(type);
		this.entitiesToAdd.add(
			new EntityTypePair(
				entity,
				type
			)
		);
		return entity;
	}

	@Override
	public void remove(final Entity entity) {
		this.entitiesToRemove.add(entity);
	}

	@Override
	public void onUpdate(final double dt) {
		this.entitiesToAdd.stream()
			.forEach(
				pair -> {
					final Entity.Type type = pair.type;
					final Entity entity = pair.entity;
					if (entity.isPrivate()) {
						entity.setID(this.currentPrivateIndex);
						this.currentPrivateIndex = this.currentPrivateIndex.next();
					} else if (this.space.isServer()) {
						entity.setID(this.currentIndex);
						this.sendCreateMessage(currentIndex, type);
						this.currentIndex = this.currentIndex.next();
					}
					entity.setSpace(this.space);
					this.entities.add(entity);
					entity.onSpawn();
				}
		);
		this.entities.removeAll(this.entitiesToRemove);
		this.entitiesToRemove.forEach(
			entity -> {
				if (!entity.isPrivate() && this.space.isServer()) {
					this.sendDestroyMessage(entity);
				}
				entity.onDestroy();
				entity.setID(null);
				entity.setSpace(null);
			}
		);
		this.entitiesToAdd.clear();
		this.entitiesToRemove.clear();
	}
	
	private final void sendCreateMessage(final Entity.ID id, final Entity.Type type) {
		final ServerNetSpace<?> space = (ServerNetSpace<?>) this.space;
		final EntitySpawnMessage msg = new EntitySpawnMessage();
		msg.id = id;
		msg.type = type;
		space.sendTCP(msg);
	}
	
	private final void sendDestroyMessage(final Entity entity) {
		final ServerNetSpace<?> space = (ServerNetSpace<?>) this.space;
		final EntityDestroyMessage msg = new EntityDestroyMessage();
		msg.id = entity.getID();
		space.sendTCP(msg);
	}

	@Override
	public final Entity spawn(final String entityType) {
		return this.spawn(
			this.factory.getTypeIndex(entityType)
		);
	}

	private static final class EntityTypePair {
		public final Entity entity;
		public final Entity.Type type;
		
		public EntityTypePair(final Entity entity, final Entity.Type type) {
			this.entity = entity;
			this.type = type;
		}
	}
}

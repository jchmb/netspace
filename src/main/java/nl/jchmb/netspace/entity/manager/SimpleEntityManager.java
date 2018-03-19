package nl.jchmb.netspace.entity.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.esotericsoftware.kryonet.Server;

import nl.jchmb.netspace.entity.Entity;
import nl.jchmb.netspace.entity.Entity.ID;
import nl.jchmb.netspace.space.NetSpace;

public class SimpleEntityManager implements EntityManager {
	private final NetSpace space;
	private final List<Entity> entities = new ArrayList<>();
	private final List<Entity> entitiesToAdd = new ArrayList<>();
	private final List<Entity> entitiesToRemove = new ArrayList<>();
	private ID currentIndex = new ID(1);
	private ID currentPrivateIndex = new ID(-1);
	
	public SimpleEntityManager(final NetSpace space) {
		this.space = space;
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
	public void add(final Entity entity) {
		this.entitiesToAdd.add(entity);
	}

	@Override
	public void remove(final Entity entity) {
		this.entitiesToRemove.add(entity);
	}

	@Override
	public void onUpdate(final double dt) {
		this.entities.addAll(this.entitiesToAdd);
		this.entitiesToAdd.forEach(
			entity -> {
				if (entity.isPrivate()) {
					entity.setID(this.currentPrivateIndex);
					this.currentPrivateIndex = this.currentPrivateIndex.next();
				} else if (this.space.isServer()) {
					entity.setID(this.currentIndex);
					this.currentIndex = this.currentIndex.next();
					this.sendCreateMessage(entity);
				}
				entity.setSpace(this.space);
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
	
	private final void sendCreateMessage(final Entity entity) {
		
	}
	
	private final void sendDestroyMessage(final Entity entity) {
		
	}

	
}

package nl.jchmb.netspace.system;

import java.util.stream.Stream;

import nl.jchmb.netspace.entity.Entity;
import nl.jchmb.netspace.space.NetSpace;

public abstract class SimpleSystem implements System {
	@Override
	public final Stream<Entity> getEntityStream(final NetSpace space) {
		return space.entities().stream();
	}
	
	@Override
	public void onUpdate(final Stream<Entity> entities, final double dt) {
		entities.forEach(entity -> this.onUpdate(entity, dt));
	}
}

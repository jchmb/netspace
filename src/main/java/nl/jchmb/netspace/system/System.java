package nl.jchmb.netspace.system;

import java.util.stream.Stream;

import nl.jchmb.netspace.entity.Entity;
import nl.jchmb.netspace.space.NetSpace;

public interface System {
	public Stream<Entity> getEntityStream(final NetSpace space);
	public void onUpdate(final Entity entity, final double dt);
}

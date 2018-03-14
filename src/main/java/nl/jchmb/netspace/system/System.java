package nl.jchmb.netspace.system;

import nl.jchmb.netspace.entity.Entity;

public interface System {
	public void onUpdate(final Entity entity, final double dt);
}

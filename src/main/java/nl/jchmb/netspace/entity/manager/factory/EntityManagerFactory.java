package nl.jchmb.netspace.entity.manager.factory;

import nl.jchmb.netspace.entity.manager.EntityManager;
import nl.jchmb.netspace.space.NetSpace;

@FunctionalInterface
public interface EntityManagerFactory {
	public EntityManager create(final NetSpace space);
}

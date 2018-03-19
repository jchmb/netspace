package nl.jchmb.netspace.space.factory;

import nl.jchmb.netspace.entity.manager.factory.EntityManagerFactory;
import nl.jchmb.netspace.message.registry.factory.MessageRegistryFactory;
import nl.jchmb.netspace.space.NetSpace;
import nl.jchmb.netspace.system.manager.factory.SystemManagerFactory;

public abstract class BaseNetSpaceFactory<T extends NetSpace> implements NetSpaceFactory<T> {
	protected final EntityManagerFactory entityManagerFactory;
	protected final SystemManagerFactory systemManagerFactory;
	protected final MessageRegistryFactory messageRegistryFactory;
	
	protected BaseNetSpaceFactory(
			final EntityManagerFactory entityManagerFactory,
			final SystemManagerFactory systemManagerFactory,
			final MessageRegistryFactory messageRegistryFactory
	) {
		this.entityManagerFactory = entityManagerFactory;
		this.systemManagerFactory = systemManagerFactory;
		this.messageRegistryFactory = messageRegistryFactory;
	}
}

package nl.jchmb.netspace.space.factory;

import nl.jchmb.netspace.entity.manager.SimpleEntityManager;	
import nl.jchmb.netspace.message.registry.factory.MessageRegistryFactory;
import nl.jchmb.netspace.system.manager.SimpleSystemManager;

public class SimpleClientNetSpaceFactory extends ClientNetSpaceFactory {

	public SimpleClientNetSpaceFactory(
			final MessageRegistryFactory messageRegistryFactory
	) {
		super(
			space -> new SimpleEntityManager(space),
			space -> new SimpleSystemManager(space),
			messageRegistryFactory
		);
	}
	
}

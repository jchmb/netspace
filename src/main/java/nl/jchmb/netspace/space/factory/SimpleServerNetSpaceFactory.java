package nl.jchmb.netspace.space.factory;

import com.esotericsoftware.kryonet.Connection;

import nl.jchmb.netspace.entity.manager.SimpleEntityManager;
import nl.jchmb.netspace.message.registry.factory.MessageRegistryFactory;
import nl.jchmb.netspace.network.ServerFactory;
import nl.jchmb.netspace.system.manager.SimpleSystemManager;

public class SimpleServerNetSpaceFactory<T extends Connection> extends ServerNetSpaceFactory<T> {

	public SimpleServerNetSpaceFactory(
			final ServerFactory serverFactory,
			final MessageRegistryFactory messageRegistryFactory
	) {
		super(
			serverFactory,
			space -> new SimpleEntityManager(space),
			space -> new SimpleSystemManager(space),
			messageRegistryFactory
		);
	}
	
}

package nl.jchmb.netspace.space.factory;

import com.esotericsoftware.kryonet.Connection;

import nl.jchmb.netspace.entity.manager.factory.EntityManagerFactory;
import nl.jchmb.netspace.message.registry.factory.MessageRegistryFactory;
import nl.jchmb.netspace.network.ServerFactory;
import nl.jchmb.netspace.space.ServerNetSpace;
import nl.jchmb.netspace.system.manager.factory.SystemManagerFactory;

public class ServerNetSpaceFactory<T extends Connection> extends BaseNetSpaceFactory<ServerNetSpace<T>> {
	private final ServerFactory serverFactory;
	
	public ServerNetSpaceFactory(
			final ServerFactory serverFactory,
			final EntityManagerFactory entityManagerFactory,
			final SystemManagerFactory systemManagerFactory,
			final MessageRegistryFactory messageRegistryFactory
	) {
		super(entityManagerFactory, systemManagerFactory, messageRegistryFactory);
		this.serverFactory = serverFactory;
	}
	
	@Override
	public final ServerNetSpace<T> create() {
		return new ServerNetSpace<>(
			this.serverFactory,
			this.entityManagerFactory,
			this.systemManagerFactory,
			this.messageRegistryFactory
		);
	}
	
}

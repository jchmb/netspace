package nl.jchmb.netspace.space;

import com.esotericsoftware.kryonet.Server;

import nl.jchmb.netspace.entity.manager.factory.EntityManagerFactory;
import nl.jchmb.netspace.message.registry.factory.MessageRegistryFactory;
import nl.jchmb.netspace.system.manager.factory.SystemManagerFactory;

public class ServerNetSpace extends BaseNetSpace {
	public ServerNetSpace(
			final Server server,
			final EntityManagerFactory entityManagerFactory,
			final SystemManagerFactory systemManagerFactory,
			final MessageRegistryFactory messageRegistryFactory
	) {
		super(
			server,
			entityManagerFactory,
			systemManagerFactory,
			messageRegistryFactory
		);
	}

	@Override
	public final boolean isServer() {
		return true;
	}

	@Override
	public final boolean isClient() {
		return false;
	}
	
}

package nl.jchmb.netspace.space;

import java.io.IOException;

import com.esotericsoftware.kryonet.Server;

import nl.jchmb.netspace.entity.manager.factory.EntityManagerFactory;
import nl.jchmb.netspace.message.registry.factory.MessageRegistryFactory;
import nl.jchmb.netspace.network.Connector;
import nl.jchmb.netspace.network.ServerFactory;
import nl.jchmb.netspace.system.manager.factory.SystemManagerFactory;

public class ServerNetSpace<T extends Server> extends BaseNetSpace {
	public ServerNetSpace(
			final ServerFactory<T> serverFactory,
			final EntityManagerFactory entityManagerFactory,
			final SystemManagerFactory systemManagerFactory,
			final MessageRegistryFactory messageRegistryFactory
	) {
		super(
			serverFactory.create(),
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

	@Override
	public final void connect(final Connector connector) throws IOException {
		final Server server = (Server) this.getEndPoint();
		
		if (connector.supportsUDP()) {
			server.bind(connector.getTCPPort(), connector.getUDPPort());
		} else {
			server.bind(connector.getTCPPort());
		}
		server.start();
	}
	
	
}

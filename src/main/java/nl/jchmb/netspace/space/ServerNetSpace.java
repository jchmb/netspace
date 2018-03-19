package nl.jchmb.netspace.space;

import java.io.IOException;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Server;

import nl.jchmb.netspace.entity.manager.factory.EntityManagerFactory;
import nl.jchmb.netspace.message.registry.factory.MessageRegistryFactory;
import nl.jchmb.netspace.network.Connector;
import nl.jchmb.netspace.network.ServerFactory;
import nl.jchmb.netspace.system.manager.factory.SystemManagerFactory;

public class ServerNetSpace<T extends Connection> extends BaseNetSpace {
	public ServerNetSpace(
			final ServerFactory serverFactory,
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
	
	@SuppressWarnings("unchecked")
	private final Stream<T> getConnectionStream(final Predicate<T> predicate) {
		final Server server = (Server) this.getEndPoint();
		return Stream.of(server.getConnections())
			.map(c -> (T) c)
			.filter(predicate);
	}
	
	public final <M> void sendTCP(
			final M message,
			final Predicate<T> predicate
	) {
		this.getConnectionStream(predicate)
			.forEach(c -> c.sendTCP(message));
	}
	
	public final <M> void sendTCP(
			final M message
	) {
		this.sendTCP(message, c -> true);
	}
	
	public final <M> void sendUDP(
			final M message,
			final Predicate<T> predicate
	) {
		this.getConnectionStream(predicate)
			.forEach(c -> c.sendUDP(message));
	}
	
	public final <M> void sendUDP(
			final M message
	) {
		this.sendUDP(message, c -> true);
	}
}

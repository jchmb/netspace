package nl.jchmb.netspace.space;

import java.io.IOException;

import com.esotericsoftware.kryonet.Client;

import nl.jchmb.netspace.entity.manager.factory.EntityManagerFactory;
import nl.jchmb.netspace.message.receiver.EntityDestroyMessageReceiver;
import nl.jchmb.netspace.message.receiver.EntitySpawnMessageReceiver;
import nl.jchmb.netspace.message.receiver.EntityUpdateMessageReceiver;
import nl.jchmb.netspace.message.registry.factory.MessageRegistryFactory;
import nl.jchmb.netspace.network.Connector;
import nl.jchmb.netspace.system.manager.factory.SystemManagerFactory;

public class ClientNetSpace extends BaseNetSpace {
	public ClientNetSpace(
			final EntityManagerFactory entityManagerFactory,
			final SystemManagerFactory systemManagerFactory,
			final MessageRegistryFactory messageRegistryFactory
	) {
		super(
			new Client(),
			entityManagerFactory,
			systemManagerFactory,
			messageRegistryFactory
		);
		
		this.addListener(
			new EntitySpawnMessageReceiver(this.entities())
		);
		this.addListener(
			new EntityDestroyMessageReceiver(this.entities())
		);
		this.addListener(
			new EntityUpdateMessageReceiver(this.entities())
		);
	}
	
	

	@Override
	public final boolean isServer() {
		return false;
	}

	@Override
	public final boolean isClient() {
		return true;
	}

	@Override
	public final void connect(final Connector connector) throws IOException {
		final Client client = (Client) this.getEndPoint();
		client.start();
		if (connector.supportsUDP()) {
			client.connect(
				connector.getTimeout(),
				connector.getHost(),
				connector.getTCPPort(),
				connector.getUDPPort()
			);
		} else {
			client.connect(
				connector.getTimeout(),
				connector.getHost(),
				connector.getTCPPort()
			);
		}
	}
}

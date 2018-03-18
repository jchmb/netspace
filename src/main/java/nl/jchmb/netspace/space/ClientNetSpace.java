package nl.jchmb.netspace.space;

import com.esotericsoftware.kryonet.Client;

import nl.jchmb.netspace.entity.manager.factory.EntityManagerFactory;
import nl.jchmb.netspace.message.receiver.EntityDestroyMessageReceiver;
import nl.jchmb.netspace.message.receiver.EntitySpawnMessageReceiver;
import nl.jchmb.netspace.message.receiver.EntityUpdateMessageReceiver;
import nl.jchmb.netspace.message.registry.factory.MessageRegistryFactory;
import nl.jchmb.netspace.system.manager.factory.SystemManagerFactory;

public class ClientNetSpace extends BaseNetSpace {
	public ClientNetSpace(
			final Client client,
			final EntityManagerFactory entityManagerFactory,
			final SystemManagerFactory systemManagerFactory,
			final MessageRegistryFactory messageRegistryFactory
	) {
		super(
			client,
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
}

package nl.jchmb.netspace.space;

import com.esotericsoftware.kryonet.EndPoint;
import com.esotericsoftware.kryonet.Listener;

import nl.jchmb.netspace.entity.manager.factory.EntityManagerFactory;
import nl.jchmb.netspace.message.registry.MessageRegistry;
import nl.jchmb.netspace.message.registry.factory.MessageRegistryFactory;
import nl.jchmb.netspace.entity.manager.EntityManager;

public abstract class BaseNetSpace implements NetSpace {
	private final EndPoint endPoint;
	private final EntityManager entities;
	private final MessageRegistry messages;
			
	public BaseNetSpace(
			final EndPoint endPoint,
			final EntityManagerFactory entityManagerFactory,
			final MessageRegistryFactory messageRegistryFactory
	) {
		this.endPoint = endPoint;
		this.entities = entityManagerFactory.create(this);
		this.messages = messageRegistryFactory.create(this.endPoint.getKryo());
	}
	
	@Override
	public EntityManager entities() {
		return this.entities;
	}

	@Override
	public MessageRegistry messages() {
		return this.messages;
	}
	
	protected void addListener(
			final Listener listener
	) {
		this.endPoint.addListener(listener);
	}
}

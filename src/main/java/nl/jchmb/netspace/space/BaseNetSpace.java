package nl.jchmb.netspace.space;

import com.esotericsoftware.kryonet.EndPoint;
import com.esotericsoftware.kryonet.Listener;

import nl.jchmb.netspace.entity.manager.factory.EntityManagerFactory;
import nl.jchmb.netspace.message.registry.MessageRegistry;
import nl.jchmb.netspace.message.registry.factory.MessageRegistryFactory;
import nl.jchmb.netspace.system.manager.SystemManager;
import nl.jchmb.netspace.system.manager.factory.SystemManagerFactory;
import nl.jchmb.netspace.entity.manager.EntityManager;

public abstract class BaseNetSpace implements NetSpace {
	private final EndPoint endPoint;
	private final EntityManager entities;
	private final SystemManager systems;
	private final MessageRegistry messages;
			
	public BaseNetSpace(
			final EndPoint endPoint,
			final EntityManagerFactory entityManagerFactory,
			final SystemManagerFactory systemManagerFactory,
			final MessageRegistryFactory messageRegistryFactory
	) {
		this.endPoint = endPoint;
		this.entities = entityManagerFactory.create(this);
		this.systems = systemManagerFactory.create(this);
		this.messages = messageRegistryFactory.create(this.endPoint.getKryo());
	}
	
	@Override
	public final EntityManager entities() {
		return this.entities;
	}

	@Override
	public final MessageRegistry messages() {
		return this.messages;
	}
	
	@Override
	public final SystemManager systems() {
		return this.systems;
	}
	
	@Override
	public final void onUpdate(final double dt) {
		this.entities.onUpdate(dt);
		this.systems.onUpdate(dt);
	}
	
	@Override
	public final EndPoint getEndPoint() {
		return this.endPoint;
	}
	
	protected final void addListener(
			final Listener listener
	) {
		this.endPoint.addListener(listener);
	}
}

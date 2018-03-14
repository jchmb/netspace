package nl.jchmb.netspace.space;

import com.esotericsoftware.kryonet.EndPoint;
import com.esotericsoftware.kryonet.Listener;

import nl.jchmb.netspace.entity.manager.SimpleEntityManager;
import nl.jchmb.netspace.entity.manager.EntityManager;

public abstract class BaseNetSpace implements NetSpace {
	private final EndPoint endPoint;
	private final EntityManager entities = new SimpleEntityManager(this);
			
	public BaseNetSpace(final EndPoint endPoint) {
		this.endPoint = endPoint;
	}
	
	@Override
	public EntityManager entities() {
		return this.entities;
	}
	
	protected void addListener(
			final Listener listener
	) {
		this.endPoint.addListener(listener);
	}
}

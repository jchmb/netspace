package nl.jchmb.netspace.space;

import java.util.function.Consumer;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.EndPoint;
import com.esotericsoftware.kryonet.Listener;

import nl.jchmb.netspace.entity.manager.SimpleEntityManager;
import nl.jchmb.netspace.entity.manager.EntityManager;

public abstract class BaseNetSpace implements NetSpace {
	private final EndPoint endPoint;
	private final EntityManager entities = new SimpleEntityManager();
			
	public BaseNetSpace(final EndPoint endPoint) {
		this.endPoint = endPoint;
	}
	
	@Override
	public EntityManager entities() {
		return this.entities;
	}
	
	protected void addListener(
			final Consumer<Object> listener
	) {
		this.endPoint.addListener(
			new Listener() {
				@Override
				public final void received(final Connection connection, final Object object) {
					listener.accept(object);
				}
			}
		);
	}
}

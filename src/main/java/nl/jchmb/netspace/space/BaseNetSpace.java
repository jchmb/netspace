package nl.jchmb.netspace.space;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.EndPoint;
import com.esotericsoftware.kryonet.Listener;

import nl.jchmb.netspace.entity.manager.DefaultEntityManager;
import nl.jchmb.netspace.entity.manager.EntityManager;

public abstract class BaseNetSpace implements NetSpace {
	private final EndPoint endPoint;
	private final EntityManager entities = new DefaultEntityManager();
	protected final Map<Class<?>, Consumer<?>> listeners = new HashMap<>();
			
	public BaseNetSpace(final EndPoint endPoint) {
		this.endPoint = endPoint;
		this.endPoint.addListener(
			new Listener() {
				@Override
				public void received(final Connection connection, final Object object) {
					this.receivedTyped(connection, object);
				}
				
				@SuppressWarnings("unchecked")
				private <T> void receivedTyped(final Connection connection, final T object) {
					final Class<T> clazz = (Class<T>) object.getClass();
					final Consumer<T> consumer = (Consumer<T>) BaseNetSpace.this.listeners.get(clazz);
					if (consumer != null) {
						consumer.accept(object);
					}
				}
			}
		);
	}
	
	@Override
	public EntityManager entities() {
		return this.entities;
	}
	
	protected <T> void addListener(
			final Class<T> clazz,
			final Consumer<T> consumer
	) {
		this.listeners.put(clazz, consumer);
	}
	
}

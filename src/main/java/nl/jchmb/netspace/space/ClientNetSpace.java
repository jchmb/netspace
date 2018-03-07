package nl.jchmb.netspace.space;

import java.lang.reflect.InvocationTargetException;

import com.esotericsoftware.kryonet.Client;

import nl.jchmb.netspace.entity.Entity;
import nl.jchmb.netspace.message.EntityDestroyMessage;
import nl.jchmb.netspace.message.EntitySpawnMessage;

public class ClientNetSpace extends BaseNetSpace {
	public ClientNetSpace(final Client client) {
		super(client);
		
		this.addListener(
			EntitySpawnMessage.class,
			msg -> {
				try {
					final Entity entity = msg.entityClass
						.getConstructor(
							Entity.ID.class
						)
						.newInstance(
							msg.id
						);
					this.entities().addEntity(entity);
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
			}
		);
		
		this.addListener(
			EntityDestroyMessage.class,
			msg -> {
				this.entities().findByID(msg.id)
					.ifPresent(
						entity -> this.entities().removeEntity(entity)
					);
			}
		);
	}
}

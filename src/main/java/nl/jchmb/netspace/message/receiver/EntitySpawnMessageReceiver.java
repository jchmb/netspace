package nl.jchmb.netspace.message.receiver;

import java.lang.reflect.InvocationTargetException;

import com.esotericsoftware.kryonet.Connection;

import nl.jchmb.netspace.entity.Entity;
import nl.jchmb.netspace.entity.manager.EntityManager;
import nl.jchmb.netspace.message.EntitySpawnMessage;

public class EntitySpawnMessageReceiver extends Receiver<EntitySpawnMessage> {
	private final EntityManager entities;
	
	public EntitySpawnMessageReceiver(
			final EntityManager entities
	) {
		this.entities = entities;
	}
	
	@Override
	public final void process(
			final Connection connection,
			final EntitySpawnMessage msg
	) {
			try {
					final Entity entity = msg.entityClass
						.getConstructor(
							Entity.ID.class
						)
						.newInstance(
							msg.id
						);
					this.entities.add(entity);
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
			}
	}

	@Override
	protected Class<EntitySpawnMessage> getMessageClass() {
		return EntitySpawnMessage.class;
	}
	
}

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
		final Entity entity = this.entities.spawn(msg.type);
		entity.setID(msg.id);
	}

	@Override
	protected Class<EntitySpawnMessage> getMessageClass() {
		return EntitySpawnMessage.class;
	}
	
}

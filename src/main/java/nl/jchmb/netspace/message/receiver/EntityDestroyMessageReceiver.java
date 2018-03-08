package nl.jchmb.netspace.message.receiver;

import com.esotericsoftware.kryonet.Connection;

import nl.jchmb.netspace.entity.manager.EntityManager;
import nl.jchmb.netspace.message.EntityDestroyMessage;

public class EntityDestroyMessageReceiver extends Receiver<EntityDestroyMessage> {
	private final EntityManager entities;
	
	public EntityDestroyMessageReceiver(
			final EntityManager entities
	) {
		this.entities = entities;
	}
	
	@Override
	protected final Class<EntityDestroyMessage> getMessageClass() {
		return EntityDestroyMessage.class;
	}

	@Override
	protected final void process(
			final Connection connection,
			final EntityDestroyMessage msg
	) {
		this.entities.findByID(msg.id)
			.ifPresent(
				entity -> this.entities.removeEntity(entity)
			);
	}
	
}

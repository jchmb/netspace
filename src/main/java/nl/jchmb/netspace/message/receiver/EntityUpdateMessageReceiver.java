package nl.jchmb.netspace.message.receiver;

import com.esotericsoftware.kryonet.Connection;

import nl.jchmb.netspace.entity.manager.EntityManager;
import nl.jchmb.netspace.message.EntityUpdateMessage;

public class EntityUpdateMessageReceiver extends Receiver<EntityUpdateMessage> {
	private final EntityManager entities;
	
	public EntityUpdateMessageReceiver(
			final EntityManager entities
	) {
		this.entities = entities;
	}
	
	@Override
	protected final Class<EntityUpdateMessage> getMessageClass() {
		return EntityUpdateMessage.class;
	}

	@Override
	protected final void process(
			final Connection connection,
			final EntityUpdateMessage msg
	) {
		this.entities.findByID(msg.id)
			.ifPresent(msg::onUpdate);
	}
	
}

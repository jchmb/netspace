package nl.jchmb.netspace.message.registry;

import com.esotericsoftware.kryo.Kryo;

import nl.jchmb.netspace.entity.Entity;
import nl.jchmb.netspace.message.EntityDestroyMessage;
import nl.jchmb.netspace.message.EntitySpawnMessage;
import nl.jchmb.netspace.message.MessageAggregate;

public class BaseMessageRegistry extends DefaultMessageRegistry {
	public BaseMessageRegistry(final Kryo kryo) {
		super(kryo);
		
		this.register(MessageAggregate.class);
		this.register(Entity.ID.class);
		this.register(Entity.Type.class);
		this.register(EntitySpawnMessage.class);
		this.register(EntityDestroyMessage.class);
	}
	
}

package nl.jchmb.netspace.message.registry;

import com.esotericsoftware.kryo.Kryo;

import nl.jchmb.netspace.message.EntityDestroyMessage;
import nl.jchmb.netspace.message.EntitySpawnMessage;

public class BaseMessageRegistry extends DefaultMessageRegistry {
	public BaseMessageRegistry(final Kryo kryo) {
		super(kryo);
		
		this.register(EntitySpawnMessage.class);
		this.register(EntityDestroyMessage.class);
	}
	
}

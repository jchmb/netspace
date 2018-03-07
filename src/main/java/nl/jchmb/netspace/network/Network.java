package nl.jchmb.netspace.network;

import com.esotericsoftware.kryo.Kryo;

import nl.jchmb.netspace.message.EntityDestroyMessage;
import nl.jchmb.netspace.message.EntitySpawnMessage;

public abstract class Network {
	protected final Kryo kryo;
	
	public Network(final Kryo kryo) {
		this.kryo = kryo;
		this.initialize();
	}
	
	protected void initialize() {
		kryo.register(EntitySpawnMessage.class);
		kryo.register(EntityDestroyMessage.class);
	}
}

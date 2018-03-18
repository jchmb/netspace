package nl.jchmb.netspace.message.registry;

import com.esotericsoftware.kryo.Kryo;

public class DefaultMessageRegistry implements MessageRegistry {
	private final Kryo kryo;
	
	public DefaultMessageRegistry(final Kryo kryo) {
		this.kryo = kryo;
	}

	@Override
	public <T> void register(final Class<T> clazz) {
		this.kryo.register(clazz);
	}	
}

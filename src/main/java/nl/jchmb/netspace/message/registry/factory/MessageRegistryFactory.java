package nl.jchmb.netspace.message.registry.factory;

import com.esotericsoftware.kryo.Kryo;

import nl.jchmb.netspace.message.registry.MessageRegistry;

@FunctionalInterface
public interface MessageRegistryFactory {
	public MessageRegistry create(final Kryo kryo);
}

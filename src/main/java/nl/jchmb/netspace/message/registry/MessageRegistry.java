package nl.jchmb.netspace.message.registry;

public interface MessageRegistry {	
	public <T> void register(final Class<T> clazz);
}

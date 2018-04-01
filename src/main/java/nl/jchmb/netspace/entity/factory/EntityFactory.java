package nl.jchmb.netspace.entity.factory;

import java.util.function.Supplier;

import nl.jchmb.netspace.entity.Entity;

public interface EntityFactory {
	public void register(final String key, final Supplier<Entity> entitySupplier);
	public Entity.Type getTypeIndex(final String key);
	public Entity create(final String key);
	public Entity create(final Entity.Type type);
}

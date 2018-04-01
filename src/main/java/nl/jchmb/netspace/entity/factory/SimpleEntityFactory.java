package nl.jchmb.netspace.entity.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import nl.jchmb.netspace.entity.Entity;

public class SimpleEntityFactory implements EntityFactory {
	private final Map<Entity.Type, Supplier<Entity>> suppliers;
	private final Map<String, Entity.Type> indices;
	private Entity.Type currentType;
	
	public SimpleEntityFactory() {
		this.suppliers = new HashMap<>();
		this.indices = new HashMap<>();
		this.currentType = new Entity.Type();
	}
	
	@Override
	public final void register(
			final String key,
			Supplier<Entity> entitySupplier
	) {
		this.indices.put(key, this.currentType);
		this.suppliers.put(this.currentType, entitySupplier);
		this.currentType = this.currentType.next();
	}

	@Override
	public final Entity create(final String key) {
		return this.create(this.indices.get(key));
	}

	@Override
	public final Entity create(final Entity.Type type) {
		return this.suppliers.get(type).get();
	}

	@Override
	public final Entity.Type getTypeIndex(final String key) {
		return this.indices.get(key);
	}
	
	
}

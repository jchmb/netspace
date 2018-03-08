package nl.jchmb.netspace.component.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

import nl.jchmb.netspace.component.Component;
import nl.jchmb.netspace.component.exception.ComponentNotFoundException;
import nl.jchmb.netspace.component.exception.DuplicateComponentException;
import nl.jchmb.netspace.entity.Entity;

public class DefaultComponentManager implements ComponentManager {
	private final Entity entity;
	private final Map<Class<? extends Component>, Component> components;
	
	public DefaultComponentManager(
			final Entity entity
	) {
		this.components = new HashMap<>();
		this.entity = entity;
	}
	
	private final <T extends Component> Optional<T> optional(
			final Class<T> clazz
	) {
		return Optional.ofNullable(
			this.components.containsKey(clazz) ?
				clazz.cast(this.components.get(clazz)) :
				null
		);
	}
	
	@Override
	public final <T extends Component> ComponentManager attach(
			final T component
	) {
		if (this.optional(component.getClass()).isPresent()) {
			throw new DuplicateComponentException();
		}
		this.components.put(component.getClass(), component);
		component.setEntity(this.entity);
		return this;
	}

	@Override
	public final <T extends Component> ComponentManager detach(
			final Class<T> clazz
	) {
		if (!this.optional(clazz).isPresent()) {
			throw new ComponentNotFoundException();
		}
		final Component component = this.components.remove(clazz);
		component.setEntity(null);
		return this;
	}

	@Override
	public final <T extends Component> void ifPresent(
			final Class<T> clazz,
			final Consumer<T> consumer
	) {
		this.optional(clazz).ifPresent(consumer);
	}

	@Override
	public final Stream<? extends Component> stream() {
		return this.components.values().stream();
	}

	@Override
	public final <T extends Component> T get(final Class<T> clazz) {
		return this.optional(clazz).get();
	}

}

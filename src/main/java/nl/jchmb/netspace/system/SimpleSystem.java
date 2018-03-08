package nl.jchmb.netspace.system;

import java.util.stream.Stream;

import nl.jchmb.netspace.component.Component;
import nl.jchmb.netspace.entity.manager.EntityManager;

/**
 * A simple implementation of the System class, which does not care about cache coherence.
 */
public abstract class SimpleSystem<T extends Component> implements System<T> {
	private final Class<T> componentClass;
	
	protected SimpleSystem(final Class<T> componentClass) {
		this.componentClass = componentClass;
	}
	
	@Override
	public final Stream<T> getComponents(final EntityManager entities) {
		return entities.stream()
			.map(entity -> entity.components().get(componentClass));
	}
	
}

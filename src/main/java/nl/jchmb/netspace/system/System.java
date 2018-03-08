package nl.jchmb.netspace.system;

import java.util.stream.Stream;

import nl.jchmb.netspace.component.Component;
import nl.jchmb.netspace.entity.manager.EntityManager;

public interface System<T extends Component> {
	public Stream<T> getComponents(
			final EntityManager entities
	);
	
	public void onUpdate(
			final T component,
			final double dt
	);
	
	public default void update(
			final EntityManager entities,
			final double dt
	) {
		this.getComponents(entities)
			.forEach(
				cmp -> this.onUpdate(cmp, dt)	
			);
	}
}

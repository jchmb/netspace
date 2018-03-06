package nl.jchmb.netspace.component.manager;

import java.util.function.Consumer;
import java.util.stream.Stream;

import nl.jchmb.netspace.component.Component;

public interface ComponentManager {
	public <T extends Component> ComponentManager attach(final T component);
	public <T extends Component> ComponentManager detach(final Class<T> clazz);
	public <T extends Component> void ifPresent(final Class<T> clazz, final Consumer<T> consumer);
	public Stream<? extends Component> stream();
}

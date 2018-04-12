package nl.jchmb.netspace.signal.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import nl.jchmb.netspace.signal.SignalListener;

public class DefaultSignalManager implements SignalManager {
	private final Map<Class<?>, List<SignalListener<?>>> listeners;
	
	public DefaultSignalManager() {
		this.listeners = new HashMap<>();
	}
	
	private final List<SignalListener<?>> getListeners(final Class<?> clazz) {
		return this.listeners.computeIfAbsent(
			clazz,
			x -> new ArrayList<>()
		);
	}

	@Override
	public final <T> void addListener(final SignalListener<T> listener) {
		this.getListeners(listener.getSignalClass()).add(listener);
	}

	@Override
	public final <T> void removeListener(final SignalListener<T> listener) {
		this.getListeners(listener.getSignalClass()).remove(listener);
	}

	@Override
	public final void fire(final Object signal) {
		this.getListeners(signal.getClass()).stream()
			.filter(listener -> listener.getSignalClass().isInstance(signal))
			.forEach(listener -> listener.receive(signal));
	}
}

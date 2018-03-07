package nl.jchmb.netspace.signal.manager;

import java.util.HashMap;
import java.util.Map;

import nl.jchmb.netcode.signal.SignalListener;

public class DefaultSignalManager implements SignalManager {
	private final Map<Class<?>, SignalListener<?>> listeners;
	
	public DefaultSignalManager() {
		this.listeners = new HashMap<>();
	}

	@Override
	public final <T> void addListener(final SignalListener<T> listener) {
		this.listeners.put(listener.getSignalClass(), listener);
	}

	@Override
	public final <T> void removeListener(final Class<T> listenerClass) {
		this.listeners.remove(listenerClass);
	}

	@SuppressWarnings("unchecked")
	@Override
	public final <T> void fire(final T signal) {
		final SignalListener<T> listener = (SignalListener<T>) getListener(signal.getClass());
		if (listener != null) {
			listener.receive(signal);
		}
	}

	@SuppressWarnings("unchecked")
	private final <T> SignalListener<T> getListener(final Class<T> signalClass) {
		return (SignalListener<T>) listeners.get(signalClass);
	}
}

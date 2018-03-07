package nl.jchmb.netspace.signal.manager;

import nl.jchmb.netcode.signal.SignalListener;

public interface SignalManager {
	public <T> void addListener(final SignalListener<T> listener);
	public <T> void removeListener(final Class<T> listenerClass);
	public <T> void fire(final T signal);
}

package nl.jchmb.netspace.signal.manager;

import nl.jchmb.netspace.signal.SignalListener;

public interface SignalManager {
	public <T> void addListener(final SignalListener<T> listener);
	public <T> void removeListener(final SignalListener<T> listener);
	public <T> void fire(final T signal);
}

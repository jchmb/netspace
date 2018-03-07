package nl.jchmb.netspace.signal;

public interface SignalListener<T> {
	public Class<T> getSignalClass();
	public void receive(final T signal);
}

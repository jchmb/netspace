package nl.jchmb.netspace.signal;

public interface SignalListener<T> {
	public Class<T> getSignalClass();
	
	public default void receive(final Object signal) {
		this.onReceive(this.getSignalClass().cast(signal));
	}
	
	public void onReceive(final T signal);
}

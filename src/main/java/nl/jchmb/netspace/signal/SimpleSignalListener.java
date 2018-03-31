package nl.jchmb.netspace.signal;

import java.util.function.Consumer;

public class SimpleSignalListener<T> implements SignalListener<T> {
	private final Class<T> signalClass;
	private final Consumer<T> consumer;
	
	public SimpleSignalListener(
			final Class<T> signalClass,
			final Consumer<T> consumer
	) {
		this.signalClass = signalClass;
		this.consumer = consumer;
	}

	@Override
	public final Class<T> getSignalClass() {
		return this.signalClass;
	}

	@Override
	public final void onReceive(final T signal) {
		this.consumer.accept(signal);
	}
}

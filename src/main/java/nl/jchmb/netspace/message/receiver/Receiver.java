package nl.jchmb.netspace.message.receiver;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public abstract class Receiver<T> extends Listener {
	@Override
	public final void received(
			final Connection connection,
			final Object object
	) {
		final Class<T> clazz = this.getMessageClass();
		if (clazz.isInstance(object)) {
			this.process(
				connection,
				clazz.cast(object)
			);
		}
	}
	
	protected abstract Class<T> getMessageClass();
	
	protected abstract void process(
		final Connection connection,
		final T msg
	);
}

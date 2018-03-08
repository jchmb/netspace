package nl.jchmb.netspace.message.receiver;

import java.util.function.BiConsumer;

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
	
	public static <T> Receiver<T> of(
			final Class<T> messageClass,
			final BiConsumer<Connection, T> consumer
	) {
		return new Receiver<>() {

			@Override
			protected final Class<T> getMessageClass() {
				return messageClass;
			}

			@Override
			protected final void process(
					final Connection connection,
					T msg
			) {
				consumer.accept(
					connection,
					msg
				);
			}
			
		};
	}
}

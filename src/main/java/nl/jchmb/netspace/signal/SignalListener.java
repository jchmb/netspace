package nl.jchmb.netspace.signal;

import java.util.function.Consumer;

public interface SignalListener {
	public boolean accept(final Object signal);
	public void receive(final Object signal);
}

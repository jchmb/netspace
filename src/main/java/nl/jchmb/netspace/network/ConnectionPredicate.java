package nl.jchmb.netspace.network;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Server;

import nl.jchmb.netspace.space.ServerNetSpace;

@FunctionalInterface
public interface ConnectionPredicate<C extends Connection, T extends Server> {
	public boolean evaluate(final C connection, final ServerNetSpace<C, T> space);
}

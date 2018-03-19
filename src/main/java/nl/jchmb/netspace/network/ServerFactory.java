package nl.jchmb.netspace.network;

import com.esotericsoftware.kryonet.Server;

public interface ServerFactory<T extends Server> {
	public T create();
}

package nl.jchmb.netspace.network;

import com.esotericsoftware.kryonet.Server;

public interface ServerFactory {
	public Server create();
}

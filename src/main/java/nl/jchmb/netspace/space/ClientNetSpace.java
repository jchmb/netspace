package nl.jchmb.netspace.space;

import com.esotericsoftware.kryonet.Client;

import nl.jchmb.netspace.message.receiver.EntityDestroyMessageReceiver;
import nl.jchmb.netspace.message.receiver.EntitySpawnMessageReceiver;
import nl.jchmb.netspace.message.receiver.EntityUpdateMessageReceiver;

public class ClientNetSpace extends BaseNetSpace {
	public ClientNetSpace(final Client client) {
		super(client);
		
		this.addListener(
			new EntitySpawnMessageReceiver(this.entities())
		);
		this.addListener(
			new EntityDestroyMessageReceiver(this.entities())
		);
		this.addListener(
			new EntityUpdateMessageReceiver(this.entities())
		);
	}

	@Override
	public boolean isServer() {
		return false;
	}

	@Override
	public boolean isClient() {
		return true;
	}
}

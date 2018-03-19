package nl.jchmb.netspace.space;

import java.io.IOException;

import com.esotericsoftware.kryonet.EndPoint;

import nl.jchmb.netspace.entity.manager.EntityManager;
import nl.jchmb.netspace.message.registry.MessageRegistry;
import nl.jchmb.netspace.network.Connector;
import nl.jchmb.netspace.system.manager.SystemManager;

public interface NetSpace {
	public EntityManager entities();
	public SystemManager systems();
	public MessageRegistry messages();
	public EndPoint getEndPoint();
	public void connect(final Connector connector) throws IOException;
	public boolean isServer();
	public boolean isClient();
	public void onUpdate(final double dt);
}

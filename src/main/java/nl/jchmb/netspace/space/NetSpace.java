package nl.jchmb.netspace.space;

import nl.jchmb.netspace.entity.manager.EntityManager;
import nl.jchmb.netspace.message.registry.MessageRegistry;

public interface NetSpace {
	public EntityManager entities();
	public MessageRegistry messages();
	public boolean isServer();
	public boolean isClient();
}

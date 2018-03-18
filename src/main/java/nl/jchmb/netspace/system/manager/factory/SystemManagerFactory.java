package nl.jchmb.netspace.system.manager.factory;

import nl.jchmb.netspace.space.NetSpace;
import nl.jchmb.netspace.system.manager.SystemManager;

@FunctionalInterface
public interface SystemManagerFactory {
	public SystemManager create(final NetSpace space);
}

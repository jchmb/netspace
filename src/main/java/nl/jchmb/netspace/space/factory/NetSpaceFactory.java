package nl.jchmb.netspace.space.factory;

import nl.jchmb.netspace.space.NetSpace;

public interface NetSpaceFactory<T extends NetSpace> {
	public T create();
}

package nl.jchmb.netspace.message.hydrator;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

import nl.jchmb.netcode.hydrator.Hydrator;
import nl.jchmb.netcode.hydrator.IntegerHydrator;
import nl.jchmb.netspace.entity.Entity;
import nl.jchmb.netspace.entity.Entity.ID;

public class EntityIDHydrator implements Hydrator<ID> {
	private final IntegerHydrator hydrator = new IntegerHydrator();
	
	@Override
	public final ID hydrate(final ByteBuffer buffer) throws BufferUnderflowException {
		return new ID(this.hydrator.hydrate(buffer));
	}

	@Override
	public final void dehydrate(final ByteBuffer buffer, final ID object) throws BufferOverflowException {
		this.hydrator.dehydrate(buffer, object.id);
	}
	
}

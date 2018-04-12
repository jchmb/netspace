package nl.jchmb.netspace.entity;

import nl.jchmb.netspace.component.manager.ComponentManager;
import nl.jchmb.netspace.signal.manager.SignalManager;
import nl.jchmb.netspace.space.NetSpace;

public interface Entity {
	public ComponentManager components();
	public SignalManager signals();
	public void onSpawn();
	public void onDestroy();
	public ID getID();
	public void setID(final ID id);
	public NetSpace getSpace();
	public void setSpace(final NetSpace space);
	public boolean isPrivate();
	
	public class ID {
		public int value;
		
		public ID(final int value) {
			this.value = value;
		}
		
		public ID() {
			this.value = 0;
		}
		
		public ID next() {
			return this.value > 0 ?
				new ID(this.value + 1) :
				new ID(this.value - 1);
		}
		
		@Override
		public boolean equals(final Object obj) {
			if (!(obj instanceof ID)) {
				return false;
			}
			final ID that = (ID) obj;
			return this.value == that.value;
		}
		
		@Override
		public int hashCode() {
			return this.value;
		}
	}
	
	public class Type {
		public short value;
		
		public Type(final short value) {
			this.value = value;
		}
		
		public Type() {
			this.value = 0;
		}
		
		public Type next() {
			return new Type(
				(short) (this.value + 1)	
			);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Type)) {
				return false;
			}
			final Type that = (Type) obj;
			return this.value == that.value;
		}
		
		@Override
		public int hashCode() {
			return this.value;
		}
	}
}

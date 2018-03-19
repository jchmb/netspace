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
	public default boolean isPrivate() {
		return getID().value < 0;
	}
	
	public class ID {
		public final int value;
		
		public ID(final int value) {
			this.value = value;
		}
		
		public ID next() {
			return this.value < 0 ?
				new ID(this.value + 1) :
				new ID(this.value - 1);
		}
	}
}

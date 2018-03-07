package nl.jchmb.netspace.entity;

import nl.jchmb.netspace.component.manager.ComponentManager;
import nl.jchmb.netspace.signal.manager.SignalManager;

public interface Entity {
	public ComponentManager components();
	public SignalManager signals();
	
	public void onSpawn();
	public void onDestroy();
	public ID getID();
	
	public class ID {
		public final int id;
		
		public ID(final int id) {
			this.id = id;
		}
	}
}

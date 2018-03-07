package nl.jchmb.netspace.message;

import nl.jchmb.netspace.component.Component;
import nl.jchmb.netspace.entity.Entity;

public abstract class ComponentUpdateMessage<T extends Component> {
	public Entity.ID entityID;
	
	public abstract void doUpdate(final T component);
}

package nl.jchmb.netspace.component;

import nl.jchmb.netspace.component.exception.UnboundComponentException;
import nl.jchmb.netspace.entity.Entity;

public abstract class BaseComponent implements Component {
	private Entity entity;

	public BaseComponent() {
		this.entity = null;
	}

	@Override
	public final Entity getEntity() {
		if (this.entity == null) {
			throw new UnboundComponentException();
		}
		return this.entity;
	}

	@Override
	public final void setEntity(Entity entity) {
		this.entity = entity;
	}

	@Override
	public void onAttach() {}

	@Override
	public void onDetach() {}

	@Override
	public void onSpawn() {}

	@Override
	public void onDestroy() {}


}

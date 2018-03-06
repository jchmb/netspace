package nl.jchmb.netspace.component;

import nl.jchmb.netspace.entity.Entity;

public interface Component {
	public void setEntity(final Entity entity);
	public Entity getEntity();
	public void onAttach();
	public void onDetach();
	public void onSpawn();
	public void onDestroy();
}

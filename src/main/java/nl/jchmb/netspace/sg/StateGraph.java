package nl.jchmb.netspace.sg;

import java.util.Map;

import nl.jchmb.netspace.entity.Entity;

public interface StateGraph {
	public State getState();
	public void setState(final State state);
	public void setEntity(final Entity entity);
	
	public static interface State {
		public String getName();
		public void onEnter(final Entity entity);
		public void onExit(final Entity entity);
	}
	
	public static class SimpleState implements State {
		private final String name;
		
		public SimpleState(final String name) {
			this.name = name;
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public void onEnter(Entity entity) {}

		@Override
		public void onExit(Entity entity) {}
		
		
	}
}

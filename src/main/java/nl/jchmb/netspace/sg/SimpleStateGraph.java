package nl.jchmb.netspace.sg;

import java.util.HashMap;
import java.util.Map;

import nl.jchmb.netspace.entity.Entity;

public class SimpleStateGraph implements StateGraph {
	private final Map<String, State> states;
	private final State currentState;
	private Entity entity;
	
	public SimpleStateGraph(final State initialState) {
		this.states = new HashMap<>();
		this.currentState = initialState;
	}
	
	@Override
	public final State getState() {
		return this.currentState;
	}

	@Override
	public final void setState(final State state) {
		this.currentState.onExit(entity);
	}

	@Override
	public final void setEntity(final Entity entity) {
		this.entity = entity;
	}
	
}

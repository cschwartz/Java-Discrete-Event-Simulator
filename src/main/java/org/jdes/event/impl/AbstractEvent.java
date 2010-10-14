package org.jdes.event.impl;

import org.jdes.event.Event;
import org.jdes.simulator.Simulator;

/**
 * Abstract base class for {@link Event} classes. Implements the
 * <code>timeOfOccurence</code> related operations.
 * 
 * @author Christian Schwartz
 * 
 */
public abstract class AbstractEvent implements Event {

	/**
	 * 
	 */
	protected Simulator simulator;

	/**
	 * The time on which the event occurs.
	 */
	protected double timeOfOccurence;

	/**
	 * An event id, unique to this event in this simulation.
	 */
	protected long eventId;

	/**
	 * Create a new event which will be scheduled to occur on the given time.
	 * 
	 * @param newSimulator
	 *            The simulator hosting this event
	 * 
	 * @param newTimeOfOccurence
	 *            The time when the event will occur.
	 * 
	 * @param newEventId
	 *            An event id, unique to this event in this simulation
	 */
	public AbstractEvent(Simulator simulator, final double newTimeOfOccurence) {
		this.simulator = simulator;
		this.timeOfOccurence = newTimeOfOccurence;
		this.eventId = simulator.getNextEventId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	final public int compareTo(final Event other) {
		int timeDelta = Double.compare(this.getTimeOfOccurence(),
				other.getTimeOfOccurence());

		if (timeDelta == 0) {
			return Long.signum(eventId - other.getId());
		} 
		
		return timeDelta;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getTimeOfOccurence() {
		return timeOfOccurence;
	}
	
	@Override
	public long getId() {
		return eventId;
	}
}

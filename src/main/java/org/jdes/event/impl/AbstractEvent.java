package org.jdes.event.impl;

import org.jdes.event.Event;

/**
 * Abstract base class for {@link Event} classes. Implements the
 * <code>timeOfOccurence</code> related operations.
 * 
 * @author Christian Schwartz
 * 
 */
public abstract class AbstractEvent implements Event {
    /**
     * The time on which the event occurs.
     */
    protected double timeOfOccurence;

    /**
     * Create a new event which will be scheduled to occur on the given time.
     * 
     * @param newTimeOfOccurence
     *            The time when the event will occur.
     */
    public AbstractEvent(final double newTimeOfOccurence) {
        this.timeOfOccurence = newTimeOfOccurence;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(final Event other) {
        return Double.compare(this.getTimeOfOccurence(),
                other.getTimeOfOccurence());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getTimeOfOccurence() {
        return timeOfOccurence;
    }

}

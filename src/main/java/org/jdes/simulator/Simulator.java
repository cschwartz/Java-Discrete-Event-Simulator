package org.jdes.simulator;

import org.jdes.event.Event;

/**
 * The simulator processes a sequence of {@link Event}s ordered by time of
 * occurence.
 *
 * @author Christian Schwartz
 * 
 */
public interface Simulator {
    /**
     * Add an {@link Event} to the simulation queue.
     *
     * @param event
     *            The event to add to the queue.
     */
    void addEvent(Event event);

    /**
     * Run the simulation.
     */
    void run();

    /**
     * Get the current time of the simulation.
     *
     * @return The current simulation time.
     */
    double getCurrentTime();

    /**
     * Returns the next event id to be used for a new event.
     * 
     * @return The next event id
     */
	long getNextEventId();
}

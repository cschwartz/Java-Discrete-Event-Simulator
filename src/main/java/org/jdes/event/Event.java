package org.jdes.event;

/**
 * Events drive the simulation process. They are scheduled to occur at a certain
 * time in the simulation timeline and are then executed. They may schedule new
 * events in the simulator during their execution.
 * Events are totally ordered by their time of occurence.
 *
 * @author Christian Schwartz
 *
 */
public interface Event extends Comparable<Event> {
    /**
     * Returns the events time of occurence.
     * @return The time the event occurs.
     */
    double getTimeOfOccurence();

    /**
     * Returns the events simulation-unique id.
     * @return The event id.
     */
    long getId();
    
    /**
     * Execute the event.
     */
    void execute();
}

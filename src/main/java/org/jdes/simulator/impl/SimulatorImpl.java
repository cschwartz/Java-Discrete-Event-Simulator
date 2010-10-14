package org.jdes.simulator.impl;

import java.util.PriorityQueue;

import org.jdes.event.Event;
import org.jdes.event.StopSimulationEvent;
import org.jdes.guice.InjectLogger;
import org.jdes.simulator.Simulator;
import org.slf4j.Logger;

import com.google.inject.Inject;

/**
 * The default implementation of the {@link Simulator} interface.
 * 
 * @author Christian Schwartz
 * 
 */
public class SimulatorImpl implements Simulator {

    /**
     * A priority queue which stores the simulation {@link Event}s. The
     * simulation loop is executed while events are left or the simulation is
     * stopped by an event (see {@link StopSimulationEvent}).
     */
    PriorityQueue<Event> eventQueue = new PriorityQueue<Event>();

    /**
     * The current time of the simulation. The time is increased in discrete
     * steps while events are processed.
     */
    double currentTime = 0;

    /**
     * Status variable to track whether the simulation is still running or is
     * supposed to be stopped.
     */
    protected boolean stop = false;

    /**
     * The next event id.
     */
    protected long nextEventId = 0;

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
    	logger.info("Starting Simulation.");
    	
        Event event = nextEvent();
        while (event != null && !stop) {
            currentTime = event.getTimeOfOccurence();
            event.execute();
            event = nextEvent();
        }
        
        logger.info("Simulation stopped at {}.", currentTime);
    }

    @InjectLogger protected Logger logger;
    
    /**
     * Fetch the {@link Event} closest to the <code>currentTime</code>.
     * @return The next event to process.
     */
    protected Event nextEvent() {
        return eventQueue.poll();
    }

    /**
     * {@inheritDoc} 
     */
    @Override
    public double getCurrentTime() {
        return currentTime;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addEvent(final Event event) {
        eventQueue.add(event);
    }

    /**
     * Stops the simulation.
     */
    public void stop() {
        this.stop = true;
    }
    
    @Override
	public long getNextEventId() {
    	long newEventId = nextEventId;
    	nextEventId += 1;
    	return newEventId;
    }
}

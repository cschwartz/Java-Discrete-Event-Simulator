package org.jdes.event.impl;

import org.jdes.event.StopSimulationEvent;
import org.jdes.simulator.impl.SimulatorImpl;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

/**
 * Implementation of the {@link StopSimulationEvent} for the
 * {@link SimulatorImpl} class.
 *
 * @author Christian Schwartz
 *
 */
public class StopSimulatorEventImpl extends AbstractEvent implements
        StopSimulationEvent {
    /**
     * The simulator to stop.
     */
    protected SimulatorImpl simulator;

    /**
     * Create a new event to stop a given simulator on a given point in time.
     * 
     * @param newSimulator
     *            The simulator to stop.
     * @param timeToStop
     *            The time when the simulator should be stopped.
     */
    @Inject
    public StopSimulatorEventImpl(final SimulatorImpl newSimulator,
            @Assisted final double timeToStop) {
        super(timeToStop);
        this.simulator = newSimulator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        simulator.stop();
    }

}

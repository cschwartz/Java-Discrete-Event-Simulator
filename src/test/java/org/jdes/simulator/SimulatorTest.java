package org.jdes.simulator;

import static org.junit.Assert.*;

import org.jdes.event.StopSimulationEvent;
import org.jdes.event.factory.StopSimulationEventFactory;
import org.jdes.guice.SimulatorModule;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Unit test for the main simulator class.
 */
public class SimulatorTest {
    Injector injector;

    @Before
    public void setup() {
        SimulatorModule module = new SimulatorModule();
        injector = Guice.createInjector(module);
    }

    @Test
    public void simulatorStops() {
        Simulator simulator = injector.getInstance(Simulator.class);
        StopSimulationEventFactory factory = injector
                .getInstance(StopSimulationEventFactory.class);
        StopSimulationEvent event = factory.create(5.0);
        simulator.addEvent(event);
        event = factory.create(10.0);
        simulator.addEvent(event);

        simulator.run();
        assertEquals(simulator.getCurrentTime(), 5.0);
    }
}

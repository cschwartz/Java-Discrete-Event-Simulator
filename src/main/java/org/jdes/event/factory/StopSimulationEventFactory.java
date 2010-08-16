package org.jdes.event.factory;

import org.jdes.event.StopSimulationEvent;

public interface StopSimulationEventFactory {
    StopSimulationEvent create(double timeToStop);
}

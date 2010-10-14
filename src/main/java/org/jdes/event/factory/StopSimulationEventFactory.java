package org.jdes.event.factory;

import org.jdes.event.StopSimulationEvent;

import com.google.inject.assistedinject.Assisted;

public interface StopSimulationEventFactory {
    StopSimulationEvent create(@Assisted("timeToStop") double timeToStop);
}

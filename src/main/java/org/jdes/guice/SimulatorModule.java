package org.jdes.guice;

import java.util.Random;

import org.jdes.counter.MeanCounter;
import org.jdes.counter.impl.MeanCounterImpl;
import org.jdes.event.factory.StopSimulationEventFactory;
import org.jdes.event.impl.StopSimulatorEventImpl;
import org.jdes.randomvariable.NegativeExponentialRandomVariable;
import org.jdes.randomvariable.NormalRandomVariable;
import org.jdes.randomvariable.impl.NegativeExponentialRandomVariableImpl;
import org.jdes.randomvariable.impl.NormalRandomVariableImpl;
import org.jdes.simulator.Simulator;
import org.jdes.simulator.impl.SimulatorImpl;

import com.google.inject.Binder;
import com.google.inject.Singleton;
import com.google.inject.assistedinject.FactoryProvider;
import com.google.inject.matcher.Matchers;

public class SimulatorModule implements com.google.inject.Module {

	@Override
	public void configure(final Binder binder) {
		binder.bindListener(Matchers.any(), new SLF4JTypeListener());
		
		binder.bind(Random.class);

		binder.bind(NormalRandomVariable.class).to(
				NormalRandomVariableImpl.class);

		binder.bind(NegativeExponentialRandomVariable.class).to(
				NegativeExponentialRandomVariableImpl.class);

		binder.bind(MeanCounter.class).to(MeanCounterImpl.class);
		
		binder.bind(Simulator.class).to(SimulatorImpl.class);
		binder.bind(SimulatorImpl.class).in(Singleton.class);

		binder.bind(StopSimulationEventFactory.class).toProvider(
				FactoryProvider.newFactory(StopSimulationEventFactory.class,
						StopSimulatorEventImpl.class));
	}
}

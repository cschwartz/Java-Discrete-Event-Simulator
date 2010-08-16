package org.jdes.randomvariables;

import org.jdes.guice.SimulatorModule;
import org.jdes.randomvariable.NormalRandomVariable;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class NormalRandomVariableImplTest {

    NormalRandomVariable normalRV;

    @Before
    public void setup() {
        SimulatorModule module = new SimulatorModule();
        Injector injector = Guice.createInjector(module);
        normalRV = injector.getInstance(NormalRandomVariable.class);
    }

    @Test
    public void testMean() {
        int runs = 10000;
        double currentMean = 0;

        for (int i = 1; i < runs; i++) {
            double nextValue = normalRV.getNext();
            System.out.print(nextValue);
            System.out.print(';');
            currentMean = (currentMean * (i - 1) + nextValue) / i;
        }
    }
}

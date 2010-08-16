package org.jdes;

import org.jdes.randomvariables.NormalRandomVariableImplTest;
import org.jdes.simulator.SimulatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ NormalRandomVariableImplTest.class, SimulatorTest.class })
public class JdesTest {

}

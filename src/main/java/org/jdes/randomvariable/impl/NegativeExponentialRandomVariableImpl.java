package org.jdes.randomvariable.impl;

import java.util.Random;

import org.jdes.randomvariable.NegativeExponentialRandomVariable;

import com.google.inject.Inject;

public class NegativeExponentialRandomVariableImpl extends RandomVariableImpl
		implements NegativeExponentialRandomVariable {

	
	protected double lambda;
	protected Random uniformRV;
	
	@Inject
	public NegativeExponentialRandomVariableImpl(Random uniformRV) {
		this.uniformRV = uniformRV;
		this.lambda = 1;
	}
	
	
	@Override
	public double getNext() {
		return -Math.log(uniformRV.nextFloat())/lambda;
	}

	@Override
	public double getMean() {
		return 1/lambda;
	}

	@Override
	public double getVariance() {
		return 1/(lambda * lambda);
	}


	@Override
	public double getLambda(double lambda) {
		return lambda;
	}


	@Override
	public void setLambda(double lambda) {
		this.lambda = lambda;
	}

}

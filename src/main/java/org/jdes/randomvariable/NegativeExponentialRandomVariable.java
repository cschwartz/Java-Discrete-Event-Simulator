package org.jdes.randomvariable;

public interface NegativeExponentialRandomVariable extends DoubleRandomVariable {
	double getLambda(double lambda);
	void setLambda(double lambda);
}

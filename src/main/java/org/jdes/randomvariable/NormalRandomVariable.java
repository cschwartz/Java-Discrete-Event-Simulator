package org.jdes.randomvariable;

public interface NormalRandomVariable extends DoubleRandomVariable {
    void setMean(double mean);

    void setVariance(double variance);
}

package org.jdes.counter;

/**
 * Calculate the empirical mean of the assigned {@link Countable}.
 *
 * @author Christian Schwartz
 *
 */
public interface MeanCounter extends Counter {
    /**
     * Returns the empirical mean of the countable..
     * @return The empirical mean.
     */
    double getEmpiricalMean();
}

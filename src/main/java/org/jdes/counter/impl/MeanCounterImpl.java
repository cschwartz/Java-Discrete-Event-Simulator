package org.jdes.counter.impl;

import org.jdes.counter.MeanCounter;

/**
 * Calculates a moving average over the reported values x_i, in such a way that
 * the mean m_i after the i-th reported value is given by
 * <code>m_i = (m_{i-1} * (i-1)
 * + x_i)/i</code>. Note, that the values x_i are not stored.
 *
 * @author Christian Schwartz
 */
public class MeanCounterImpl implements MeanCounter {

    /**
     * The mean up to the most current reported value.
     */
    protected double currentMean;

    /**
     * The number of reported values so far.
     */
    protected int numberOfReportedValues = 0;

    /**
     * {@inheritDoc}
     */
    @Override
    public void newValueProduced(final double value) {
        numberOfReportedValues++;
        currentMean = ((currentMean * (numberOfReportedValues - 1)) + value)
                / numberOfReportedValues;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getEmpiricalMean() {
        return currentMean;
    }
}

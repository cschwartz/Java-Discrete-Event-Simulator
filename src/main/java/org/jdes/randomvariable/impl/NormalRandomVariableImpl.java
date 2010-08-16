package org.jdes.randomvariable.impl;

import java.util.Random;

import org.jdes.randomvariable.NormalRandomVariable;

import com.google.inject.Inject;

public class NormalRandomVariableImpl extends RandomVariableImpl implements
        NormalRandomVariable {

    /**
     * The PRNG used to create the uniformly distrubuted random values required
     * for normal RV generation.
     */
    protected Random random;

    /**
     * Whether a secons normal distributed number is available or if new numbers
     * have to be generated.
     */
    protected boolean hasNext;

    /**
     * If hasNext is true, the value of a second normal distributed number, else
     * undefined.
     */
    protected double next;

    /**
     * The theoretical mean of the normal RV.
     */
    protected double mean;

    /**
     * The theoretical variance of the normal RV.
     */
    protected double variance;

    /**
     * Create a new Normal RandomVariable with mean 0 and variance 1.
     * 
     * @param newRandom
     *            The PRNG used to create the required uniformly distributed
     *            numbers.
     */
    @Inject
    public NormalRandomVariableImpl(Random newRandom) {
        this.random = newRandom;
        this.mean = 0;
        this.variance = 1;
        hasNext = false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getNext() {
        if (hasNext) {
            hasNext = false;
            return next;
        } else {
            double q;
            double p;
            double u1;
            double u2;
            do {
                u1 = 2 * random.nextDouble() - 1;
                u2 = 2 * random.nextDouble() - 1;
                q = u1 * u1 + u2 * u2;
                // FIXME: add iteration limit
            } while (q > 1);
            p = Math.sqrt(-2 * Math.log(q) / q);
            next = mean + (p * u2) * variance;
            hasNext = true;
            return mean + (p * u1) * variance;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getMean() {
        return mean;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getVariance() {
        return variance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMean(final double newMean) {
        hasNext = false;
        this.mean = newMean;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVariance(final double newVariance) {
        hasNext = false;
        this.variance = newVariance;
    }
}

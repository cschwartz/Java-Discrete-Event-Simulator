package org.jdes.randomvariable;

import org.jdes.counter.Countable;
import org.jdes.util.PropertyChangeProvider;

/**
 * A random variable. Random variables are {@link Countable} regarding the
 * values they produce and {@link PropertyChangeProvider}s for their moments.
 *
 * @author Christian Schwartz
 *
 */
public interface RandomVariable extends Countable, PropertyChangeProvider {
    /**
     * The property name for the random variables mean.
     */
    String PROPERTY_MEAN = RandomVariable.class.getName().concat(".Mean");

    /**
     * The property name for the random variables variance.
     */
    String PROPERTY_VARIANCE = RandomVariable.class.getName().concat(
            ".Variance");

    /**
     * The (theoretic) mean of the random variable.
     *
     * @return The mean.
     */
    double getMean();

    /**
     * The (theoretic) variance of the random variable.
     *
     * @return The variance.
     */
    double getVariance();
}

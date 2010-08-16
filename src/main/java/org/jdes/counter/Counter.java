package org.jdes.counter;

/**
 * Counters are notified of value changes by the {@link Countable}s they are
 * registered to.
 * 
 * @author Christian Schwartz
 * 
 */
public interface Counter {
    /**
     * Notify the counter, that a new value has been produced.
     * 
     * @param value
     *            The new value.
     */
    void newValueProduced(double value);
}

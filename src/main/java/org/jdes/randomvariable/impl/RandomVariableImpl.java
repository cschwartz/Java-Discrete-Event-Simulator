package org.jdes.randomvariable.impl;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;
import java.util.List;

import org.jdes.counter.Countable;
import org.jdes.counter.CountableSupport;
import org.jdes.counter.Counter;
import org.jdes.randomvariable.RandomVariable;

/**
 * Abstract base class for Random Variables which also provides support for the
 * countable interface.
 *
 * @author Christian Schwartz
 *
 */
public abstract class RandomVariableImpl implements RandomVariable, Countable {

    /**
     * Delegate for the countable support.
     */
    protected CountableSupport countableSupport = new CountableSupport();

    /**
     * Delegate for the property change support.
     */
    protected PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
            this);

    /**
     * {@inheritDoc}
     */
    @Override
    public void addCounter(final Counter counter) {
        countableSupport.addCounter(counter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeCounter(final Counter counter) {
        countableSupport.removeCounter(counter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Counter> getCounters() {
        return countableSupport.getCounters();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removePropertyChangeListener(
            final PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PropertyChangeListener> getPropertyChangeListeners() {
        return Arrays
                .asList(propertyChangeSupport.getPropertyChangeListeners());
    }
}

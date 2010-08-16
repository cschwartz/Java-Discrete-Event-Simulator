package org.jdes.util;

import java.beans.PropertyChangeListener;
import java.util.List;

/**
 * Provides operations to add, remove and list all {@link PropertyChangeListener} for
 * an object.
 *
 * @author Christian Schwartz
 *
 */
public interface PropertyChangeProvider {

    /**
     * Add a new {@link PropertyChangeListener} to an object.
     * @param listener The new listener.
     */
    abstract void addPropertyChangeListener(
            PropertyChangeListener listener);

    /**
     * Remove a {@link PropertyChangeListener} from an object.
     * @param listener The listener to remove.
     */
    abstract void removePropertyChangeListener(
            PropertyChangeListener listener);

    /**
     * Get all registered {@link PropertyChangeListener}s of this object.
     * @return An unmodifyable list of listeners.
     */
    abstract List<PropertyChangeListener> getPropertyChangeListeners();

}
package org.jdes.counter;

import java.util.List;

/**
 * Classes implementing the <code>Countable</code> interface allow
 * {@link Counter} objects to be added which observe a numeric state of the
 * <code>Countable</code> object.
 *
 * @author Christian Schwartz
 */
public interface Countable {
    /**
     * Adds a {@link Counter} object to the <code>Countable</code> countable. If
     * the <code>Counter</code> has already been added, nothing happens.
     *
     * @param counter
     *            The {@link Counter} to add.
     */
    void addCounter(Counter counter);

    /**
     * Removes a {@link Counter} from the <code>Countable</code>. If the
     * <code>Counter</code> is not part of the <code>Countable</code> nothing
     * happens.
     *
     * @param counter
     *            The {@link Counter} to remove.
     */
    void removeCounter(Counter counter);

    /**
     * Returns an unmodifiable list of all {@link Counter} instances added to
     * this <code>Countable</code>.
     *
     * @return The {@link Counter} instances for this <code>Countable</code>.
     */
    List<Counter> getCounters();
}

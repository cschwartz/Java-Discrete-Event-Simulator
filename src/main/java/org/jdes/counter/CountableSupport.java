package org.jdes.counter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Utility class for {@link Countable}. Implementors of <code>Countable</code> can delegate to this class.
 * @author Christian Schwartz
 *
 */
public class CountableSupport implements Countable {
    /**
     * The registered {@link Counter}s.
     */
    List<Counter> counters = new LinkedList<Counter>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void addCounter(final Counter counter) {
        if (!counters.contains(counter)) {
            counters.add(counter);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeCounter(final Counter counter) {
        counters.remove(counter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Counter> getCounters() {
        return Collections.unmodifiableList(counters);
    }

}

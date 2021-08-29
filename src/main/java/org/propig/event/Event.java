package org.propig.event;

import java.util.EventObject;

public abstract class Event extends EventObject {
    private static final long serialVersionUID = 6467627558946324837L;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public Event(Object source) {
        super(source);
    }
}

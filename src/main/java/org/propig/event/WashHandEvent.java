package org.propig.event;

public class WashHandEvent extends Event{
    private static final long serialVersionUID = -2443716213956453883L;

    public String getEventName() {
        return eventName;
    }

    private String eventName;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public WashHandEvent(Object source, String eventName) {
        super(source);
        this.eventName = eventName;
    }
}

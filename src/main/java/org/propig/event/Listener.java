package org.propig.event;

import java.util.EventListener;

public interface Listener extends EventListener {
    void fireAfterEventInvoked(Event event);
}

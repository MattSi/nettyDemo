package org.propig.event;

public class WashHandListener implements Listener{
    @Override
    public void fireAfterEventInvoked(Event event) {
        WashHandEvent washHandEvent = (WashHandEvent) event;

        System.out.println("Prepare: " + washHandEvent.getEventName());
    }
}

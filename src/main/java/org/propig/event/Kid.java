package org.propig.event;

import java.util.ArrayList;
import java.util.List;

public class Kid {
    private String name;
    private List<Listener> listeners;

    public Kid(String name) {
        this.name = name;
        this.listeners = new ArrayList<>();
    }

    public void eat(){

        for(Listener listener: listeners){
            if(listener instanceof WashHandListener){
                listener.fireAfterEventInvoked(new WashHandEvent(this, "饭前洗手"));
            }
        }

        System.out.println("Eating...");
    }

    public void addListener(Listener listener){
        if(!listeners.contains(listener)){
            listeners.add(listener);
        }
    }

    public void removeListener(Listener listener){
        if(listeners.contains(listener)){
            listeners.remove(listener);
        }
    }
}

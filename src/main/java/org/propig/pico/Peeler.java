package org.propig.pico;

import org.picocontainer.Startable;

public class Peeler implements Startable {
    private final Peelable peelable;

    public Peeler(Peelable peelable) {
        this.peelable = peelable;
        System.out.println("Peeler Built");
    }

    @Override
    public void start() {
        peelable.peel();
    }

    @Override
    public void stop() {

    }
}

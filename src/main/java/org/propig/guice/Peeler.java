package org.propig.guice;

import com.google.inject.Singleton;
import org.picocontainer.Startable;


@Singleton
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

package org.propig.guice;

import com.google.inject.Singleton;

@Singleton
public class Orange implements Peelable, Poolable {
    @Override
    public void peel() {
        System.out.println("Peel Orange");
    }

    @Override
    public void pool() {
        System.out.println("Pool Orange");
    }

    public Orange() {
        System.out.println("Orange Built");
    }
}

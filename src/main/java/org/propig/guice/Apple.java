package org.propig.guice;

import com.google.inject.Singleton;

@Singleton
public class Apple implements Peelable, Poolable {
    private final Orange orange;
    private final Pear pear;
    private final Banana banana;

    public Apple(Orange orange, Pear pear, Banana banana) {
        this.orange = orange;
        this.pear = pear;
        this.banana = banana;
    }

    @Override
    public void peel() {
        System.out.println("Peel Apple");
    }

    @Override
    public void pool() {
        System.out.println("Pool Apple");
    }
}

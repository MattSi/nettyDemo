package org.propig.pico;

public class Banana implements Peelable, Poolable{
    public Banana() {
        System.out.println("Banana Built");
    }

    @Override
    public void peel() {
        System.out.println("Peel Banana");
    }

    @Override
    public void pool() {
        System.out.println("Pool Banana");
    }
}

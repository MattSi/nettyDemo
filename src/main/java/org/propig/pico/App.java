package org.propig.pico;

public class App {
    public static void main(String[] args) {

        Container.init();
        System.out.println("==============================");
        Juicer juicer1 = (Juicer) Container.getComponent("org.propig.pico.AppleBanana");
        juicer1.peel();
        juicer1.pool();


        Juicer juicer2 = (Juicer) Container.getComponent("org.propig.pico.AppleOrange");
        juicer2.peel();
        juicer2.pool();
    }
}

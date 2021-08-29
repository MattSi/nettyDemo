package org.propig.event;


import io.netty.buffer.ByteBuf;

public class Test {
    public static void main(String[] args) {
        Kid xiaoming = new Kid("xiaoming");
        xiaoming.eat();

        System.out.println("===============================");
        WashHandListener listener = new WashHandListener();
        xiaoming.addListener(listener);
        xiaoming.eat();

        System.out.println("===============================");
        xiaoming.removeListener(listener);
        xiaoming.eat();

    }
}

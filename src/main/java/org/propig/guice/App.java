package org.propig.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.propig.pico.Juicer;

class SampleModule extends AbstractModule{
    @Override
    protected void configure() {
        super.configure();
    }
}
public class App {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        injector.getInstance(Juicer.class);
    }
}

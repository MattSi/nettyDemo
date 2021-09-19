package org.propig.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

class AppleJuiceModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(Juicer.class).to(DefaultJuicer.class);
        bind(Peelable.class).to(Apple.class);
        bind(Poolable.class).to(Banana.class);
    }
}
public class App {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        injector.getInstance(Juicer.class);
    }
}

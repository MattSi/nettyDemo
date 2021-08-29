package org.propig.pico;

import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.behaviors.Caching;
import org.picocontainer.parameters.ComponentParameter;

public final class Container extends ContainerBase {
    public static final MutablePicoContainer cache;

    static {
        instance = new Container();
        cache = new DefaultPicoContainer(new Caching());
        cache.addComponent(Apple.class);
        cache.addComponent(Peeler.class);
        cache.addComponent(Banana.class);
        cache.addComponent(Pear.class);
        cache.addComponent(Orange.class);
        cache.addComponent("org.propig.pico.AppleBanana",
                DefaultJuicer.class,
                new ComponentParameter(Apple.class),
                new ComponentParameter(Banana.class));
        cache.addComponent("org.propig.pico.AppleOrange",
                DefaultJuicer.class,
                new ComponentParameter(Apple.class),
                new ComponentParameter(Orange.class));
    }

    static void init(){}

    protected <T> T getBaseComponent(java.lang.Class<T> tClass) {
        return cache.getComponent(tClass);
    }



    protected Object getBaseComponent(String keyOrType) {
        return cache.getComponent(keyOrType);
    }

}

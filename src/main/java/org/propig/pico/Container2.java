package org.propig.pico;

import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.behaviors.Caching;
import org.picocontainer.behaviors.OptInCaching;
import org.picocontainer.classname.DefaultClassLoadingPicoContainer;
import org.picocontainer.parameters.ComponentParameter;

import java.net.URL;

public final class Container2 extends ContainerBase {
    public static final MutablePicoContainer cache;
    public static final ClassLoader systemLoader;
    private static final ClassLoader engineLoader;

    static {
        instance = new Container2();
        systemLoader = Container2.class.getClassLoader();
        engineLoader = new EngineClassLoader(systemLoader);
        cache = new DefaultClassLoadingPicoContainer(engineLoader, new OptInCaching(), null);


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

    protected <T> T getBaseComponent(Class<T> tClass) {
        return cache.getComponent(tClass);
    }



    protected Object getBaseComponent(String keyOrType) {
        return cache.getComponent(keyOrType);
    }

    static URL[] findJars(String allowed){
        return null;
    }

}

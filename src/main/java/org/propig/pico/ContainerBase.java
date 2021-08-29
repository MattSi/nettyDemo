package org.propig.pico;

public abstract class ContainerBase {
    public static ContainerBase instance;

    protected abstract <T> T  getBaseComponent(java.lang.Class<T> tClass);
    protected abstract Object getBaseComponent(String keyOrType);


    public static <T> T getComponent(java.lang.Class<T> tClass){
        return instance == null ? null : instance.getBaseComponent(tClass);
    }

    public static Object getComponent(String keyOrType){
        return instance == null ? null : instance.getBaseComponent(keyOrType);
    }
}

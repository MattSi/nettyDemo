package org.propig.guice;

import com.google.inject.Singleton;

@Singleton
public class DefaultJuicer implements Juicer {
    private final Peelable peelable;
    private final Poolable poolable;

    public DefaultJuicer(Peelable peelable, Poolable poolable) {
        this.peelable = peelable;
        this.poolable = poolable;
        System.out.println("DefaultJuicer Built");
    }

    @Override
    public void peel() {
        peelable.peel();
    }

    @Override
    public void pool() {
        poolable.pool();
    }
}

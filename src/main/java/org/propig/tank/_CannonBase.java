package org.propig.tank;

import java.io.Serializable;

public abstract class _CannonBase implements Cannon, Serializable {
    private static final long serialVersionUID = -4920016578710822853L;
    private Bullet[] bullets;

    public _CannonBase(Bullet[] bullets) {
        this.bullets = bullets;
    }

    public _CannonBase() {
    }
}

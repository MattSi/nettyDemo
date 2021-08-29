package org.propig.tank;


import java.io.Serializable;

public abstract class _TankBase implements Tank, Serializable {
    private static final long serialVersionUID = -2892758186026321095L;
    public Cannon cannon;

    public _TankBase(Cannon cannon) {
        this.cannon = cannon;
    }
}

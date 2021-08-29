package org.propig.tank;

import java.io.Serializable;

public abstract class Bullet implements Serializable {
    private static final long serialVersionUID = -3187813415931660779L;

    private double headingRadians;
    private double x;
    private double y;
    private double power;
    private String ownerName;
    private String victimName;
    private boolean isActive;
    private int bulletId;

    public Bullet(double headingRadians, double x, double y, double power, String ownerName, String victimName, boolean isActive, int bulletId) {
        this.headingRadians = headingRadians;
        this.x = x;
        this.y = y;
        this.power = power;
        this.ownerName = ownerName;
        this.victimName = victimName;
        this.isActive = isActive;
        this.bulletId = bulletId;
    }

    public double getHeadingRadians() {
        return headingRadians;
    }

    public void setHeadingRadians(double headingRadians) {
        this.headingRadians = headingRadians;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getVictimName() {
        return victimName;
    }

    public void setVictimName(String victimName) {
        this.victimName = victimName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getBulletId() {
        return bulletId;
    }

    public void setBulletId(int bulletId) {
        this.bulletId = bulletId;
    }
}

package unsw.blackout.classes.satellites;

import unsw.utils.Angle;

public abstract class Satellite {
    private String satelliteId;
    private String type;
    private double height;
    private Angle position;
    private int range;
    private int speed;

    public Satellite(String satelliteId, String type, double height, Angle position, int range, int speed) {
        this.satelliteId = satelliteId;
        this.type = type;
        this.height = height;
        this.position = position;
        this.range = range;
        this.speed = speed;
    }

    public String getSatelliteId() {
        return satelliteId;
    }

    public String getType() {
        return type;
    }

    public double getHeight() {
        return height;
    }

    public Angle getPosition() {
        return position;
    }

    public void setPosition(Angle position) {
        this.position = position;
    }

    public int getRange(){
        return range;
    }

    public int getSpeed(){
        return speed;
    }

    public abstract void move();
}
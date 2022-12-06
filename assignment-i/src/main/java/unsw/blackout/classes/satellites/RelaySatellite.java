package unsw.blackout.classes.satellites;

import unsw.utils.Angle;
import unsw.utils.MathsHelper;

public class RelaySatellite extends Satellite {
    private int direction;
    private static final int RANGE = 300000;
    private static final int SPEED = 1500;
    public RelaySatellite(String satelliteId, double height, Angle position) {
        super(satelliteId, "RelaySatellite", height, position, RANGE, SPEED);
        if (position.toDegrees() > 140 && position.toDegrees() <= 345) {
            direction = MathsHelper.CLOCKWISE;
        }
        else {
            direction = MathsHelper.ANTI_CLOCKWISE;
        }
    }

    public void move() {
        Angle position = super.getPosition();
        double height = super.getHeight();
        double velocity = ((double)SPEED/height);
        Angle change = Angle.fromRadians(velocity);
        
        // If greater than specified range and lesser than threshold, positive direction
        if (direction == MathsHelper.ANTI_CLOCKWISE) {
            if (position.toDegrees() > 190 && position.toDegrees() < 345) {
                // subtract radian change
                minusSet(position, change);
                // switch direction
                direction = MathsHelper.CLOCKWISE;
            }
            else {
                // add radian change
                addSet(position, change);
            }
        }
        // negative direction within range
        else {
            if (position.toDegrees() < 140) {
                // add radian change
                addSet(position, change);
                // switch directions
                direction = MathsHelper.ANTI_CLOCKWISE;
            }
            else {
                // subtract radian change
                minusSet(position, change);
            }
        }
    }

    // helpers to add or remove radian change and use setter. 
    public void addSet(Angle position, Angle change) {
        Angle newPosition;
        newPosition = position.add(change);
        if (newPosition.toDegrees() > 360) {
            setPosition(Angle.fromDegrees(newPosition.toDegrees() - 360));
        }
        setPosition(newPosition);
    }

    public void minusSet(Angle position, Angle change) {
        Angle newPosition;
        newPosition = position.subtract(change);
        setPosition(newPosition);
    }
}
package unsw.blackout.classes.satellites;

import unsw.utils.Angle;
import unsw.utils.MathsHelper;

public class TeleportingSatellite extends Satellite {
    private int direction;
    private static final int RANGE = 200000;
    private static final int SPEED = 1000;
    public TeleportingSatellite(String satelliteId, double height, Angle position) {
        super(satelliteId, "TeleportingSatellite", height, position, RANGE, SPEED);
        direction = MathsHelper.ANTI_CLOCKWISE;
    }

    public void move() {
        // v = r * ω
        Angle position = super.getPosition();
        double height = super.getHeight();
        double velocity = ((double)SPEED/height);
        Angle change = Angle.fromRadians(velocity);
        // going in positive direction
        if (direction == MathsHelper.ANTI_CLOCKWISE) {
            Angle newPosition = position.add(change);
            if (newPosition.toDegrees() > 180) {
                // set position to 0 degrees since it teleports
                setPosition(Angle.fromDegrees(0));
                direction = MathsHelper.CLOCKWISE;
            }
            else {
                setPosition(newPosition);
            }
        }
        // going in negative direction
        else {
            Angle newPosition = position.subtract(change);
            if (newPosition.toDegrees() < 180) {
                // set position to 0 degrees since it teleports
                setPosition(Angle.fromDegrees(0));
                direction = MathsHelper.ANTI_CLOCKWISE;
            }
            else {
                setPosition(newPosition);
            }
        }
    }
}

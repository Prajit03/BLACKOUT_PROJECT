package unsw.blackout.classes.satellites;

// import javax.swing.text.Position;

import unsw.utils.Angle;
//import unsw.utils.MathsHelper;

public class StandardSatellite extends Satellite {
    private static final int RANGE = 150000;
    private static final int SPEED = 2500;
    public StandardSatellite(String satelliteId, double height, Angle position) {
        super(satelliteId, "StandardSatellite", height, position, RANGE, SPEED);
    }

    public void move() {
        // v = r * ω
        Angle position = super.getPosition();
        double height = super.getHeight();
        double velocity = ((double)SPEED/height);
        Angle change = Angle.fromRadians(velocity); 
        // Subtract angle as standard satellites move clockwise
        Angle newPosition = position.subtract(change);
        // Wrap around if position greater than 360 degrees
        if (newPosition.toDegrees() > 360) {
            newPosition = Angle.fromDegrees(newPosition.toDegrees() - 360);
            setPosition(newPosition);
        }
        // Wrap around if position lesser than 0 degrees
        else if (newPosition.toDegrees() < 0) {
            newPosition = Angle.fromDegrees(newPosition.toDegrees() + 360);
            setPosition(newPosition);
        }
        else {
            setPosition(newPosition);
        }
    }
}
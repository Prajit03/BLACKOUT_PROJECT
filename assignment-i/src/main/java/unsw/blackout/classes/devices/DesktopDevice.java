package unsw.blackout.classes.devices;

import unsw.utils.Angle;

public class DesktopDevice extends Device {
    public DesktopDevice(String deviceId, Angle position) {
        super(deviceId, "DesktopDevice", position, 200000);
    }
}

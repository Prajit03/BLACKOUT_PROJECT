package unsw.blackout.classes.devices;

import unsw.utils.Angle;

public class LaptopDevice extends Device {
    public LaptopDevice(String deviceId, Angle position) {
        super(deviceId, "LaptopDevice", position, 100000);
    }
}
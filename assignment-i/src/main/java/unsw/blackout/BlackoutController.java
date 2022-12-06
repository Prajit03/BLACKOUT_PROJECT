package unsw.blackout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import unsw.blackout.classes.File;
import unsw.blackout.classes.devices.*;
import unsw.blackout.classes.satellites.*;
import unsw.response.models.EntityInfoResponse;
import unsw.utils.Angle;

public class BlackoutController {
    private ArrayList<Device> allDevices = new ArrayList<Device>();
    private ArrayList<Satellite> allSatellites = new ArrayList<Satellite>();

    /**
     * Adds a device to the ring at the position specified, the position is measured
     * as an angle relative to the x-axis, rotating anticlockwise.
     * 
     * @param deviceId
     * @param type
     * @param position
     */

    public void createDevice(String deviceId, String type, Angle position) {
        Device device;
        if (type.equals("HandheldDevice")) {
            device = new HandheldDevice(deviceId, position);
        } else if (type.equals("LaptopDevice")) {
            device = new LaptopDevice(deviceId, position);
        } else {
            device = new DesktopDevice(deviceId, position);
        }
        allDevices.add(device);
    }

    /**
     * Removes a device (specified by id).
     * 
     * @param deviceId
     */
    public void removeDevice(String deviceId) {

        for (Iterator<Device> it = allDevices.iterator(); it.hasNext();) {
            Device device = it.next();
            if (device.getDeviceId().equals(deviceId)) {
                it.remove();
            }
        }
    }

    /**
     * Creates a satellite at a given height (measured from centre of Jupiter) at a
     * given angle.
     * 
     * @param satelliteId
     * @param type
     * @param height
     * @param position
     */
    public void createSatellite(String satelliteId, String type, double height, Angle position) {
        Satellite satellite;
        if (type.equals("StandardSatellite")) {
            satellite = new StandardSatellite(satelliteId, height, position);
        } else if (type.equals("TeleportingSatellite")) {
            satellite = new TeleportingSatellite(satelliteId, height, position);
        } else {
            satellite = new RelaySatellite(satelliteId, height, position);
        }
        allSatellites.add(satellite);
    }

    public void removeSatellite(String satelliteId) {
        for (Iterator<Satellite> it = allSatellites.iterator(); it.hasNext();) {
            Satellite satellite = it.next();
            if (satellite.getSatelliteId().equals(satelliteId)) {
                it.remove();
            }
        }
    }

    public List<String> listDeviceIds() {
        List<String> deviceIds = new ArrayList<>();
        for (Device device : allDevices) {
            deviceIds.add(device.getDeviceId());
        }
        return deviceIds;
    }

    public List<String> listSatelliteIds() {
        List<String> satelliteIds = new ArrayList<>();
        for (Satellite satellite : allSatellites) {
            satelliteIds.add(satellite.getSatelliteId());
        }
        return satelliteIds;
    }

    public void addFileToDevice(String deviceId, String filename, String content) {
        File file = new File(filename, content);
        for (Device device : allDevices) {
            if (device.getDeviceId().equals(deviceId)) {
                device.addFile(file);
            }
        }
    }

    public EntityInfoResponse getInfo(String id) {
        Device device = getDevice(id);
        if (device != null) {
            return new EntityInfoResponse(id, device.getPosition(), device.getHeight(), device.getType(), device.Map());
        }

        Satellite satellite = getSatellite(id);
        if (satellite != null) {
            return new EntityInfoResponse(id, satellite.getPosition(), satellite.getHeight(), satellite.getType());
        }
        return null;
    }

    /**
     * Retrieve device matching given id
     * 
     * @param id
     */
    public Device getDevice(String id) {
        for (Device device : allDevices) {
            if (device.getDeviceId().equals(id)) {
                return device;
            }
        }
        return null;
    }

    /**
     * Retrieve satellite matching given id
     * 
     * @param id
     */
    public Satellite getSatellite(String id) {
        for (Satellite satellite : allSatellites) {
            if (satellite.getSatelliteId().equals(id)) {
                return satellite;
            }
        }
        return null;
    }

    public void simulate() {
        for (Satellite satellite : allSatellites) {
            satellite.move();
        }
    }

    /**
     * Simulate for the specified number of minutes.
     * You shouldn't need to modify this function.
     */
    public void simulate(int numberOfMinutes) {
        for (int i = 0; i < numberOfMinutes; i++) {
            simulate();
        }
    }

    public List<String> communicableEntitiesInRange(String id) {
        // TODO: Task 2 b)
        return new ArrayList<>();
    }

    public void sendFile(String fileName, String fromId, String toId) throws FileTransferException {
        // TODO: Task 2 c)
    }

    public void createDevice(String deviceId, String type, Angle position, boolean isMoving) {
        createDevice(deviceId, type, position);
        // TODO: Task 3
    }

    public void createSlope(int startAngle, int endAngle, int gradient) {
        // TODO: Task 3
        // If you are not completing Task 3 you can leave this method blank :)
    }

}

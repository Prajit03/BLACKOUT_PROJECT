package unsw.blackout.classes.devices;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import unsw.blackout.classes.File;
import unsw.response.models.FileInfoResponse;
import unsw.utils.Angle;
import unsw.utils.MathsHelper;

public abstract class Device {
    private String deviceId;
    private String type;
    private Angle position;
    private double height;
    private int range;
    private List<File> allFiles = new ArrayList<File>();

    public Device(String deviceId, String type, Angle position, int range) {
        this.deviceId = deviceId;
        this.type = type;
        this.position = position;
        this.height = MathsHelper.RADIUS_OF_JUPITER;
        this.range = range;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getType() {
        return type;
    }

    public Angle getPosition() {
        return position;
    }

    public double getHeight() {
        return height;
    }

    public double getRange() {
        return range;
    }

    /**
     * Add a file to the device.
     * @param file
     */
    public void addFile(File file) {
        allFiles.add(file);
    }

    public Map<String, FileInfoResponse> Map() {
        Map<String, FileInfoResponse> fileMap = new HashMap<String, FileInfoResponse>();
        for (File file : allFiles) {
            fileMap.put(file.getFilename(), new FileInfoResponse(file.getFilename(), file.getContent(), 
                                                                 file.getSize(), true));
        }
        return fileMap;
    }



}

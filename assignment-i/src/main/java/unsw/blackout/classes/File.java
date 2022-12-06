package unsw.blackout.classes;

public class File {
    private String fileName;
    private String fileContent;
    private int fileSize;

     /**
      * File constructor - for files created to a device
      * @param fileName
      * @param fileContent
\     */
    public File(String fileName, String fileContent) {
        this.fileName = fileName;
        this.fileContent = fileContent;
        this.fileSize = fileContent.length();
    }

    /**
     * getter for file name.
     */
    public String getFilename() {
        return this.fileName;
    }

    /**
     * setter for file name.
     * @param filename
     */
    public void setFilename(String filename) {
        this.fileName = filename;
    }

    /**
     * getter for file content.
     */
    public String getContent() {
        return this.fileContent;
    }

    /**
     * setter for file content.
     * @param content
     */
    public void setContent(String content) {
        this.fileContent = content;
    }

    /**
     * getter for file size.
     */
    public int getSize() {
        return this.fileSize;
    }
}

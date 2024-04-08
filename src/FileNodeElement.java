/*
This class is only used for Lab 3.
This is a class that allows each node to contain the file name and file size.
 */

public class FileNodeElement {
    private String filename;
    private int filesize;

    public FileNodeElement(String filename, int filesize) {
        this.filename = filename;
        this.filesize = filesize;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getFilesize() {
        return filesize;
    }

    public void setFilesize(int filesize) {
        this.filesize = filesize;
    }
}

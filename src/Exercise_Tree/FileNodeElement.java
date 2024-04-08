package Exercise_Tree;/*
This class is only used for Lab 3.
This is a class that allows each node to contain the file name and file size.

 */

public class FileNodeElement extends MyNode {
    private String filename;
    private int filesize;

    public FileNodeElement(String filename, int filesize) {
        this.filename = filename;
        this.filesize = filesize;
    }

    public int getFilesize() {
        return filesize;
    }


    @Override
    public String toString() {
        return filename;
    }
}

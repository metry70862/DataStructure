import java.util.ArrayList;

public class MyNode {
    private Object element;
    private MyNode parent;
    private ArrayList children;

    // implement constructors
    MyNode() {
        element = null;
        parent = null;
        children = null;
    }

    MyNode(Object e) {
        element = e;
        parent = null;
        children = null;
    }

    // implement the following methods
    public Object element() {
        return this.element;
    }

    public MyNode parent() {
        return this.parent;
    }

    public ArrayList children() {
        return this.children;
    }

    public int degree() {
        return this.children.size();
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public void setParent(MyNode parent) {
        this.parent = parent;
    }

    public void setChildren(ArrayList children) {
        this.children = children;
    }
}
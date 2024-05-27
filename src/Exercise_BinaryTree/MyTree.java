package Exercise_BinaryTree;

import java.util.ArrayList;

public class MyTree {
    private MyNode root;
    private int size;

    // implement constructors
    MyTree() {
        root = null;
    }

    MyTree(Object e) {
        root = new MyBinNode(e);
        root.setChildren(new ArrayList());
        this.size = 1;
    }

    // implement the following methods
    public int size() {
        return size;
    }

    public MyNode root() {
        return root;
    }

    public ArrayList children(MyNode v) {
        return v.children();
    }

    public boolean isExternal(MyNode v) {
        return children(v).isEmpty();
    }


    public MyNode addRoot(Object e) {
        if(e instanceof MyBinNode){
            MyBinNode v = (MyBinNode)e;
            root = v;
            return (MyNode)root;
        }
        root = new MyNode(e);
        root.setChildren(new ArrayList());
        return root;

    }


    public MyNode addNode(Object e) {
        if (root == null) {
            return null;
        } else {
            MyNode newNode = new MyNode(e);
            newNode.setParent(this.root);
            this.root.children().add(newNode);
            size++;
            return newNode;
        }
    }

    public MyNode addChild(MyNode v, Object e) {
        if(e instanceof MyBinNode){
            ((MyBinNode) e).setParent(v);
            size++;
            v.children().add(e);
            return (MyNode) e;
        }else {
            MyNode newNode = new MyNode(e);
            newNode.setParent(v);
            size++;
            v.children().add(newNode);
            return newNode;
        }

    }

    public MyNode addChild(MyNode v, int i, Object e) {
        MyNode newNode = new MyNode(e);
        newNode.setParent(v);
        v.children().add(i, newNode);
        size++;
        return newNode;
    }

    public MyNode setChild(MyNode v, int i, Object e) {
        if (i >= 0 && i < v.children().size()) {
            MyNode newNode = new MyNode(e);
            newNode.setParent(v);
            v.children().set(i, newNode);
            return newNode;
        }
        return null; // Index out of bounds
    }

    public MyNode removeChild(MyNode v, int i) {
        if (i >= 0 && i < v.children().size()) {
            size--;
            return (MyNode) v.children().remove(i);
        }
        return null; // Index out of bounds
    }


}


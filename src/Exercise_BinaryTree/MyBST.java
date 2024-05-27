package Exercise_BinaryTree;

import java.util.ArrayList;

public class MyBST extends MyBinTree {
    //Constructor
    MyBST() {
        super();
    }

    MyBST(Object e) {
        super(e);
    }

    //Implement the following methods
    private MyBinNode nextNode(MyBinNode v) {
        if (v == null) return null;
        if (v.right() != null) {
            MyBinNode next = v.right();
            while (next.left() != null) {
                next = next.left();
            }
            return next;
        }
        MyBinNode parent = (MyBinNode) v.parent();
        MyBinNode current = v;
        while (parent != null && current == parent.right()) {
            current = parent;
            parent = (MyBinNode) parent.parent();
        }
        return parent;
    }

    public Object find(Object k) {
        MyBinNode v = this.root();
        while (v != null) {
            if ((int) v.element() == (int) k) {
                return v.element();
            } else if ((int) v.element() >= (int) k) {
                v = v.left();
            } else {
                v = v.right();
            }
        }
        return null;

    }

    public ArrayList findAll(Object k) {
        MyBinNode v = this.root();
        ArrayList<Integer> result = new ArrayList<>();
        while (v != null) {
            if ((int) v.element() == (int) k) {
                result.add((Integer) v.element());
            }
            if ((int) v.element() >= (int) k) {
                v = v.left();
            } else {
                v = v.right();
            }
        }
        return result;
    }

    public Object insert(Object k) {
        MyBinNode newNode = new MyBinNode(k);
        if (this.root() == null) {
            this.addRoot(newNode);
            return k;
        }

        MyBinNode parent = null;
        MyBinNode current = this.root();
        while (current != null) {
            parent = current;
            if ((int) k <= (int) current.element()) {
                current = current.left();
            } else {
                current = current.right();
            }
        }

        if ((int) k <= (int) parent.element()) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }
        newNode.setParent(parent);

        return k;
    }

        public Object remove(Object k) {
        MyBinNode nodeToRemove = this.root();
        while (nodeToRemove != null && (int) nodeToRemove.element() != (int) k) {
            if ((int) k < (int) nodeToRemove.element()) {
                nodeToRemove = nodeToRemove.left();
            } else {
                nodeToRemove = nodeToRemove.right();
            }
        }

        if (nodeToRemove == null) return null;

        // Node has two children
        if (nodeToRemove.left() != null && nodeToRemove.right() != null) {
            MyBinNode successor = nextNode(nodeToRemove);
            nodeToRemove.setElement(successor.element());
            nodeToRemove = successor; // Now remove the successor
        }

        // Node has one or zero children
        MyBinNode replacement = (nodeToRemove.left() != null) ? nodeToRemove.left() : nodeToRemove.right();
        if (replacement != null) {
            replacement.setParent((MyBinNode) nodeToRemove.parent());
            if (nodeToRemove.parent() == null) {
                this.addRoot(replacement);
            } else if (nodeToRemove == ((MyBinNode) nodeToRemove.parent()).left()) {
                ((MyBinNode) nodeToRemove.parent()).setLeft(replacement);
            } else {
                ((MyBinNode) nodeToRemove.parent()).setRight(replacement);
            }
            nodeToRemove.setLeft(null);
            nodeToRemove.setRight(null);
            nodeToRemove.setParent(null);
        } else if (nodeToRemove.parent() == null) { // Node is root and has no children
            this.addRoot(null);
        } else { // Node has no children
            if (nodeToRemove == nodeToRemove.parent().left()) {
                nodeToRemove.parent().setLeft(null);
            } else {
                nodeToRemove.parent().setRight(null);
            }
            nodeToRemove.setParent(null);
        }

        return k;
    }
    public void printTree() {
        printInOrder(this.root());
    }

    // inorderTraversal 알고리즘으로 전체 키 탐색
    private void printInOrder(MyBinNode node) {
        if (node != null) {
            printInOrder(node.left());
            System.out.print(node.element() + " ");
            printInOrder(node.right());
        }
    }
}

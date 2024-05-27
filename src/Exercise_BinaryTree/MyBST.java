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

    //1. 삭제하는 노드가 자식노드를 갖고 있지 않을때
    //2. 삭제하는 노드의 자식노드가 1개일때
    //3. 삭제하는 노드가 왼쪽, 오른쪽 자식을 모두 가지고 있을때
    public Object remove(Object k) {
        MyBinNode node = this.root();
        MyBinNode parent = null;

        while (node != null && (int) node.element() != (int) k) {
            parent = node;
            if ((int) node.element()>=(int) k) {
                node = node.left();
            } else {
                node = node.right();
            }
        }

        if (node == null) return null;

        // Case 1
        if (node.left() == null && node.right() == null) {
            if (node == this.root()) {
                return null;
            } else if (node == parent.left()) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        }
        // Case 2
        else if (node.left() == null || node.right() == null) {
            MyBinNode child;
            if (node.left() != null) {
                child = node.left();
            } else {
                child = node.right();
            }
            if (node == this.root()) {
                this.root = child;
            } else if (node == parent.left()) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
            child.setParent(parent);
        }
        // Case 3
        else {
            MyBinNode successor = nextNode(node);
            remove(successor.element());
            node.setElement(successor.element());

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

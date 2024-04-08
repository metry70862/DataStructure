package Exercise_BinaryTree;

public class MyBinTree extends MyTree {
    // constructors
    MyBinTree() {
        super();
    }

    MyBinTree(Object e) {
        super(e);
    }

    // implement the following methods
    public Boolean isEmpty() {
        return super.root() == null;
    }

    public boolean isRoot(MyBinNode v) {
        return v.equals(super.root());
    }

    public boolean isInternal(MyBinNode v) {
        return v.degree() != 0;
    }

    public boolean isExternal(MyBinNode v) {
        return v.degree() == 1;
    }

    public MyBinNode root() {
        return (MyBinNode) super.root();
    }

    public MyBinNode parent(MyBinNode v) {
        return (MyBinNode) v.parent();
    }

    public MyBinNode left(MyBinNode v) {
        return v.left();
    }

    public MyBinNode right(MyBinNode v) {
        return v.right();
    }

    public boolean hasLeft(MyBinNode v) {
        return v.left() != null;
    }

    public boolean hasRight(MyBinNode v) {
        return v.right() != null;
    }

    public MyBinNode addRoot(Object e) {
        MyBinNode newNode = new MyBinNode(e);
        super.addRoot(newNode);
        return newNode;
    }

    public MyBinNode addNode(Object e) {
        MyBinNode newNode = new MyBinNode(e);
        addChild(super.root(), newNode);
        return newNode;
    }

    public MyBinNode insertLeft(MyBinNode v, Object e) {
        MyBinNode newNode = new MyBinNode(e);
        v.setLeft(newNode);
        return newNode;
    }

    public MyBinNode insertRight(MyBinNode v, Object e) {
        MyBinNode newNode = new MyBinNode(e);
        v.setRight(newNode);
        return newNode;
    }

    public Object replace(MyBinNode v, Object e) {
        v.setElement(e);
        return v;
    }

    public MyBinNode remove(MyBinNode v) throws TwoChildrenException {
        if (v.degree() == 2) {
            throw new TwoChildrenException();
        }
        MyBinNode parent = parent(v);

        if (isExternal(v)) {
            if (parent.left() == v) {
                removeChild(parent, 0);
            } else if (parent.right() == v) {
                removeChild(parent, 1);
            }
        } else {
            MyBinNode child = left(v) != null ? left(v) : right(v); // Get the non-null child

            // Connect the child to v's parent
            if (parent != null) {
                if (parent.left() == v) {
                    parent.setLeft(child);
                } else {
                    parent.setRight(child);
                }
            }
            if (child != null) {
                child.setParent(parent); // Update child's parent reference
            }
        }
        // v를 삭제하고 반환
        return v;
    }

    public void attach(MyBinNode v, MyBinNode t1, MyBinNode t2) throws NotExternalException {
        if (isInternal(v)) {
            throw new NotExternalException();
        }
        if (t1 != null) {
            v.setLeft(t1);
            t1.setParent(v);
        }
        if (t2 != null) {
            v.setRight(t2);
            t2.setParent(v);
        }
    }
}

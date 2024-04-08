package Exercise_BinaryTree;

public class TwoChildrenException extends Exception{
    public TwoChildrenException(){
        super("Cannot remove a node with two children");
    }
}

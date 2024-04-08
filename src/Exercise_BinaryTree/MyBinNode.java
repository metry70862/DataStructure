package Exercise_BinaryTree;

public class MyBinNode extends MyNode {
    MyBinNode(){
        super();
    }

    MyBinNode(Object e){
        super(e);
    }

    public MyBinNode left(){
        return (MyBinNode) this.children().get(0);
    }
    public MyBinNode right(){
        return (MyBinNode) this.children().get(1);
    }
    public void setLeft(MyBinNode v){
        this.children().add(0, v);
    }
    public void setRight(MyBinNode v){
        this.children().add(1, v);
    }
}
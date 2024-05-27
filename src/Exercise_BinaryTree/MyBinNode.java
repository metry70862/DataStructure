package Exercise_BinaryTree;

public class MyBinNode extends MyNode {
    MyBinNode(){
        super();
        this.children().add(0,null);
        this.children().add(1,null);
    }

    MyBinNode(Object e){
        super(e);
        this.children().add(0,null);
        this.children().add(1,null);
    }

    public MyBinNode left() {
        if (this.children() != null && !this.children().isEmpty()) {
            return (MyBinNode) this.children().get(0);
        } else {
            return null;
        }
    }
    public MyBinNode right() {
        if (this.children() != null && this.children().size() > 1) {
            return (MyBinNode) this.children().get(1);
        } else {
            return null;
        }
    }

    public void setLeft(MyBinNode v){
        this.children().set(0, v);
    }
    public void setRight(MyBinNode v){
        if(this.children() != null && this.children().size() > 1){
            this.children().set(1, v);
        }

    }
}
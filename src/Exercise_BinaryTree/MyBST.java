package Exercise_BinaryTree;
import java.util.ArrayList;

public class MyBST extends MyBinTree{
    //Constructor
    MyBST(){
        super();
    }

    MyBST(Object e){
        super(e);
    }

    //Implement the following methods
//    private MyBinNode nextNode(MyBinNode v){
//
//    }
    public Object find(Object k) {
        MyBinNode v = this.root();
        while(v != null){
            if((int) v.element() == (int) k){
                return v.element();
            } else if((int) v.element() > (int) k){
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
        while(v != null){
            if((int) v.element() == (int) k){
                result.add((Integer) v.element());
            }
            if((int) v.element() > (int) k){
                v = v.left();
            } else {
                v = v.right();
            }
        }
        return result;
    }
//    public Object insert(Object k) {
//
//    }
//    public Object remove(Object k) {
//
//    }
}

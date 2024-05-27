package Exercise_BinaryTree;

public class MyBSTMain {

    public static void main(String[] args) {
        MyBST tree = new MyBST();
        //insert 기능이 정상적으로 작동하는지 알아보기 위해 무작위로 insert
        tree.insert(new Integer(6));
        tree.insert(new Integer(2));
        tree.insert(new Integer(9));
        tree.insert(new Integer(8));
        tree.insert(new Integer(9));
        tree.insert(new Integer(1));
        tree.insert(new Integer(4));


        System.out.println();
        System.out.println(tree.find(new Integer(8)));
        System.out.println(tree.find(new Integer(3)));

        System.out.println(tree.insert(new Integer(3)));
        System.out.println(tree.insert(new Integer(7)));
        System.out.println(tree.insert(new Integer(9)));
        //remove 구현

        System.out.println(tree.find(new Integer(3)));
        System.out.println(tree.find(new Integer(6)));
        System.out.println(tree.findAll(new Integer(9)));

        //MyBinTree 내부에 inorder 메소드가 없어, 모든 키값 출력하는 메소드를 MyBST 클래스 내부에 만듦
        tree.printTree();

    }
}

package Exercise_BinaryTree;
public class BinTreeExercise1 {
    public static void main(String[] args) {
        MyBinTree myBinTree = new MyBinTree("+");

        MyBinNode node1 = myBinTree.addNode("*");
        MyBinNode node2 = myBinTree.addNode("*");

        //Level 2 Nodes
        MyBinNode node3 = myBinTree.insertLeft(node1, "2");
        MyBinNode node4 = myBinTree.insertRight(node1, "-");


        MyBinNode node5 = myBinTree.insertLeft(node2, "3");
        MyBinNode node6 = myBinTree.insertRight(node2, "2");

        MyBinNode node7 = myBinTree.insertLeft(node4, "3");
        MyBinNode node8 = myBinTree.insertRight(node4, "1");
        //Level 3 Nodes

        System.out.println();
    }
}
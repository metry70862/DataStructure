package Exercise_BinaryTree;

public class BinTreeExercise1 {
    public static void main(String[] args) {
        MyBinTree myBinTree = new MyBinTree("+");

        //Level 1 Nodes
        MyBinNode node1 = myBinTree.addNode("*");
        MyBinNode node2 = myBinTree.addNode("*");

        //Level 2 Nodes
        MyBinNode node3 = myBinTree.insertLeft(node1, "2");
        MyBinNode node4 = myBinTree.insertRight(node1, "-");


        MyBinNode node5 = myBinTree.insertLeft(node2, "3");
        MyBinNode node6 = myBinTree.insertRight(node2, "2");

        //Level 3 Nodes
        MyBinNode node7 = myBinTree.insertLeft(node4, "3");
        MyBinNode node8 = myBinTree.insertRight(node4, "1");



        System.out.println();
        System.out.println("Inorder Traverse:");
        InorderTraverse(myBinTree.root());
        System.out.println();
        System.out.println("Postorder Traverse:");
        System.out.println(calculateExpression(myBinTree.root()));
    }

    public static void InorderTraverse(MyBinNode node) {
        if (node != null) {
            if (node.left() != null || node.right() != null) {
                System.out.print("(");
            }
            InorderTraverse(node.left());
            System.out.print(node.element());
            InorderTraverse(node.right());
            if (node.left() != null || node.right() != null) {
                System.out.print(")");
            }
        }
    }

    public static int calculateExpression(MyBinNode node) {
        if (node == null) {
            return 0;
        }

        int leftValue = calculateExpression(node.left());
        int rightValue = calculateExpression(node.right());
        String element = (String) node.element();

        return switch (element) {
            case "+" -> leftValue + rightValue;
            case "-" -> leftValue - rightValue;
            case "*" -> leftValue * rightValue;
            case "/" -> leftValue / rightValue;
            default -> Integer.parseInt(element);
        };
    }
}
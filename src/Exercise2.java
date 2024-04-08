public class Exercise2 {
    public static void main(String[] args) {
        MyTree tree = new MyTree("Make Money Fast");

        //Level 1 Nodes
        MyNode motivations = tree.addNode("1.Motivations");
        MyNode methods = tree.addNode("2.Methods");
        MyNode references = tree.addNode("3.References");

        //Level 2 Nodes
        MyNode greed = tree.addChild(motivations, "1.1Greed");
        MyNode avidity = tree.addChild(motivations, "1.2Avidity");

        MyNode stockFraud = tree.addChild(methods, "2.1Stock Fraud");
        MyNode PonziScheme = tree.addChild(methods, "2.2PonziScheme");
        MyNode bankRobbery = tree.addChild(methods, "2.3BankRobbery");

        // Preorder traversal
        System.out.println("Preorder traversal:");
        preOrder(tree.root(), 0);
    }
    public static void preOrder(MyNode node, int depth) {
        if (node != null) {
            for (int i = 0; i < depth; i++) {
                System.out.print("  ");
            }
            System.out.println(node.element());
            for (Object child : node.children()) {
                preOrder((MyNode) child, depth + 1); //depth를 1씩 증가시켜 indentation 구현
            }
        }
    }
}

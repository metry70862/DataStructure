package Exercise_Tree;

public class Exercise3 {
    public static void main(String[] args) {
        MyTree tree = new MyTree(new FileNodeElement("cs16/", 0));


        //Level 1 Nodes
        MyNode homeworks = tree.addNode(new FileNodeElement("homeworks/", 0));
        MyNode programs = tree.addNode(new FileNodeElement("programs/", 0));
        MyNode todo = tree.addNode(new FileNodeElement("todo.txt", 1));

        //Level 2 Nodes
        MyNode h1c = tree.addChild(homeworks, new FileNodeElement("h1c.doc", 3));
        MyNode h1nc = tree.addChild(homeworks, new FileNodeElement("h1nc.doc", 2));

        MyNode ddr = tree.addChild(programs, new FileNodeElement("DDR.java", 10));
        MyNode stock = tree.addChild(programs, new FileNodeElement("Stock.java", 25));
        MyNode robot = tree.addChild(programs, new FileNodeElement("Robot.java", 20));

        System.out.println("Postorder traversal:");
        postOrder(tree.root());

    }


    public static void postOrder(MyNode node) {
        if (node != null) {
            for (Object obj : node.children()) {
                MyNode child = (MyNode) obj;
                postOrder(child);
            }
            // Check if the node is a directory and print its size sum
            if (node.element().toString().endsWith("/")) {
                int sizeSum = sumFileSize(node);
                System.out.println(node.element() + " = " + sizeSum + "KB");
            }
        }
    }

    // Method to sum file sizes under a directory node
    public static int sumFileSize(MyNode directory) {
        int sum = 0;
        for (Object obj : directory.children()) {
            MyNode child = (MyNode) obj;
            if (!child.element().toString().endsWith("/")) {
                FileNodeElement fileNode = (FileNodeElement) child.element();
                sum += fileNode.getFilesize();
            } else {
                // If it is a directory, add up the size recursively
                sum += sumFileSize(child);
            }
        }
        return sum;
    }


}
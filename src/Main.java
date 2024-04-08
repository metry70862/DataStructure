public class Main {
    public static void main(String[] args) {
        MyTree tree = new MyTree(new FileNodeElement("cs16/", 0));

        //Level 1 Nodes
        MyNode homeworks = tree.addNode(new FileNodeElement("homeworks/", 0));
        MyNode programs = tree.addNode(new FileNodeElement("programs/", 0));
        MyNode todo = tree.addNode(new FileNodeElement("todo.txt", 1));

        //Level 2 Nodes
        MyNode h1c = tree.addChild(homeworks,new FileNodeElement("h1c.doc", 3));
        MyNode h1nc = tree.addChild(homeworks, new FileNodeElement("h1nc.doc", 2));

        MyNode ddr = tree.addChild(programs, new FileNodeElement("DDR.java", 10));
        MyNode stock = tree.addChild(programs, new FileNodeElement("Stock.java", 25));
        MyNode robot = tree.addChild(programs, new FileNodeElement("Robot.java", 20));
    }
}
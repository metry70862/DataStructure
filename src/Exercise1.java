public class Exercise1 {
    public static void main(String[] args) {

        MyTree tree = new MyTree("Computers’R Us");
        System.out.println("[Level"+depth(tree.root())+"]");
        System.out.println(tree.root().element());
        System.out.println();
        //Level 1 Nodes
        MyNode sales = tree.addNode("Sales");
        MyNode manufacturing = tree.addNode("Manufacturing");
        MyNode rAndD = tree.addNode("R&D");
        System.out.println("[Level"+depth(sales)+"]");
        System.out.println(sales.element());
        System.out.println(manufacturing.element());
        System.out.println(rAndD.element());
        System.out.println();
        //Level 2 Nodes
        MyNode us = tree.addChild(sales, "us");
        MyNode international = tree.addChild(sales, "International");
        System.out.println("[Level"+depth(us)+"]");
        System.out.println(us.element());
        System.out.println(international.element());
        MyNode laptops = tree.addChild(manufacturing, "Laptops");
        MyNode desktops = tree.addChild(manufacturing, "Desktops");
        System.out.println(laptops.element());
        System.out.println(desktops.element());
        System.out.println();
        MyNode europe = tree.addChild(international, "Europe");
        MyNode asia = tree.addChild(international, "Asia");
        MyNode canada = tree.addChild(international, "Canada");
        System.out.println("[Level"+depth(europe)+"]");
        System.out.println(europe.element());
        System.out.println(asia.element());
        System.out.println(canada.element());
        System.out.println();
        System.out.println("* Tree size = Total " + tree.size() + " Nodes");
    }

    public static int depth(MyNode v) {
        if (v.parent() == null) {
            return 0;
        } else {
            return 1 + depth(v.parent());
        }
    } //Find node's level
}

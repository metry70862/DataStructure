public class Main {
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
    }
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Node node1 = new Node("Node1", new NodeState("Node1", true, System.currentTimeMillis()));
        Node node2 = new Node("Node2", new NodeState("Node2", true, System.currentTimeMillis()));
        Node node3 = new Node("Node3", new NodeState("Node3", true, System.currentTimeMillis()));
        Node node4 = new Node("Node4", new NodeState("Node4", true, System.currentTimeMillis()));

        // Add peers to each node
        node1.addPeer(node2);
        node1.addPeer(node3);
        node2.addPeer(node1);
        node2.addPeer(node4);
        node3.addPeer(node1);
        node3.addPeer(node4);
        node4.addPeer(node2);
        node4.addPeer(node3);

        // Start gossiping in parallel for each node
        node1.startGossiping();
        node2.startGossiping();
        node3.startGossiping();
        node4.startGossiping();

        // Allow gossiping to occur for a few seconds
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Print final state of all nodes
        System.out.println("\nFinal Node States:");
        System.out.println(node1);
        System.out.println(node2);
        System.out.println(node3);
        System.out.println(node4);
    }
}
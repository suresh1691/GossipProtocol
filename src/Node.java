import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Node {
    String nodeId;
    NodeState state;
    List<Node> peers;  // List of other nodes to gossip with

    // Constructor
    public Node(String nodeId, NodeState state) {
        this.nodeId = nodeId;
        this.state = state;
        this.peers = new ArrayList<>();
    }

    // Method to update the node state
    public void updateState(NodeState newState) {
        this.state = newState;
    }
    public void addPeer(Node peer) {
        peers.add(peer);
    }
    // Method to gossip with a random peer
    public void gossip() {
        Node peer = peers.get(new Random().nextInt(peers.size())); // Pick random peer
        peer.receiveState(this.state);  // Send this node's state to the peer
    }

    // Method to receive state from another node
    public void receiveState(NodeState receivedState) {
        if (receivedState.getTimestamp() > this.state.getTimestamp()) {
            updateState(receivedState);  // Update state if received state is more recent
        }
    }

    public void startGossiping() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(() -> gossip(), 0, 2, TimeUnit.SECONDS);
    }
}

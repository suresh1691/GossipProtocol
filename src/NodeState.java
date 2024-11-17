public class NodeState {
    private String nodeId;

    public NodeState(String nodeId, boolean isAlive, long timestamp) {
        this.nodeId = nodeId;
        this.isAlive = isAlive;
        this.timestamp = timestamp;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    private boolean isAlive;
    private long timestamp;
}

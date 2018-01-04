package practices.heartbeat;

import java.util.HashMap;
import java.util.Map;

/**
 * The Obj that server returns when receive the heart beat package.
 */
public class Cmder {

    private String nodeID;

    private String error;

    private Map<String, Object> info = new HashMap<String, Object>();

    public String getNodeID() {
        return nodeID;
    }

    public void setNodeID(String nodeID) {
        this.nodeID = nodeID;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }
}

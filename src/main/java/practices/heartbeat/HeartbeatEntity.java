package practices.heartbeat;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * The entity of the heart beat.
 */
public class HeartbeatEntity implements Serializable {

    private static final long serialVersionUID = -6942833751049716420L;

    private long time;

    private String nodeID;

    private String error;

    private Map<String, Object> info = new HashMap<String, Object>();

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

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

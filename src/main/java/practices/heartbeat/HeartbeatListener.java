package practices.heartbeat;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HeartbeatListener {

    private ExecutorService executor = Executors.newFixedThreadPool(20);

    private final ConcurrentHashMap<String, Object> nodes = new ConcurrentHashMap<>();

    private final ConcurrentHashMap<String, Long> nodeStatus = new ConcurrentHashMap<>();

    private long timeout = 10 * 1000;

    private int prot = 8089;

    /**
     * singleton pattern.
     */
    private static class SingletonHolder {
        private static final HeartbeatListener INSTANCE = new HeartbeatListener();
    }

    private HeartbeatListener() {
    }

    public static HeartbeatListener getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public ConcurrentHashMap<String, Object> getNodes() {
        return nodes;
    }

    public void registerNode(String nodeId, Object nodeInfo) {
        nodes.put(nodeId, nodeInfo);
        nodeStatus.put(nodeId, System.currentTimeMillis());

    }

    public void removeNode(String nodeId) {
        if (nodes.containsKey(nodeId)) nodes.remove(nodeId);
    }

    public boolean checkNodeValid(String key) {
        if (!nodes.containsKey(key) || !nodeStatus.containsKey(key)) return false;
        if ((System.currentTimeMillis() - nodeStatus.get(key)) > timeout) return false;
        return true;
    }

    public void removeInValidNode() {
        Iterator<Map.Entry<String, Long>> it = nodeStatus.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Long> e = it.next();
            if ((System.currentTimeMillis() - nodeStatus.get(e.getKey())) > timeout) {
                nodes.remove(e.getKey());
            }
        }
    }


}

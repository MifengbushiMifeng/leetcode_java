package practices.heartbeat;

import java.util.Map;

public class HeartbeatHandlerImpl implements HeartbeatHandler {


    @Override
    public Cmder sendHeartBeat(HeartbeatEntity info) {
        HeartbeatListener listener = HeartbeatListener.getInstance();

        if (!listener.checkNodeValid(info.getNodeID())) {
            listener.registerNode(info.getNodeID(), info);
        }
        Cmder cmder = new Cmder();
        cmder.setNodeID(info.getNodeID());
        // ...

        System.out.println("current all the nodes: ");
        Map<String, Object> nodes = listener.getNodes();
        for (Map.Entry e : nodes.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
        System.out.println("hadle a heartbeat");
        return cmder;
    }
}

package practices.heartbeat;

import practices.heartbeat.rpc.client.RPClient;

import java.net.InetSocketAddress;
import java.util.UUID;

public class HeartbeatClient implements Runnable {

    private String serverIP = "127.0.0.1";

    private int serverPort = 8089;

    private String nodeID = UUID.randomUUID().toString();

    private boolean isRunning = true;

    private long lastHeartBeat;

    private long heartBeatInterval = 10 * 1000;

    @Override
    public void run() {
        try {
            while (isRunning) {
                HeartbeatHandler handler = RPClient.getRemoteProxyObj(HeartbeatHandler.class,
                        new InetSocketAddress(serverIP, serverPort));

                long startTime = System.currentTimeMillis();
                // whether it's time to heart beat
                if (startTime - lastHeartBeat > heartBeatInterval) {
                    System.out.println("send a heart beat!");

                    lastHeartBeat = startTime;

                    HeartbeatEntity entity = new HeartbeatEntity();
                    entity.setTime(startTime);
                    entity.setNodeID(nodeID);

                    // send heart beat to server
                    Cmder cmds = handler.sendHeartBeat(entity);

                    if (!processCommand(cmds)) {
                        continue;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean processCommand(Cmder cmds) {
        return true;
    }
}

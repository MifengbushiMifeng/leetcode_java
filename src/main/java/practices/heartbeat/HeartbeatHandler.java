package practices.heartbeat;

/**
 * The interface of the heart beat handler.
 */
public interface HeartbeatHandler {

    public Cmder sendHeartBeat(HeartbeatEntity info);
}

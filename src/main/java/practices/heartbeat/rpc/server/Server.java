package practices.heartbeat.rpc.server;

import java.io.IOException;

/**
 * RPC server.
 */
public interface Server {

    public void stop();

    public void start() throws IOException;

    public void register(Class serverInterface, Class impl);

    public boolean isRunning();

    public int getPort();
}

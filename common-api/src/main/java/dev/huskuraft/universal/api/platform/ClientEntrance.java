package dev.huskuraft.universal.api.platform;

import dev.huskuraft.universal.api.events.impl.ClientEventRegistry;

public interface ClientEntrance extends Entrance {

    static ClientEntrance getInstance() {
        return PlatformLoader.getSingleton();
    }

    ClientManager getClientManager();

    ClientEventRegistry getEventRegistry();

    default Client getClient() {
        return getClientManager().getRunningClient();
    }

    @Override
    default ServerManager getServerManager() {
        throw new UnsupportedOperationException();
    }

}


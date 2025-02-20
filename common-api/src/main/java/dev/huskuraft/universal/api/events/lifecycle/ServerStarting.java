package dev.huskuraft.universal.api.events.lifecycle;

import dev.huskuraft.universal.api.platform.Server;

@FunctionalInterface
public interface ServerStarting {
    void onServerStarting(Server server);
}

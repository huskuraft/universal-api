package dev.huskuraft.universal.vanilla.core;

import dev.huskuraft.universal.api.core.PlayerProfile;
import dev.huskuraft.universal.api.platform.PlayerList;
import dev.huskuraft.universal.api.platform.Server;

public record MinecraftServer(
        net.minecraft.server.MinecraftServer refs
) implements Server {

    @Override
    public PlayerList getPlayerList() {
        return new MinecraftPlayerList(refs.getPlayerList());
    }

    @Override
    public void execute(Runnable runnable) {
        refs.execute(runnable);
    }

    @Override
    public boolean isSinglePlayerOwner(PlayerProfile profile) {
        return refs.isSingleplayerOwner(profile.reference());
    }

    @Override
    public boolean isDedicatedServer() {
        return refs.isDedicatedServer();
    }

}

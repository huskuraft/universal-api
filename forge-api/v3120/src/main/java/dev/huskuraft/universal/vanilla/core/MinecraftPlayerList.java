package dev.huskuraft.universal.vanilla.core;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import dev.huskuraft.universal.api.core.Player;
import dev.huskuraft.universal.api.core.PlayerProfile;
import dev.huskuraft.universal.api.platform.PlayerList;

public record MinecraftPlayerList(
        net.minecraft.server.players.PlayerList refs
) implements PlayerList {

    @Override
    public List<Player> getPlayers() {
        return refs.getPlayers().stream().map(MinecraftPlayer::ofNullable).collect(Collectors.toList());
    }

    @Override
    public Player getPlayer(UUID uuid) {
        return MinecraftPlayer.ofNullable(refs.getPlayer(uuid));
    }

    @Override
    public boolean isOperator(PlayerProfile profile) {
        return refs.isOp(profile.reference());
    }

}

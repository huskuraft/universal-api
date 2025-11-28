package dev.huskuraft.universal.vanilla.plugin.openpac;

import dev.huskuraft.universal.api.plugin.openpac.OpenPacChunkClaim;
import xaero.pac.common.claims.player.api.IPlayerChunkClaimAPI;

import javax.annotation.Nonnull;

import java.util.UUID;

public record OpenPacChunkClaimImpl(IPlayerChunkClaimAPI refs) implements OpenPacChunkClaim {

    public static OpenPacChunkClaim ofNullable(IPlayerChunkClaimAPI refs) {
        if (refs == null) return null;
        return new OpenPacChunkClaimImpl(refs);
    }

    @Override
    public @Nonnull UUID getPlayerId() {
        return refs.getPlayerId();
    }

}

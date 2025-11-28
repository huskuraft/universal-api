package dev.huskuraft.universal.vanilla.plugin.ftbchunks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import dev.ftb.mods.ftbchunks.api.ClaimedChunkManager;
import dev.ftb.mods.ftblibrary.math.ChunkDimPos;
import dev.huskuraft.universal.api.core.BlockPosition;
import dev.huskuraft.universal.api.core.World;
import dev.huskuraft.universal.api.plugin.ftbchunks.FtbChunkClaimsManager;
import dev.huskuraft.universal.api.plugin.ftbchunks.FtbClaimedChunk;
import dev.huskuraft.universal.vanilla.core.MinecraftConvertor;

public record FtbChunkClaimsManagerImpl(ClaimedChunkManager refs) implements FtbChunkClaimsManager {

    public static FtbChunkClaimsManager ofNullable(ClaimedChunkManager refs) {
        if (refs == null) return null;
        return new FtbChunkClaimsManagerImpl(refs);
    }

    @Override
    public @Nullable FtbClaimedChunk get(@Nonnull World world, @Nonnull BlockPosition blockPosition) {
        var chunk = refs.getChunk(new ChunkDimPos(world.reference(), MinecraftConvertor.toPlatformBlockPosition(blockPosition)));
        return FtbClaimedChunkImpl.ofNullable(chunk);
    }


}

package xaero.pac.common.claims.api;

import java.util.UUID;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ChunkPos;
import xaero.pac.common.claims.player.api.IPlayerChunkClaimAPI;
import xaero.pac.common.claims.player.api.IPlayerClaimInfoAPI;
import xaero.pac.common.claims.tracker.api.IClaimsManagerTrackerAPI;

/**
 * API for a claims manager
 */
public interface IClaimsManagerAPI {

    /**
     * Checks whether a player has claim info.
     *
     * @param playerId UUID of the player, not null
     * @return true if the player with UUID {@code playerId} has claims info, otherwise false
     */
    boolean hasPlayerInfo(@Nonnull UUID playerId);

    /**
     * Gets or creates the claim info instance for a player UUID.
     *
     * @param playerId UUID of a player, not null
     * @return the player claim info, not null
     */
    @Nonnull
    IPlayerClaimInfoAPI getPlayerInfo(@Nonnull UUID playerId);

    /**
     * Gets the claim state for a specified chunk.
     *
     * @param dimension the dimension ID of the chunk, not null
     * @param x         the X coordinate of the chunk
     * @param z         the Z coordinate of the chunk
     * @return the current claim state at the specified location, null if wilderness
     */
    @Nullable
    IPlayerChunkClaimAPI get(@Nonnull ResourceLocation dimension, int x, int z);

    /**
     * Gets the claim state for a specified chunk.
     *
     * @param dimension the dimension ID of the chunk, not null
     * @param chunkPos  the coordinates of the chunk, not null
     * @return the current claim state at the specified location, null if wilderness
     */
    @Nullable
    IPlayerChunkClaimAPI get(@Nonnull ResourceLocation dimension, @Nonnull ChunkPos chunkPos);

    /**
     * Gets the claim state for a specified chunk.
     *
     * @param dimension the dimension ID of the chunk, not null
     * @param blockPos  the block coordinates of the chunk, not null
     * @return the current claim state at the specified location, null if wilderness
     */
    @Nullable
    IPlayerChunkClaimAPI get(@Nonnull ResourceLocation dimension, @Nonnull BlockPos blockPos);

    /**
     * Gets the read-only claims manager for a specified dimension ID.
     *
     * @param dimension the dimension ID, not null
     * @return the dimension claims manager, null if no claim data exists for the specified dimension
     */
    @Nullable
    IDimensionClaimsManagerAPI getDimension(@Nonnull ResourceLocation dimension);

    /**
     * Gets the claim change tracker that lets you register claim change listeners.
     * <p>
     * The tracker notifies the registered listeners when claim changes occur.
     *
     * @return the claim change tracker
     */
    @Nonnull
    IClaimsManagerTrackerAPI getTracker();

}

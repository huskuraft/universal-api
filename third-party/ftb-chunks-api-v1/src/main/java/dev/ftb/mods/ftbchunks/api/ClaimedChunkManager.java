package dev.ftb.mods.ftbchunks.api;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.function.Predicate;

import dev.ftb.mods.ftblibrary.math.ChunkDimPos;
import dev.ftb.mods.ftbteams.api.Team;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Top-level manager for all known claims and teams. You can get an instance of this via
 * {FTBChunksAPI.API#getManager()}.
 */
public interface ClaimedChunkManager {
    /**
     * Get the FTB Chunks team data for the given team, creating a new instance if necessary.
     *
     * @param team the team
     * @return the FTB Chunks data for the team
     */
    ChunkTeamData getOrCreateData(@Nonnull Team team);

    /**
     * Get the FTB Chunks team data for the given player, creating a new instance if necessary. This will get the
     * data for the party team the player is in, if applicable.
     * <p>
     * This should not normally return null, but it is a possibility if external problems cause the player to be
     * disconnected before they are assigned an FTB Team. So the return value should be checked.
     *
     * @param player the player
     * @return the FTB Chunks data for the team, or null if something went wrong
     */
    ChunkTeamData getOrCreateData(ServerPlayer player);

    /**
     * Get the FTB Chunks team data for the given player ID, creating a new instance if necessary. This will always
     * for the player's personal team, even if they are currently in a party team.
     *
     * @param id a player UUID
     * @return the FTB Chunks data for the player, or null if something went wrong
     */
    ChunkTeamData getPersonalData(UUID id);

    /**
     * Get the claimed chunk data for the chunk at the given position.
     *
     * @param pos the dimension and chunk pos
     * @return the claim chunk data, or null if the chunk is not currently claimed
     */
    @Nullable
    ClaimedChunk getChunk(ChunkDimPos pos);

    /**
     * Get an unmodifiable view of all claimed chunks on this server.
     *
     * @return all claimed chunks
     */
    Collection<? extends ClaimedChunk> getAllClaimedChunks();

    /**
     * Get an unmodifiable view of all claimed chunks, grouped by team ID.
     *
     * @param predicate a predicate to filter chunks from the returned data
     * @return a map of team ID to collection of claimed chunks
     */
    Map<UUID, Collection<ClaimedChunk>> getClaimedChunksByTeam(Predicate<ClaimedChunk> predicate);

    /**
     * Return true if the given player has special permission to bypass all chunk protections. By default, no
     * player has this permission, even server ops (but server ops may give themselves this permission via the
     * {@code /ftbchunks admin bypass_protection} command).
     *
     * @param player the player being checked
     * @return true if the player can bypass protection checking
     */
    boolean getBypassProtection(UUID player);

    /**
     * Set the protection bypass flag for the given player. See {#getBypassProtection(UUID)} for more
     * information.
     *
     * @param player the player to adjust
     * @param bypass true if the player should be able to bypass all protection, false otherwise
     */
    void setBypassProtection(UUID player, boolean bypass);

    /**
     * Check if the intended interaction should be prevented from occurring.
     *
     * @param actor        the entity performing the interaction, should be a player
     * @param hand         the actor's hand
     * @param pos          the block position at which the action will be performed
     * @param protection   the type of protection being checked for
     * @param targetEntity the entity being acted upon, if any (e.g. a painting, armor stand etc.)
     * @return true to prevent the interaction, false to permit it
     * @implNote null may be passed as the acting entity, but this method will always return false if the actor does
     * not extend {@code ServerPlayer} (fake players are OK as long as this the case)
     */
    boolean shouldPreventInteraction(@Nullable Entity actor, InteractionHand hand, BlockPos pos, Protection protection, @Nullable Entity targetEntity);

    /**
     * Get an unmodifiable view of all currently force-loaded chunks, grouped by dimension. The key of the returned
     * map is a long encoding of the chunk position; you can obtain the chunk pos via {@code new ChunkPos(long pos)}.
     * The value of the map items is the UUID of the owning {Team}.
     *
     * @return a map of dimension to map of all force-loaded chunks, mapping long-encoded chunk pos to team ID
     */
    Map<ResourceKey<Level>, Long2ObjectMap<UUID>> getForceLoadedChunks();

    /**
     * Get an unmodifiable view of the force loaded chunks for the given dimension. The keys and values of the returned
     * map as the same as for {#getForceLoadedChunks()}.
     *
     * @param dimension the dimension to check
     * @return a map of all force-loaded chunks, mapping long-encoded chunk pos to team ID
     */
    @Nonnull Long2ObjectMap<UUID> getForceLoadedChunks(ResourceKey<Level> dimension);

    /**
     * Check if the given chunk (dimension and chunk pos) is currently force-loaded.
     *
     * @param chunkDimPos the chunk dimension and position
     * @return true if the chunk is force-loaded
     */
    boolean isChunkForceLoaded(ChunkDimPos chunkDimPos);
}

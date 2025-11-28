package dev.huskuraft.universal.vanilla.plugin.ftbchunks;

import java.util.Objects;

import com.google.auto.service.AutoService;

import dev.ftb.mods.ftbchunks.api.ClaimedChunk;
import dev.ftb.mods.ftbchunks.api.ClaimedChunkManager;
import dev.ftb.mods.ftbchunks.api.FTBChunksAPI;
import dev.huskuraft.universal.api.plugin.ftbchunks.FtbChunkClaimsManager;
import dev.huskuraft.universal.api.plugin.ftbchunks.FtbChunksPlugin;

@AutoService(FtbChunksPlugin.class)
public class FtbChunksPluginImpl implements FtbChunksPlugin {

    static  {
        Objects.requireNonNull(FTBChunksAPI.api());
        Objects.requireNonNull(ClaimedChunkManager.class);
        Objects.requireNonNull(ClaimedChunk.class);
    }

    @Override
    public String getId() {
        return FTBChunksAPI.MOD_ID;
    }

    @Override
    public void init() {
    }

    @Override
    public FtbChunkClaimsManager getClaimManager() {
        return FtbChunkClaimsManagerImpl.ofNullable(FTBChunksAPI.api().getManager());
    }

}

package dev.huskuraft.universal.vanilla.plugin.ftbchunks;

import com.google.auto.service.AutoService;

import dev.ftb.mods.ftbchunks.FTBChunks;
import dev.ftb.mods.ftbchunks.data.ClaimedChunk;
import dev.ftb.mods.ftbchunks.data.ClaimedChunkManager;
import dev.ftb.mods.ftbchunks.data.FTBChunksAPI;
import dev.huskuraft.universal.api.plugin.ftbchunks.FtbChunkClaimsManager;
import dev.huskuraft.universal.api.plugin.ftbchunks.FtbChunksPlugin;

import java.util.Objects;

@AutoService(FtbChunksPlugin.class)
public class FtbChunksPluginImpl implements FtbChunksPlugin {

    static  {
        Objects.requireNonNull(FTBChunksAPI.class);
        Objects.requireNonNull(ClaimedChunkManager.class);
        Objects.requireNonNull(ClaimedChunk.class);
    }

    @Override
    public String getId() {
        return FTBChunks.MOD_ID;
    }

    @Override
    public void init() {
    }

    @Override
    public FtbChunkClaimsManager getClaimManager() {
        return FtbChunkClaimsManagerImpl.ofNullable(FTBChunksAPI.getManager());
    }

}

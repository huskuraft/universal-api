package dev.huskuraft.universal.neoforge.platform;

import dev.huskuraft.universal.api.platform.Mod;
import net.neoforged.fml.loading.moddiscovery.ModInfo;

record NeoForgeMod(ModInfo modInfo) implements Mod {

    @Override
    public String getId() {
        return modInfo().getModId();
    }

    @Override
    public String getVersionStr() {
        return modInfo().getVersion().toString();
    }

    @Override
    public String getDescription() {
        return modInfo().getDescription();
    }

    @Override
    public String getName() {
        return modInfo().getDisplayName();
    }

}

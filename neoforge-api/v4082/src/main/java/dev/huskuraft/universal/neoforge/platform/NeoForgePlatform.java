package dev.huskuraft.universal.neoforge.platform;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import com.google.auto.service.AutoService;

import dev.huskuraft.universal.api.platform.Environment;
import dev.huskuraft.universal.api.platform.LoaderType;
import dev.huskuraft.universal.api.platform.Mod;
import dev.huskuraft.universal.api.platform.Platform;
import net.neoforged.fml.loading.FMLLoader;

@AutoService(Platform.class)
public class NeoForgePlatform implements Platform {

    @Override
    public LoaderType getLoaderType() {
        return LoaderType.NEO_FORGE;
    }

    @Override
    public String getLoaderVersion() {
        return FMLLoader.versionInfo().neoForgeVersion();
    }

    @Override
    public String getGameVersion() {
        return FMLLoader.versionInfo().mcVersion();
    }

    @Override
    public List<Mod> getRunningMods() {
        return FMLLoader.getLoadingModList().getMods().stream().map(NeoForgeMod::new).collect(Collectors.toList());
    }

    @Override
    public Path getGameDir() {
        return FMLLoader.getGamePath();
    }

    @Override
    public Environment getEnvironment() {
        return switch (FMLLoader.getDist()) {
            case CLIENT -> Environment.CLIENT;
            case DEDICATED_SERVER -> Environment.SERVER;
        };
    }

    @Override
    public boolean isDevelopment() {
        return !FMLLoader.isProduction();
    }


}

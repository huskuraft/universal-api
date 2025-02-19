package dev.huskuraft.universal.quilt.platform;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import org.quiltmc.loader.api.QuiltLoader;

import com.google.auto.service.AutoService;

import dev.huskuraft.universal.api.platform.Environment;
import dev.huskuraft.universal.api.platform.LoaderType;
import dev.huskuraft.universal.api.platform.Mod;
import dev.huskuraft.universal.api.platform.Platform;

@AutoService(Platform.class)
public class QuiltPlatform implements Platform {

    @Override
    public LoaderType getLoaderType() {
        return LoaderType.QUILT;
    }

    @Override
    public String getLoaderVersion() {
        return QuiltLoader.getNormalizedGameVersion();
    }

    @Override
    public String getGameVersion() {
        return QuiltLoader.getRawGameVersion();
    }

    @Override
    public List<Mod> getRunningMods() {
        return QuiltLoader.getAllMods().stream().map(QuiltMod::new).collect(Collectors.toList());
    }

    @Override
    public Path getGameDir() {
        return QuiltLoader.getGameDir();
    }

    @Override
    public Environment getEnvironment() {
        return null;
    }

    @Override
    public boolean isDevelopment() {
        return QuiltLoader.isDevelopmentEnvironment();
    }

}

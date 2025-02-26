package dev.huskuraft.universal.vanilla.renderer;

import dev.huskuraft.universal.api.math.Quaternionf;
import dev.huskuraft.universal.api.math.Vector3d;
import dev.huskuraft.universal.api.renderer.Camera;
import dev.huskuraft.universal.vanilla.core.MinecraftConvertor;

public record MinecraftCamera(
        net.minecraft.client.Camera refs
) implements Camera {

    @Override
    public Vector3d position() {
        return MinecraftConvertor.fromPlatformVector3d(refs.getPosition());
    }

    @Override
    public Quaternionf rotation() {
        return MinecraftConvertor.fromPlatformQuaternion(refs.rotation());
    }

    @Override
    public float eyeHeight() {
        return refs.getEntity().getEyeHeight();
    }

}

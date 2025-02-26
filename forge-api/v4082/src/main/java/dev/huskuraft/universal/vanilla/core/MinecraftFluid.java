package dev.huskuraft.universal.vanilla.core;

import dev.huskuraft.universal.api.core.fluid.Fluid;

public record MinecraftFluid(net.minecraft.world.level.material.Fluid refs) implements Fluid {

    public static Fluid ofNullable(net.minecraft.world.level.material.Fluid refs) {
        if (refs == null) return null;
        return new MinecraftFluid(refs);
    }

}

package dev.huskuraft.universal.vanilla.core;

import java.util.Map;
import java.util.stream.Collectors;

import dev.huskuraft.universal.api.core.BlockState;
import dev.huskuraft.universal.api.core.FluidState;
import dev.huskuraft.universal.api.core.Property;
import dev.huskuraft.universal.api.core.PropertyValue;

public record MinecraftFluidState(net.minecraft.world.level.material.FluidState refs) implements FluidState {

    public static FluidState ofNullable(net.minecraft.world.level.material.FluidState refs) {
        if (refs == null) return null;
        return new MinecraftFluidState(refs);
    }

    @Override
    public Map<Property, PropertyValue> getPropertiesMap() {
        return refs.getValues().entrySet().stream().collect(Collectors.toMap(entry -> new MinecraftProperty(entry.getKey()), entry -> new MinecraftPropertyValue(entry.getValue())));
    }

    @Override
    public BlockState createLegacyBlock() {
        return MinecraftBlockState.ofNullable(refs.createLegacyBlock());
    }
}

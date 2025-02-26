package dev.huskuraft.universal.vanilla.core;

import dev.huskuraft.universal.api.core.BlockPosition;
import dev.huskuraft.universal.api.core.BlockState;
import dev.huskuraft.universal.api.core.ContainerBlockEntity;
import dev.huskuraft.universal.api.core.ItemStack;
import dev.huskuraft.universal.api.core.World;
import dev.huskuraft.universal.api.tag.RecordTag;

public record MinecraftContainerBlockEntity(net.minecraft.world.level.block.entity.BaseContainerBlockEntity refs) implements ContainerBlockEntity {

    @Override
    public ItemStack getItem(int index) {
        return new MinecraftContainer(refs).getItem(index);
    }

    @Override
    public void setItem(int index, ItemStack itemStack) {
        new MinecraftContainer(refs).setItem(index, itemStack);
    }

    @Override
    public int getContainerSize() {
        return new MinecraftContainer(refs).getContainerSize();
    }

    @Override
    public BlockState getBlockState() {
        return new MinecraftBlockEntity(refs).getBlockState();
    }

    @Override
    public BlockPosition getBlockPosition() {
        return new MinecraftBlockEntity(refs).getBlockPosition();
    }

    @Override
    public World getWorld() {
        return new MinecraftBlockEntity(refs).getWorld();
    }

    @Override
    public RecordTag getTag() {
        return new MinecraftBlockEntity(refs).getTag();
    }

    @Override
    public void setTag(RecordTag recordTag) {
        new MinecraftBlockEntity(refs).setTag(recordTag);
    }
}

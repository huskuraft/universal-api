package dev.huskuraft.universal.vanilla.texture;

import com.google.auto.service.AutoService;

import dev.huskuraft.universal.api.texture.SimpleTexture;
import dev.huskuraft.universal.api.texture.SimpleTextureSprite;
import dev.huskuraft.universal.api.texture.SpriteScaling;
import dev.huskuraft.universal.api.texture.Texture;
import dev.huskuraft.universal.api.texture.TextureFactory;
import dev.huskuraft.universal.api.texture.TextureSprite;
import dev.huskuraft.universal.vanilla.core.MinecraftResourceLocation;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;

@AutoService(TextureFactory.class)
public final class MinecraftTextureFactory implements TextureFactory {

    @Override
    public Texture getBlockAtlasTexture() {
        return new SimpleTexture(new MinecraftResourceLocation(InventoryMenu.BLOCK_ATLAS));
    }

    @Override
    public TextureSprite getBackgroundTextureSprite() {
        return null;
    }

    @Override
    public TextureSprite getButtonTextureSprite(boolean enabled, boolean focused) {
        return createTextureSprite(AbstractWidget.WIDGETS_LOCATION, null, 200, 20, 0, 46 + (enabled ? focused ? 2 : 1 : 0) * 20, 256, 256, new SpriteScaling.NineSlice(200, 20, enabled ? 3 : 1));
    }

    @Override
    public TextureSprite getDemoBackgroundTextureSprite() {
        return createTextureSprite(new ResourceLocation("textures/gui/demo_background.png"), null, 248, 166, 0, 0, 256, 256, new SpriteScaling.NineSlice(248, 166, 6));
    }

    public TextureSprite createTextureSprite(ResourceLocation texture, ResourceLocation name, int width, int height, int x, int y, int textureWidth, int textureHeight, SpriteScaling scaling) {
        return new SimpleTextureSprite(MinecraftResourceLocation.ofNullable(texture), MinecraftResourceLocation.ofNullable(name), width, height, x, y, textureWidth, textureHeight, scaling);
    }

}

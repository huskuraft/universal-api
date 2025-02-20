package dev.huskuraft.universal.vanilla.renderer;

import com.mojang.blaze3d.vertex.VertexConsumer;

import dev.huskuraft.universal.api.renderer.VertexBuffer;

public record MinecraftVertexBuffer(
        VertexConsumer refs
) implements VertexBuffer {

    @Override
    public MinecraftVertexBuffer vertex(double x, double y, double z) {
        refs.vertex(x, y, z);
        return this;
    }

    @Override
    public MinecraftVertexBuffer color(int red, int green, int blue, int alpha) {
        refs.color(red, green, blue, alpha);
        return this;
    }

    @Override
    public MinecraftVertexBuffer uv(float u, float v) {
        refs.uv(u, v);
        return this;
    }

    @Override
    public MinecraftVertexBuffer uv1(int u, int v) {
        refs.overlayCoords(u, v);
        return this;
    }

    @Override
    public MinecraftVertexBuffer uv2(int u, int v) {
        refs.uv2(u, v);
        return this;
    }

    @Override
    public MinecraftVertexBuffer normal(float x, float y, float z) {
        refs.normal(x, y, z);
        return this;
    }

    @Override
    public void endVertex() {
        refs.endVertex();
    }

}

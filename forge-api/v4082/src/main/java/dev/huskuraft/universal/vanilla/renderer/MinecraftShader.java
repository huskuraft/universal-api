package dev.huskuraft.universal.vanilla.renderer;

import dev.huskuraft.universal.api.core.ResourceLocation;
import dev.huskuraft.universal.api.renderer.Shader;
import dev.huskuraft.universal.api.renderer.Uniform;
import dev.huskuraft.universal.api.renderer.VertexFormat;
import dev.huskuraft.universal.vanilla.core.MinecraftResourceLocation;

public record MinecraftShader(
        net.minecraft.client.renderer.ShaderProgram refs
) implements Shader {

    @Override
    public ResourceLocation getResource() {
        return MinecraftResourceLocation.ofNullable(refs.configId());
    }

    public VertexFormat getVertexFormat() {
        return () -> refs.vertexFormat();
    }

    public Uniform getUniform(String param) {
        return new MinecraftUniform(net.minecraft.client.Minecraft.getInstance().getShaderManager().getProgram(refs).getUniform(param));
    }
}

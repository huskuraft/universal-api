package dev.huskuraft.universal.vanilla.renderer;

import com.mojang.blaze3d.vertex.PoseStack;

import dev.huskuraft.universal.api.math.Matrix3f;
import dev.huskuraft.universal.api.math.Matrix4f;
import dev.huskuraft.universal.api.math.Quaternionf;
import dev.huskuraft.universal.api.renderer.MatrixStack;
import dev.huskuraft.universal.vanilla.core.MinecraftConvertor;

public record MinecraftMatrixStack(
        PoseStack refs
) implements MatrixStack {

    @Override
    public void push() {
        refs.pushPose();
    }

    @Override
    public void pop() {
        refs.popPose();
    }

    @Override
    public Matrix last() {
        return new Matrix() {
            @Override
            public Matrix4f pose() {
                return MinecraftConvertor.fromPlatformMatrix4f(refs.last().pose());
            }

            @Override
            public Matrix3f normal() {
                return MinecraftConvertor.fromPlatformMatrix3f(refs.last().normal());
            }
        };
    }

    @Override
    public void translate(float x, float y, float z) {
        refs.translate(x, y, z);
    }

    @Override
    public void scale(float x, float y, float z) {
        refs.scale(x, y, z);
    }

    @Override
    public void rotate(Quaternionf quaternion) {
        refs.mulPose(MinecraftConvertor.toPlatformQuaternion(quaternion));
    }

    @Override
    public void multiply(Matrix4f matrix) {
        refs.mulPose(MinecraftConvertor.toPlatformMatrix4f(matrix));
    }

    @Override
    public void identity() {
        refs.setIdentity();
    }
}

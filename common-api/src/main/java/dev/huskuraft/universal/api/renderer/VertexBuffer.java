package dev.huskuraft.universal.api.renderer;

import dev.huskuraft.universal.api.core.Direction;
import dev.huskuraft.universal.api.math.Matrix3f;
import dev.huskuraft.universal.api.math.Matrix4f;
import dev.huskuraft.universal.api.math.Vector3d;
import dev.huskuraft.universal.api.math.Vector3f;
import dev.huskuraft.universal.api.math.Vector4f;
import dev.huskuraft.universal.api.platform.PlatformReference;

public interface VertexBuffer extends PlatformReference {

    VertexBuffer vertex(double x, double y, double z);

    VertexBuffer color(int red, int green, int blue, int alpha);

    VertexBuffer uv(float u, float v);

    VertexBuffer uv1(int u, int v);

    VertexBuffer uv2(int u, int v);

    VertexBuffer normal(float x, float y, float z);

    void endVertex();

    default VertexBuffer color(float red, float green, float blue, float alpha) {
        return this.color((int) (red * 255.0F), (int) (green * 255.0F), (int) (blue * 255.0F), (int) (alpha * 255.0F));
    }

    default VertexBuffer color(int color) {
        return this.color(RenderUtils.ARGB32.red(color), RenderUtils.ARGB32.green(color), RenderUtils.ARGB32.blue(color), RenderUtils.ARGB32.alpha(color));
    }

    default VertexBuffer uv1(int overlayUV) {
        return this.uv1(overlayUV & '\uffff', overlayUV >> 16 & '\uffff');
    }

    default VertexBuffer uv2(int lightmapUV) {
        return this.uv2(lightmapUV & '\uffff', lightmapUV >> 16 & '\uffff');
    }

    default VertexBuffer vertex(Matrix4f matrix, float x, float y, float z) {
        var vector4f = matrix.mul(new Vector4f(x, y, z, 1.0F));
        return this.vertex(vector4f.x(), vector4f.y(), vector4f.z());
    }

    default VertexBuffer vertex(Matrix4f matrix, Vector3d vector3d) {
        return vertex(matrix, (float) vector3d.x(), (float) vector3d.y(), (float) vector3d.z());
    }

    default VertexBuffer normal(Matrix3f matrix, float x, float y, float z) {
        var vector3f = matrix.mul(new Vector3f(x, y, z));
        return this.normal(vector3f.x(), vector3f.y(), vector3f.z());
    }

    default VertexBuffer normal(Matrix3f matrix, Direction normal) {
        var xOffset = normal != null ? normal.getStepX() : 0;
        var yOffset = normal != null ? normal.getStepY() : 0;
        var zOffset = normal != null ? normal.getStepZ() : 0;
        return this.normal(matrix, xOffset, yOffset, zOffset);
    }


}

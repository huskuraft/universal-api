package dev.huskuraft.universal.api.core;

import dev.huskuraft.universal.api.math.MathUtils;
import dev.huskuraft.universal.api.math.Vector3d;
import dev.huskuraft.universal.api.math.Vector3i;

public record BlockPosition(int x, int y, int z) {

    public static final BlockPosition ZERO = new BlockPosition(0, 0, 0);
    public static final BlockPosition ONE = new BlockPosition(1, 1, 1);


    public static BlockPosition at(double x, double y, double z) {
        return at((int) MathUtils.floor(x), (int) MathUtils.floor(y), (int) MathUtils.floor(z));
    }

    public static BlockPosition at(int x, int y, int z) {
        return new BlockPosition(x, y, z);
    }

    public static BlockPosition at(Vector3d vector) {
        return at(vector.x(), vector.y(), vector.z());
    }

    public static BlockPosition at(Vector3i vector) {
        return at(vector.x(), vector.y(), vector.z());
    }

    public BlockPosition offset(int i, int j, int k) {
        return i == 0 && j == 0 && k == 0 ? this : new BlockPosition(x() + i, y() + j, z() + k);
    }

    public Vector3d getCenter() {
        return toVector3d().add(0.5, 0.5, 0.5);
    }

    public BlockPosition offset(Vector3i vector) {
        return offset(vector.x(), vector.y(), vector.z());
    }

    public BlockPosition sub(Vector3i vector) {
        return offset(-vector.x(), -vector.y(), -vector.z());
    }

    public BlockPosition sub(BlockPosition blockPosition) {
        return offset(-blockPosition.x(), -blockPosition.y(), -blockPosition.z());
    }

    public BlockPosition mul(int i) {
        if (i == 1) {
            return this;
        } else {
            return i == 0 ? ZERO : new BlockPosition(x() * i, y() * i, z() * i);
        }
    }

    public BlockPosition above() {
        return this.relative(Direction.UP);
    }

    public BlockPosition above(int i) {
        return this.relative(Direction.UP, i);
    }

    public BlockPosition below() {
        return this.relative(Direction.DOWN);
    }

    public BlockPosition below(int i) {
        return this.relative(Direction.DOWN, i);
    }

    public BlockPosition north() {
        return this.relative(Direction.NORTH);
    }

    public BlockPosition north(int i) {
        return this.relative(Direction.NORTH, i);
    }

    public BlockPosition south() {
        return this.relative(Direction.SOUTH);
    }

    public BlockPosition south(int i) {
        return this.relative(Direction.SOUTH, i);
    }

    public BlockPosition west() {
        return this.relative(Direction.WEST);
    }

    public BlockPosition west(int i) {
        return this.relative(Direction.WEST, i);
    }

    public BlockPosition east() {
        return this.relative(Direction.EAST);
    }

    public BlockPosition east(int i) {
        return this.relative(Direction.EAST, i);
    }

    public BlockPosition relative(Direction direction) {
        return new BlockPosition(x() + direction.getStepX(), y() + direction.getStepY(), z() + direction.getStepZ());
    }

    public BlockPosition relative(Direction direction, int i) {
        return i == 0 ? this : new BlockPosition(x() + direction.getStepX() * i, y() + direction.getStepY() * i, z() + direction.getStepZ() * i);
    }

    public BlockPosition relative(Axis axis, int i) {
        if (i == 0) {
            return this;
        } else {
            int j = axis == Axis.X ? i : 0;
            int k = axis == Axis.Y ? i : 0;
            int l = axis == Axis.Z ? i : 0;
            return new BlockPosition(x() + j, y() + k, z() + l);
        }
    }

    public BlockPosition rotate(Revolve revolve) {
        return switch (revolve) {
            case CLOCKWISE_90 -> new BlockPosition(-z(), y(), x());
            case CLOCKWISE_180 -> new BlockPosition(-x(), y(), -z());
            case COUNTERCLOCKWISE_90 -> new BlockPosition(z(), y(), -x());
            default -> this;
        };
    }

    public BlockPosition cross(Vector3i vector) {
        return new BlockPosition(y() * vector.z() - z() * vector.y(), z() * vector.x() - x() * vector.z(), x() * vector.y() - y() * vector.x());
    }

    public int get(Axis axis) {
        return switch (axis) {
            case X -> this.x;
            case Y -> this.y;
            case Z -> this.z;
        };
    }

    public BlockPosition add(Vector3i other) {
        return add(other.x(), other.y(), other.z());
    }

    public BlockPosition add(BlockPosition blockPosition) {
        return add(blockPosition.x(), blockPosition.y(), blockPosition.z());
    }

    public BlockPosition add(int x, int y, int z) {
        return BlockPosition.at(this.x + x, this.y + y, this.z + z);
    }

    public BlockPosition withX(int x) {
        return new BlockPosition(x, y, z);
    }

    public BlockPosition withY(int y) {
        return new BlockPosition(x, y, z);
    }

    public BlockPosition withZ(int z) {
        return new BlockPosition(x, y, z);
    }

    public Vector3d toVector3d() {
        return Vector3d.at(x, y, z);
    }

    public Vector3i toVector3i() {
        return Vector3i.at(x, y, z);
    }

    public int volume() {
        return x * y * z;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}

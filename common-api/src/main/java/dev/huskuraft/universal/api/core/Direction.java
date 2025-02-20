package dev.huskuraft.universal.api.core;

import java.util.Arrays;
import java.util.Comparator;

import dev.huskuraft.universal.api.math.MathUtils;
import dev.huskuraft.universal.api.math.Vector3d;
import dev.huskuraft.universal.api.math.Vector3i;

public enum Direction {
    DOWN(0, 1, -1, "down", AxisDirection.NEGATIVE, Axis.Y, new Vector3i(0, -1, 0)),
    UP(1, 0, -1, "up", AxisDirection.POSITIVE, Axis.Y, new Vector3i(0, 1, 0)),
    NORTH(2, 3, 2, "north", AxisDirection.NEGATIVE, Axis.Z, new Vector3i(0, 0, -1)),
    SOUTH(3, 2, 0, "south", AxisDirection.POSITIVE, Axis.Z, new Vector3i(0, 0, 1)),
    WEST(4, 5, 1, "west", AxisDirection.NEGATIVE, Axis.X, new Vector3i(-1, 0, 0)),
    EAST(5, 4, 3, "east", AxisDirection.POSITIVE, Axis.X, new Vector3i(1, 0, 0));

    private static final Direction[] BY_3D_DATA = Arrays.stream(values()).sorted(Comparator.comparingInt((direction) -> direction.data3d)).toArray(Direction[]::new);
    private static final Direction[] BY_2D_DATA = Arrays.stream(values()).filter(direction -> direction.getAxis().isHorizontal()).sorted(Comparator.comparingInt(direction -> direction.data2d)).toArray(Direction[]::new);
    private final int data3d;
    private final int oppositeIndex;
    private final int data2d;
    private final String name;
    private final Axis axis;
    private final AxisDirection axisDirection;
    private final Vector3i normal;

    Direction(int data3d, int oppositeIndex, int data2d, String name, AxisDirection axisDirection, Axis axis, Vector3i normal) {
        this.data3d = data3d;
        this.data2d = data2d;
        this.oppositeIndex = oppositeIndex;
        this.name = name;
        this.axis = axis;
        this.axisDirection = axisDirection;
        this.normal = normal;
    }

    public static Direction from3DDataValue(int i) {
        return BY_3D_DATA[MathUtils.abs(i % BY_3D_DATA.length)];
    }

    public static Direction from2DDataValue(int i) {
        return BY_2D_DATA[MathUtils.abs(i % BY_2D_DATA.length)];
    }


    public static Direction fromYRot(double angle) {
        return from2DDataValue((int) Math.floor(angle / 90.0D + 0.5D) & 3);
    }


    public static Direction getNearest(Vector3d vector3d) {
        return getNearest(vector3d.x(), vector3d.y(), vector3d.z());
    }

    public static Direction getNearest(double d, double e, double f) {
        return getNearest((float) d, (float) e, (float) f);
    }

    public static Direction getNearest(float f, float g, float h) {
        var direction = NORTH;
        var i = Float.MIN_VALUE;

        for (var direction2 : values()) {
            float j = f * (float) direction2.normal.x() + g * (float) direction2.normal.y() + h * (float) direction2.normal.z();
            if (j > i) {
                i = j;
                direction = direction2;
            }
        }

        return direction;
    }

    public static Direction get(AxisDirection axisDirection, Axis axis) {

        for (Direction direction : values()) {
            if (direction.getAxisDirection() == axisDirection && direction.getAxis() == axis) {
                return direction;
            }
        }

        throw new IllegalArgumentException("No such direction: " + axisDirection + " " + axis);
    }

    public int get3DDataValue() {
        return this.data3d;
    }

    public int get2DDataValue() {
        return this.data2d;
    }

    public AxisDirection getAxisDirection() {
        return this.axisDirection;
    }

    public Direction getOpposite() {
        return from3DDataValue(this.oppositeIndex);
    }

    public Direction getClockWise(Axis axis) {

        return switch (axis) {
            case X -> this != WEST && this != EAST ? this.getClockWiseX() : this;
            case Z -> this != NORTH && this != SOUTH ? this.getClockWiseZ() : this;
            case Y -> this != UP && this != DOWN ? this.getClockWise() : this;
            default -> throw new IncompatibleClassChangeError();
        };
    }

    public Direction getCounterClockWise(Axis axis) {

        return switch (axis) {
            case X -> this != WEST && this != EAST ? this.getCounterClockWiseX() : this;
            case Z -> this != NORTH && this != SOUTH ? this.getCounterClockWiseZ() : this;
            case Y -> this != UP && this != DOWN ? this.getCounterClockWise() : this;
            default -> throw new IncompatibleClassChangeError();
        };
    }

    public Direction getClockWise() {

        return switch (this) {
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            case EAST -> SOUTH;
            default -> throw new IllegalStateException("Unable to get Y-rotated facing of " + this);
        };
    }

    private Direction getClockWiseX() {

        return switch (this) {
            case DOWN -> SOUTH;
            case UP -> NORTH;
            case NORTH -> DOWN;
            case SOUTH -> UP;
            default -> throw new IllegalStateException("Unable to get X-rotated facing of " + this);
        };
    }

    private Direction getCounterClockWiseX() {

        return switch (this) {
            case DOWN -> NORTH;
            case UP -> SOUTH;
            case NORTH -> UP;
            case SOUTH -> DOWN;
            default -> throw new IllegalStateException("Unable to get X-rotated facing of " + this);
        };
    }

    private Direction getClockWiseZ() {

        return switch (this) {
            case DOWN -> WEST;
            case UP -> EAST;
            case WEST -> UP;
            case EAST -> DOWN;
            default -> throw new IllegalStateException("Unable to get Z-rotated facing of " + this);
        };
    }

    private Direction getCounterClockWiseZ() {

        return switch (this) {
            case DOWN -> EAST;
            case UP -> WEST;
            case WEST -> DOWN;
            case EAST -> UP;
            default -> throw new IllegalStateException("Unable to get Z-rotated facing of " + this);
        };
    }

    public Direction getCounterClockWise() {

        return switch (this) {
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
            case EAST -> NORTH;
            default -> throw new IllegalStateException("Unable to get CCW facing of " + this);
        };
    }

    @Deprecated // rename
    public float toYRot() {
        return (this.data2d & 3) * 90;
    }

    public int getStepX() {
        return this.normal.x();
    }

    public int getStepY() {
        return this.normal.y();
    }

    public int getStepZ() {
        return this.normal.z();
    }

    public Vector3d step() {
        return new Vector3d((float) this.getStepX(), (float) this.getStepY(), (float) this.getStepZ());
    }

    public String getName() {
        return this.name;
    }

    public Axis getAxis() {
        return this.axis;
    }

    public String toString() {
        return this.name;
    }

    public Vector3i getNormal() {
        return this.normal;
    }

}

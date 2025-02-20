package dev.huskuraft.universal.api.core;

public enum Revolve {
    NONE("none"),
    CLOCKWISE_90("clockwise_90"),
    CLOCKWISE_180("180"),
    COUNTERCLOCKWISE_90("counterclockwise_90");

    private final String id;

    Revolve(String string2) {
        this.id = string2;
    }

    public Revolve getRotated(Revolve revolve) {
        return switch (revolve) {
            case CLOCKWISE_180 -> switch (this) {
                case NONE -> CLOCKWISE_180;
                case CLOCKWISE_90 -> COUNTERCLOCKWISE_90;
                case CLOCKWISE_180 -> NONE;
                case COUNTERCLOCKWISE_90 -> CLOCKWISE_90;
            };
            case COUNTERCLOCKWISE_90 -> switch (this) {
                case NONE -> COUNTERCLOCKWISE_90;
                case CLOCKWISE_90 -> NONE;
                case CLOCKWISE_180 -> CLOCKWISE_90;
                case COUNTERCLOCKWISE_90 -> CLOCKWISE_180;
            };
            case CLOCKWISE_90 -> switch (this) {
                case NONE -> CLOCKWISE_90;
                case CLOCKWISE_90 -> CLOCKWISE_180;
                case CLOCKWISE_180 -> COUNTERCLOCKWISE_90;
                case COUNTERCLOCKWISE_90 -> NONE;
            };
            default -> this;
        };
    }

    public Direction rotate(Direction direction) {
        if (direction.getAxis() == Axis.Y) {
            return direction;
        } else {
            return switch (this) {
                case CLOCKWISE_90 -> direction.getClockWise();
                case CLOCKWISE_180 -> direction.getOpposite();
                case COUNTERCLOCKWISE_90 -> direction.getCounterClockWise();
                default -> direction;
            };
        }
    }

    public int rotate(int i, int j) {
        return switch (this) {
            case CLOCKWISE_90 -> (i + j / 4) % j;
            case CLOCKWISE_180 -> (i + j / 2) % j;
            case COUNTERCLOCKWISE_90 -> (i + j * 3 / 4) % j;
            default -> i;
        };
    }

    public String getSerializedName() {
        return this.id;
    }

}

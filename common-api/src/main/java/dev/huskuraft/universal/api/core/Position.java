package dev.huskuraft.universal.api.core;

import dev.huskuraft.universal.api.text.Text;

public enum Position {

    DISABLED("disabled"),
    LEFT("left"),
    RIGHT("right");

    private final String name;

    Position(String name) {
        this.name = name;
    }

    public Text getDisplayName() {
        return Text.translate("effortless.position.%s".formatted(name));
    }

    public AxisDirection getAxis() {
        return switch (this) {
            case LEFT -> AxisDirection.NEGATIVE;
            case RIGHT -> AxisDirection.POSITIVE;
            default -> null;
        };
    }
}

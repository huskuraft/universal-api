package dev.huskuraft.universal.api.core;

import dev.huskuraft.universal.api.math.Vector3d;

public interface Interaction {
    Target getTarget();

    Vector3d getPosition();

    default InteractionHand getHand() {
        return InteractionHand.MAIN;
    }

    enum Target {
        MISS,
        BLOCK,
        ENTITY
    }
}

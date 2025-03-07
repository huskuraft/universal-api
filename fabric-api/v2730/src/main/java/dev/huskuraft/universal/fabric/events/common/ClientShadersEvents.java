package dev.huskuraft.universal.fabric.events.common;

import java.io.IOException;
import java.util.function.Consumer;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.server.packs.resources.ResourceManager;

public class ClientShadersEvents {

    public static final Event<Register> REGISTER = EventFactory.createArrayBacked(Register.class, callbacks -> (manager, sink) -> {
        for (var callback : callbacks) {
            callback.onRegisterShader(manager, sink);
        }
    });

    @FunctionalInterface
    public interface Register {
        void onRegisterShader(ResourceManager manager, ShadersSink sink) throws IOException;

        @FunctionalInterface
        interface ShadersSink {
            void register(ShaderInstance shader, Consumer<ShaderInstance> callback);
        }
    }

}

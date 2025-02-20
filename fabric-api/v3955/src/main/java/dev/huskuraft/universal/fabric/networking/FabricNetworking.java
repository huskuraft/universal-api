package dev.huskuraft.universal.fabric.networking;

import com.google.auto.service.AutoService;
import dev.huskuraft.universal.api.core.Player;
import dev.huskuraft.universal.api.core.ResourceLocation;
import dev.huskuraft.universal.api.networking.ByteBufReceiver;
import dev.huskuraft.universal.api.networking.ByteBufSender;
import dev.huskuraft.universal.api.networking.Networking;
import dev.huskuraft.universal.api.networking.Side;
import dev.huskuraft.universal.vanilla.core.MinecraftPlayer;
import io.netty.buffer.ByteBuf;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@AutoService(Networking.class)
public class FabricNetworking implements Networking {

    public static final Map<ResourceLocation, Payload.Type<Payload>> MAP = new HashMap<>();

    public static ByteBufSender register(ResourceLocation channelId, Side side, ByteBufReceiver receiver) {
        var payloadType = MAP.computeIfAbsent(channelId, resourceLocation -> {
            var type = new Payload.Type<Payload>(channelId.reference());
            var codec = new StreamCodec<RegistryFriendlyByteBuf, Payload>() {
                @Override
                public Payload decode(RegistryFriendlyByteBuf byteBuf) {
                    return new Payload(type, byteBuf.readBytes(byteBuf.readableBytes()));
                }
                @Override
                public void encode(RegistryFriendlyByteBuf byteBuf, Payload payload) {
                    byteBuf.writeBytes(payload.byteBuf());
                }
            };
            PayloadTypeRegistry.playC2S().register(type, codec);
            PayloadTypeRegistry.playS2C().register(type, codec);
            return type;
        });
        var fabricSide = switch (side) {
            case CLIENT -> new Client();
            case SERVER -> new Server();
        };
        fabricSide.registerReceiver(payloadType, (payload, player) -> {
            receiver.receiveBuffer(payload.byteBuf(), player);
        });
        return (byteBuf, player) -> {
            fabricSide.send(new Payload(payloadType, byteBuf), player);
        };
    }

    public record Payload(Type<Payload> type, ByteBuf byteBuf) implements CustomPacketPayload {
    }

    void registerReceiver(Payload.Type<Payload> type, BiConsumer<Payload, Player> receiver) {
    }

    void send(Payload payload, Player player) {
    }

    static class Server extends FabricNetworking {

        @Override
        public void registerReceiver(Payload.Type<Payload> type, BiConsumer<Payload, Player> receiver) {
            ServerPlayNetworking.registerGlobalReceiver(type, (payload, context) -> {
                receiver.accept(payload, MinecraftPlayer.ofNullable(context.player()));
            });
        }

        @Override
        public void send(Payload payload, Player player) {
            ServerPlayNetworking.send(player.reference(), payload);
        }
    }

    static class Client extends FabricNetworking {

        @Override
        public void registerReceiver(Payload.Type<Payload> type, BiConsumer<Payload, Player> receiver) {
            ClientPlayNetworking.registerGlobalReceiver(type, (payload, context) -> {
                receiver.accept(payload, MinecraftPlayer.ofNullable(context.player()));
            });
        }

        @Override
        public void send(Payload payload, Player player) {
            ClientPlayNetworking.send(payload);
        }
    }

}

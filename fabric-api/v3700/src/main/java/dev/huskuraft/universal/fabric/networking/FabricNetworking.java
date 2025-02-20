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
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;

@AutoService(Networking.class)
public class FabricNetworking implements Networking {

    public static ByteBufSender register(ResourceLocation channelId, Side side, ByteBufReceiver receiver) {
        var fabricSide = switch (side) {
            case CLIENT -> new Client();
            case SERVER -> new Server();
        };
        fabricSide.registerReceiver(channelId, receiver);
        return (byteBuf, player) -> fabricSide.send(channelId, byteBuf, player);
    }

    void registerReceiver(ResourceLocation channelId, ByteBufReceiver receiver) {
    }

    void send(ResourceLocation channelId, ByteBuf byteBuf, Player player) {
    }

    static class Server extends FabricNetworking {
        @Override
        void registerReceiver(ResourceLocation channelId, ByteBufReceiver receiver) {
            ServerPlayNetworking.registerGlobalReceiver(channelId.reference(), (server, player, handler, buf, responseSender) -> receiver.receiveBuffer(buf, MinecraftPlayer.ofNullable(player)));
        }

        @Override
        void send(ResourceLocation channelId, ByteBuf byteBuf, Player player) {
            ServerPlayNetworking.send(player.reference(), channelId.reference(), new FriendlyByteBuf(byteBuf));
        }
    }

    static class Client extends FabricNetworking {
        @Override
        void registerReceiver(ResourceLocation channelId, ByteBufReceiver receiver) {
            ClientPlayNetworking.registerGlobalReceiver(channelId.reference(), (client, handler, buf, responseSender) -> receiver.receiveBuffer(buf, MinecraftPlayer.ofNullable(client.player)));
        }

        @Override
        void send(ResourceLocation channelId, ByteBuf byteBuf, Player player) {
            ClientPlayNetworking.send(channelId.reference(), new FriendlyByteBuf(byteBuf));
        }
    }

}

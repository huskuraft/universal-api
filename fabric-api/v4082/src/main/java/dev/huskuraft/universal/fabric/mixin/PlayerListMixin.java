package dev.huskuraft.universal.fabric.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import dev.huskuraft.universal.fabric.events.common.ServerPlayerEvents;
import net.minecraft.network.Connection;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.CommonListenerCookie;
import net.minecraft.server.players.PlayerList;

@Mixin(PlayerList.class)
abstract class PlayerListMixin {

    @Inject(method = "placeNewPlayer", at = @At("TAIL"))
    private void onPlayerLoggedIn(Connection connection, ServerPlayer serverPlayer, CommonListenerCookie commonListenerCookie, CallbackInfo ci) {
        ServerPlayerEvents.LOGGED_IN.invoker().onLoggedIn(serverPlayer);
    }

    @Inject(method = "remove", at = @At("HEAD"))
    private void onPlayerLoggedOut(ServerPlayer serverPlayer, CallbackInfo ci) {
        ServerPlayerEvents.LOGGED_OUT.invoker().onLoggedOut(serverPlayer);
    }

    @Inject(method = "respawn", at = @At("TAIL"))
    private void onPlayerRespawned(ServerPlayer serverPlayer, boolean bl, net.minecraft.world.entity.Entity.RemovalReason removalReason, CallbackInfoReturnable<ServerPlayer> cir) {
        ServerPlayerEvents.RESPAWN.invoker().onRespawn(serverPlayer, cir.getReturnValue(), bl);
    }
}

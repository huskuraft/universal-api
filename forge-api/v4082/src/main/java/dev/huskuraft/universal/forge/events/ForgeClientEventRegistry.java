package dev.huskuraft.universal.forge.events;

import com.google.auto.service.AutoService;

import com.mojang.blaze3d.vertex.PoseStack;

import dev.huskuraft.universal.api.core.InteractionType;
import dev.huskuraft.universal.api.events.impl.ClientEventRegistry;
import dev.huskuraft.universal.api.events.lifecycle.ClientTick;
import dev.huskuraft.universal.api.input.InputKey;
import dev.huskuraft.universal.forge.networking.ForgeNetworking;
import dev.huskuraft.universal.vanilla.core.MinecraftConvertor;
import dev.huskuraft.universal.vanilla.platform.MinecraftClient;
import dev.huskuraft.universal.vanilla.renderer.MinecraftRenderer;
import dev.huskuraft.universal.vanilla.renderer.MinecraftShader;
import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.ShaderInstance;
import net.minecraftforge.client.event.CustomizeGuiOverlayEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
//import net.minecraftforge.client.event.RegisterShadersEvent;
//import net.minecraftforge.client.event.RenderLevelStageEvent;
//import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
//import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@AutoService(ClientEventRegistry.class)
public class ForgeClientEventRegistry extends ClientEventRegistry {

    public ForgeClientEventRegistry() {
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onRegisterKeyMappings);
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onReloadShader);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onClientSetup(FMLClientSetupEvent event) {
        getClientStartEvent().invoker().onClientStart(new MinecraftClient(Minecraft.getInstance()));
        getRegisterNetworkEvent().invoker().onRegisterNetwork(ForgeNetworking::register);
    }

    @SubscribeEvent
    public void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        getRegisterKeysEvent().invoker().onRegisterKeys(key -> {
            event.register(key.getKeyBinding().reference());
        });
    }

//    @SubscribeEvent
//    public void onReloadShader(RegisterShadersEvent event) {
//        getRegisterShaderEvent().invoker().onRegisterShader((resource, format, consumer) -> {
//            var minecraftShader = new ShaderInstance(event.getResourceProvider(), resource.getPath(), format.reference());
//            event.registerShader(minecraftShader, shaderInstance -> consumer.accept(new MinecraftShader(shaderInstance)));
//        });
//    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        getClientTickEvent().invoker().onClientTick(new MinecraftClient(Minecraft.getInstance()), ClientTick.Phase.START); //  switch (event.phase) {
//            case START -> ClientTick.Phase.START;
//            case END -> ClientTick.Phase.END;
//        });
    }

//    @SubscribeEvent
//    public void onRenderLevelStage(RenderLevelStageEvent event) {
//        if (event.getStage() != RenderLevelStageEvent.Stage.AFTER_TRANSLUCENT_BLOCKS) {
//            return;
//        }
//        getRenderWorldEvent().invoker().onRenderWorld(new MinecraftRenderer(new PoseStack()), event.getPartialTick());
//    }

    @SubscribeEvent
    public void onRenderGui(CustomizeGuiOverlayEvent.Chat event) {
        getRenderGuiEvent().invoker().onRenderGui(new MinecraftRenderer(event.getGuiGraphics().pose()), event.getPartialTick());
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.Key event) {
        getKeyInputEvent().invoker().onKeyInput(new InputKey(event.getKey(), event.getScanCode(), event.getAction(), event.getModifiers()));
    }

    @SubscribeEvent
    public void onInteractionInput(InputEvent.InteractionKeyMappingTriggered event) {
        var type = event.isAttack() ? InteractionType.ATTACK : event.isUseItem() ? InteractionType.USE_ITEM : InteractionType.UNKNOWN;
        var hand = MinecraftConvertor.fromPlatformInteractionHand(event.getHand());
        if (getInteractionInputEvent().invoker().onInteractionInput(type, hand).interruptsFurtherEvaluation()) {
            event.setCanceled(true);
            event.setSwingHand(false);
        }
    }

}

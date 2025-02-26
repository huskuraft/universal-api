package dev.huskuraft.universal.vanilla.sound;

import static net.minecraft.client.resources.sounds.SoundInstance.Attenuation.LINEAR;
import static net.minecraft.client.resources.sounds.SoundInstance.Attenuation.NONE;
import static net.minecraft.client.resources.sounds.SoundInstance.createUnseededRandom;
import static net.minecraft.sounds.SoundSource.AMBIENT;
import static net.minecraft.sounds.SoundSource.BLOCKS;
import static net.minecraft.sounds.SoundSource.HOSTILE;
import static net.minecraft.sounds.SoundSource.MASTER;
import static net.minecraft.sounds.SoundSource.MUSIC;
import static net.minecraft.sounds.SoundSource.NEUTRAL;
import static net.minecraft.sounds.SoundSource.PLAYERS;
import static net.minecraft.sounds.SoundSource.RECORDS;
import static net.minecraft.sounds.SoundSource.VOICE;
import static net.minecraft.sounds.SoundSource.WEATHER;

import com.google.auto.service.AutoService;

import dev.huskuraft.universal.api.core.ResourceLocation;
import dev.huskuraft.universal.api.sound.SoundFactory;
import dev.huskuraft.universal.api.sound.SoundInstance;
import dev.huskuraft.universal.api.sound.SoundSource;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;

@AutoService(SoundFactory.class)
public final class MinecraftSoundFactory implements SoundFactory {

    @Override
    public SoundInstance createSimpleSoundInstance(ResourceLocation location, SoundSource source, float volume, float pitch, boolean looping, int delay, SoundInstance.Attenuation attenuation, double x, double y, double z, boolean relative) {
        var instance = new SimpleSoundInstance(
                location.reference(),
                getSoundSource(source),
                volume,
                pitch,
                createUnseededRandom(),
                looping,
                delay,
                getAttenuation(attenuation),
                x,
                y,
                z,
                relative
        );
        return () -> instance;
    }

    private net.minecraft.sounds.SoundSource getSoundSource(SoundSource source) {
        return switch (source) {
            case MASTER -> MASTER;
            case MUSIC -> MUSIC;
            case RECORDS -> RECORDS;
            case WEATHER -> WEATHER;
            case BLOCKS -> BLOCKS;
            case HOSTILE -> HOSTILE;
            case NEUTRAL -> NEUTRAL;
            case PLAYERS -> PLAYERS;
            case AMBIENT -> AMBIENT;
            case VOICE -> VOICE;
        };
    }

    private net.minecraft.client.resources.sounds.SoundInstance.Attenuation getAttenuation(SoundInstance.Attenuation source) {
        return switch (source) {
            case NONE -> NONE;
            case LINEAR -> LINEAR;
        };
    }
}

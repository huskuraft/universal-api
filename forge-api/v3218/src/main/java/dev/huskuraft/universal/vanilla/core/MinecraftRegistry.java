package dev.huskuraft.universal.vanilla.core;

import java.util.Iterator;

import javax.annotation.Nullable;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;

import dev.huskuraft.universal.api.core.Registry;
import dev.huskuraft.universal.api.platform.PlatformReference;
import net.minecraft.core.IdMap;

public record MinecraftRegistry<T extends PlatformReference, R>(
        IdMap<R> refs,
        Function<R, T> typeConvertor
) implements Registry<T> {

    @Override
    public int getId(T value) {
        return refs.getId(value.reference());
    }

    @Nullable
    @Override
    public T byId(int key) {
        return typeConvertor().apply(refs.byId(key));
    }

    @Override
    public Iterator<T> iterator() {
        return Iterators.transform(refs.iterator(), typeConvertor());
    }
}

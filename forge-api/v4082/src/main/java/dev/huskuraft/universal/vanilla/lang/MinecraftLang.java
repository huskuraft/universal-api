package dev.huskuraft.universal.vanilla.lang;

import com.google.auto.service.AutoService;

import dev.huskuraft.universal.api.lang.Lang;
import net.minecraft.locale.Language;

@AutoService(Lang.class)
public final class MinecraftLang implements Lang {

    @Override
    public String getOrDefault(String id) {
        return Language.getInstance().getOrDefault(id);
    }

    @Override
    public boolean has(String id) {
        return Language.getInstance().has(id);
    }

    @Override
    public boolean isDefaultRightToLeft() {
        return Language.getInstance().isDefaultRightToLeft();
    }
}

package dev.huskuraft.universal.neoforge.platform;

import dev.huskuraft.universal.api.platform.ClientEntrance;
import dev.huskuraft.universal.api.platform.Entrance;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod("universal")
public class NeoForgeInitializer {

    public static IEventBus EVENT_BUS;

    public NeoForgeInitializer(IEventBus eventBus) {
        EVENT_BUS = eventBus;

        Entrance.getInstance();

        if (FMLEnvironment.dist.isClient()) {
            ClientEntrance.getInstance();
        }
    }

}

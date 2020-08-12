package io.github.xf8b.testmod;

import io.github.xf8b.testmod.config.TestModConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class TestMod implements ModInitializer {
    public static final String MOD_ID = "testmod";

    @Override
    public void onInitialize() {
        AutoConfig.register(TestModConfig.class, Toml4jConfigSerializer::new);
    }
}

package io.github.xf8b.testmod.integration;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;
import io.github.xf8b.testmod.TestMod;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class TestModModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        //currently crashes game due to `NoSuchMethodException` so just dont click on the config menu in modmenu
        return parent -> {
            ConfigBuilder configBuilder = ConfigBuilder.create()
                    .setParentScreen(parent)
                    .setTitle(Text.of("config." + TestMod.MOD_ID + ".title"));
            configBuilder.getOrCreateCategory(Text.of("config." + TestMod.MOD_ID + ".category.main.title"));
            return configBuilder.build();
        };
    }
}

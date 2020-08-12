package io.github.xf8b.testmod.core;

import io.github.xf8b.testmod.core.registries.ItemRegistries;
import io.github.xf8b.testmod.util.TestModPacketHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TestMod.MOD_ID)
public class TestMod {
    public static final String MOD_ID = "testmod";
    public static final ItemGroup ITEM_GROUP = new ItemGroup(MOD_ID) {
        @OnlyIn(Dist.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemRegistries.MAGIC_WAND.get());
        }
    };

    public TestMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);

        ItemRegistries.ITEMS.register(modEventBus);
    }

    private void setup(final FMLCommonSetupEvent event) {
        TestModPacketHandler.registerPackets();
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
    }
}

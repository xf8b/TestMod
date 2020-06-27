package io.github.xf8b.testmod.core;

import io.github.xf8b.testmod.items.MagicWand;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TestModRegistries {
    //Deferred Registers
    public static DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    //Registry Objects
    public static RegistryObject<Item> MAGIC_WAND = ITEMS.register("magic_wand", MagicWand::new);
}

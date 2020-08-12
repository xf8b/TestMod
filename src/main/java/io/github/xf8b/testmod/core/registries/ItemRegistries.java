package io.github.xf8b.testmod.core.registries;

import io.github.xf8b.testmod.core.TestMod;
import io.github.xf8b.testmod.items.MagicWand;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistries {
    //Deferred Register
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    //Registry Objects
    public static final RegistryObject<Item> MAGIC_WAND = ITEMS.register(
            "magic_wand",
            () -> new MagicWand(new Item.Properties().group(TestMod.ITEM_GROUP).maxStackSize(1))
    );
}

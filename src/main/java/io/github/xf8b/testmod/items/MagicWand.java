package io.github.xf8b.testmod.items;

import io.github.xf8b.testmod.core.TestMod;
import io.github.xf8b.testmod.packet.ExplodePacket;
import io.github.xf8b.testmod.util.TestModPacketHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.world.World;

public class MagicWand extends Item {
    public MagicWand() {
        super(new Properties()
                .group(TestMod.itemGroup)
                .maxStackSize(1)
        );
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        BlockRayTraceResult rayTraceResult = worldIn.rayTraceBlocks(new RayTraceContext(playerIn.getLookVec(), playerIn.getPositionVector(), RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.ANY, playerIn));
        TestModPacketHandler.INSTANCE.sendToServer(new ExplodePacket(playerIn.getPosition(), rayTraceResult));
        return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
    }
}

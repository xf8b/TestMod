package io.github.xf8b.testmod.items;

import io.github.xf8b.testmod.packet.ExplodePacket;
import io.github.xf8b.testmod.util.TestModPacketHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

public class MagicWand extends Item {
    public MagicWand(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (worldIn.isRemote) {
            BlockRayTraceResult rayTraceResult = (BlockRayTraceResult) rayTrace(worldIn, playerIn, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.ANY);
            TestModPacketHandler.INSTANCE.sendToServer(new ExplodePacket(playerIn.getPosition(), rayTraceResult, 10));
        }
        return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
    }

    protected static RayTraceResult rayTrace(World world, PlayerEntity player, RayTraceContext.BlockMode blockMode, RayTraceContext.FluidMode fluidMode) {
        float f = player.rotationPitch;
        float f1 = player.rotationYaw;
        Vec3d vec3d = player.getEyePosition(1.0f);
        float f2 = MathHelper.cos(-f1 * ((float) Math.PI / 180f) - (float) Math.PI);
        float f3 = MathHelper.sin(-f1 * ((float) Math.PI / 180f) - (float) Math.PI);
        float f4 = -MathHelper.cos(-f * ((float) Math.PI / 180f));
        float f5 = MathHelper.sin(-f * ((float) Math.PI / 180f));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d0 = 100d;
        Vec3d vec3d1 = vec3d.add((double) f6 * d0, (double) f5 * d0, (double) f7 * d0);
        return world.rayTraceBlocks(new RayTraceContext(vec3d, vec3d1, blockMode, fluidMode, player));
    }
}

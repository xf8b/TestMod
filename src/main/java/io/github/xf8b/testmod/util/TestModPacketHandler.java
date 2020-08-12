package io.github.xf8b.testmod.util;

import io.github.xf8b.testmod.core.TestMod;
import io.github.xf8b.testmod.packet.ExplodePacket;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import java.util.concurrent.ThreadLocalRandom;

public class TestModPacketHandler {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(TestMod.MOD_ID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void registerPackets() {
        INSTANCE.registerMessage(
                ThreadLocalRandom.current().nextInt(),
                ExplodePacket.class,
                (packet1, buffer) -> ExplodePacket.encode(buffer),
                ExplodePacket::decode,
                (packet, ctx) -> ExplodePacket.handle(ctx)
        );
    }
}

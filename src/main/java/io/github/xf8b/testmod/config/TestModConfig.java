package io.github.xf8b.testmod.config;

import io.github.xf8b.testmod.TestMod;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;

@Config(name = TestMod.MOD_ID)
public class TestModConfig implements ConfigData {
    boolean doSomeStuff;
    int timesSomeStuffShouldBeDone;

    StuffToBeDone stuffToBeDone = StuffToBeDone.EAT_BEANS;

    private enum StuffToBeDone {
        EAT_BEANS,
        SLEEP
    }
}
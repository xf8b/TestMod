package io.github.xf8b.testmod.rrp;

import io.github.xf8b.testmod.TestMod;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RRPPreGenEntrypoint;
import net.devtech.arrp.api.RuntimeResourcePack;

import static net.devtech.arrp.api.RuntimeResourcePack.id;
import static net.devtech.arrp.json.lang.JLang.lang;

public class TestModRRPPreGenEntryPoint implements RRPPreGenEntrypoint {
    public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create(TestMod.MOD_ID + ":resources");

    @Override
    public void pregen() {
        RESOURCE_PACK.addLang(id(TestMod.MOD_ID, "en_us.json"), lang()
                .translate("config." + TestMod.MOD_ID + ".title", "TestMod Config")
                .translate("config." + TestMod.MOD_ID + ".category.main.title", "Main Category"));
        RRPCallback.EVENT.register(resources -> resources.add(RESOURCE_PACK));
    }
}

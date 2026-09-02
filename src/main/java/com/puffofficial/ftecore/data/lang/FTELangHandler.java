package com.puffofficial.ftecore.data.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class FTELangHandler {

    public static void init(RegistrateLangProvider provider) {
        provider.add("gtfte.components.ulv_machine", "§7It's a primitive machine, recipes take twice as long.");
        provider.add("gtfte.components.primitive_maintenance", "§7Simple hatch for Primitive multiblock maintenance.");
    }
}

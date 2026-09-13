package com.puffofficial.ftecore.data.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class FTELangHandler {

    public static void init(RegistrateLangProvider provider) {
        provider.add("fte.components.ulv_machine", "§7It's a primitive machine, recipes take twice as long.");
        provider.add("fte.components.primitive_maintenance", "§7Simple hatch for Primitive multiblock maintenance.");
        provider.add("fte.components.hydrokinetic_dynamo", "§7Can only accept water through pipes.");

        provider.add("fte.components.ulv_multiblock", "§7This machine can't accept energy hatches higher than ULV.");
        provider.add("fte.components.ulv_multiblock_parallels",
                "§7This machine can process up to %s§7 recipes at once, if overclocked to §fLV§r.");

        provider.add("gtceu.hydrokinetic_dynamo", "Hydrokinetic Dynamo");

        provider.add("tagprefix.bedrock", "Bedrock %s Ore");
    }
}

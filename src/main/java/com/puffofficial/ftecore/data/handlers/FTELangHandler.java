package com.puffofficial.ftecore.data.handlers;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class FTELangHandler {

    public static void init(RegistrateLangProvider provider) {
        // ULV tooltips
        provider.add("fte.components.ulv_machine", "§7It's a primitive machine, recipes take twice as long.");
        provider.add("fte.components.primitive_maintenance", "§7Simple hatch for Primitive multiblock maintenance.");
        provider.add("fte.components.hydrokinetic_dynamo", "§7Can only accept water through pipes.");
        // ULV multiblock tooltips
        provider.add("fte.components.ulv_multiblock", "§7This machine can't accept energy hatches higher than ULV.");
        provider.add("fte.components.ulv_multiblock_parallels",
                "§7This machine can process up to %s§7 recipes at once, if overclocked to §fLV§r.");
        // Multiblock Tooltips
        provider.add("fte.components.tooltip.alchemical_mixer", "§7Mixing magic stuff");
        provider.add("fte.components.tooltip.alchemical_separator", "§7Separating magic stuff, obviously");

        provider.add("fte.components.tooltip.default_parallels_without_eu",
                "§5Default Parallels:§r %s §7(No EU multiplier)§r");
        provider.add("fte.components.tooltip.default_parallels", "§5Default Parallels:§r %s §7(With EU multiplier)§r");
        // Multiblock Data
        provider.add("fte.components.display.temperature", "Max Temperature: %sK");

        provider.add("fte.components.display.error_temp_low", "Temperature too low");
        provider.add("fte.components.display.error_temp_high", "Temperature too high");
        // Recipe Data
        provider.add("fte.components.data.temperature_range",
                "Temp: <grad from=#5fff54 to=#d0e864 hue uni>%s</grad>K - <grad from=#ff8254 to=#9e1818 hue sp=5.0 uni>%s</grad>K");
        // Recipes
        provider.add("gtceu.hydrokinetic_dynamo", "Hydrokinetic Dynamo");
        // Tagprefixes
        provider.add("tagprefix.fuel_rod", "%s Fuel Rod");
    }
}

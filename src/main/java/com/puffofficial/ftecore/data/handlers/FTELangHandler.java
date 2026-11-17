package com.puffofficial.ftecore.data.handlers;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class FTELangHandler {

    public static void init(RegistrateLangProvider provider) {
        // Item Tooltips
        provider.add("fte.components.tooltip.circuit_type.certus", "Tier %s Certus Circuit");
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
                "Temp: <grad from=#5fff54 to=#d0e864 sp=5.0>%s</grad>K - <grad from=#ff8254 to=#9e1818 sp=5.0>%s</grad>K");
        // Recipes
        provider.add("gtceu.hydrokinetic_dynamo", "Hydrokinetic Dynamo");
        provider.add("gtceu.alchemical_crucible", "Alchemical Crucible");
        provider.add("gtceu.alchemical_mixer", "Alchemical Mixer");
        provider.add("gtceu.alchemical_separator", "Alchemical Separator");
        // Tagprefixes
        provider.add("tagprefix.fuel_rod", "%s Fuel Rod");
        // Circuit tooltips
        multilineLang(provider, "item.ftecore.certus_chip.tooltip",
                "§7No, it's not made out of C₆H₁₂N₄\n§bTier I Certus Circuit");
        multilineLang(provider, "item.ftecore.basic_certus_circuit.tooltip",
                "§7Maybe can process something\n§bTier II Certus Circuit");
        multilineLang(provider, "item.ftecore.good_certus_circuit.tooltip",
                "§7Can't run Doom\n§bTier III Certus Circuit");
        multilineLang(provider, "item.ftecore.advanced_certus_circuit.tooltip",
                "§7Still can't run Doom\n§bTier IV Certus Circuit");

        multilineLang(provider, "item.ftecore.fluix_chip.tooltip",
                "§7Same chip but with purple crystals now\n§5Tier II Certus Circuit");
        multilineLang(provider, "item.ftecore.basic_fluix_circuit.tooltip",
                "§7Maybe can process something\n§5Tier III Certus Circuit");
        multilineLang(provider, "item.ftecore.advanced_fluix_circuit.tooltip",
                "§7Can run Doom\n§5Tier IV Certus Circuit");
        multilineLang(provider, "item.ftecore.fluix_mainframe.tooltip",
                "§7Computing Autocrafts\n§5Tier V Certus Circuit");
    }

    protected static String getSubKey(String key, int index) {
        return key + "." + index;
    }

    protected static void multiLang(RegistrateLangProvider provider, String key, String... values) {
        for (var i = 0; i < values.length; i++) {
            provider.add(getSubKey(key, i), values[i]);
        }
    }

    protected static void multilineLang(RegistrateLangProvider provider, String key, String multiline) {
        var lines = multiline.split("\n");
        multiLang(provider, key, lines);
    }
}

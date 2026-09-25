package com.puffofficial.ftecore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.common.data.GTElements;

public class FTEElements {

    public static Element Nocturium;
    public static Element Mana, Elementium, Terrasteel;
    public static Element Infinity;

    public static void init() {
        Nocturium = GTElements.createAndRegister(157, 157, -1, "nocturium", "nocturium", "Nc", false);

        Mana = GTElements.createAndRegister(34, 4, -1, "mana", "mana", "ᛗ", false);
        Elementium = GTElements.createAndRegister(34, 4, -1, "elementium", "elementium", "ᛗ*", true);
        Terrasteel = GTElements.createAndRegister(34, 4, -1, "terrasteel", "terrasteel", "ᛗ+", true);

        Infinity = GTElements.createAndRegister(999, 999, -1, "infinity", "infinity", "∞", true);
    }
}

package com.puffofficial.ftecore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.common.data.GTElements;

public class FTEElement {

    public static Element FLATTIUM;

    public static void init() {
        FLATTIUM = GTElements.createAndRegister(15, 3, -1, "puff_gem", "flattium", "Pu", false);
    }
}

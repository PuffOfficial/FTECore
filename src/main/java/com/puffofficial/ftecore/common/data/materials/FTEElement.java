package com.puffofficial.ftecore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.common.data.GTElements;

public class FTEElement {

    public static Element Nocturium;

    public static void init() {
        Nocturium = GTElements.createAndRegister(157, 157, -1, "nocturium", "nocturium", "Nc", false);
    }
}

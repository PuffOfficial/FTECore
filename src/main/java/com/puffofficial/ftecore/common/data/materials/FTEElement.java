package com.puffofficial.ftecore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.common.data.GTElements;

public class FTEElement {
    public static Element HEISENBERGIUM;

    public static void init() {
        HEISENBERGIUM = GTElements.createAndRegister(15,3,-1,"puff_gem","heisenbergium","Meth",false);
    }
}

package com.puffofficial.ftecore.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;

import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.common.data.FTECreativeModeTabs;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;

public class FTEMaterials {

    static {
        FTECore.FTERegister.creativeModeTab(() -> FTECreativeModeTabs.MATERIALS);
    }

    public static Material PUFF_STEEL, PUFF_GEM, LEGALLY_MORAL;

    public static void init() {
        PUFF_STEEL = new Material.Builder(FTECore.id("puff_steel"))
                .ingot()
                .color(0xccccff)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_DENSE)
                .buildAndRegister();
        PUFF_GEM = new Material.Builder(FTECore.id("puff_gem"))
                .gem()
                .color(0xccccff)
                .iconSet(MaterialIconSet.LAPIS)
                .flags(GENERATE_PLATE, GENERATE_ROD)
                .buildAndRegister();
        LEGALLY_MORAL = new Material.Builder(FTECore.id("legally_moral"))
                .dust()
                .color(0x80bfff)
                .secondaryColor(0xe6f2ff)
                .iconSet(MaterialIconSet.DULL)
                .element(FTEElement.FLATTIUM)
                .buildAndRegister();
    }
}

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

    public static Material Ceramic;
    public static Material LivingSteel, VerdantCopper, RootIron;

    public static void init() {
        Ceramic = new Material.Builder(FTECore.id("ceramic"))
                .ingot()
                .color(0x9b6045).secondaryColor(0x83513c)
                .iconSet(FTEIconsets.CERAMIC)
                .flags(GENERATE_PLATE,DISABLE_MATERIAL_RECIPES)
                .buildAndRegister();

        LivingSteel = new Material.Builder(FTECore.id("living_steel"))
                .ingot()
                .color(0x244120).secondaryColor(0x3d3d3d)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_PLATE)
                .formula("Fe")
                .buildAndRegister();
        VerdantCopper = new Material.Builder(FTECore.id("verdant_copper"))
                .ingot()
                .color(0x7eea73).secondaryColor(0x244120)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(GENERATE_PLATE,GENERATE_FINE_WIRE)
                .formula("Cu(C6H10O5)2")
                .buildAndRegister();
        RootIron = new Material.Builder(FTECore.id("root_iron"))
                .ingot()
                .color(0xa98c54).secondaryColor(0x2f2718)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_PLATE)
                .formula("Fe(C6H10O5)2")
                .buildAndRegister();
    }
}

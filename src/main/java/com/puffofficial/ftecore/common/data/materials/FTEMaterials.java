package com.puffofficial.ftecore.common.data.materials;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;

import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.common.data.FTECreativeModeTabs;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty.*;
import static com.puffofficial.ftecore.api.materials.MaterialFlags.*;

public class FTEMaterials {

    static {
        FTECore.FTERegister.creativeModeTab(() -> FTECreativeModeTabs.MATERIALS);
    }

    public static Material Ceramic, AndesiteAlloy, Nocturium;
    public static Material LivingSteel, VerdantCopper, RootIron;
    public static Material RadiationResistantAlloy, TitaniumNoctite, StargateAlloy, SiliconCarbide;

    public static void init() {
        Ceramic = new Material.Builder(FTECore.id("ceramic"))
                .ingot()
                .color(0x9b6045).secondaryColor(0x83513c)
                .iconSet(FTEIconsets.CERAMIC)
                .flags(GENERATE_PLATE, DISABLE_MATERIAL_RECIPES)
                .buildAndRegister();
        AndesiteAlloy = new Material.Builder(FTECore.id("andesite_alloy"))
                .ingot()
                .color(0x6a6a6a).secondaryColor(0x4b5f4f)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .formula("ZnFe2(Mg3Si2H4O9)4(KNO3)")
                .components(Zinc, 1, Iron, 2, Andesite, 2)
                .buildAndRegister();

        Nocturium = new Material.Builder(FTECore.id("nocturium"))
                .ingot()
                .color(0x00f7e5).secondaryColor(0x171717)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, FUEL_ROD)
                .formula("Nc")
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
                .flags(GENERATE_PLATE, GENERATE_FINE_WIRE)
                .formula("Cu(C6H10O5)2")
                .buildAndRegister();
        RootIron = new Material.Builder(FTECore.id("root_iron"))
                .ingot()
                .color(0xa98c54).secondaryColor(0x2f2718)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_PLATE)
                .formula("Fe(C6H10O5)2")
                .buildAndRegister();

        RadiationResistantAlloy = new Material.Builder(FTECore.id("radiation_resistant_alloy"))
                .ingot()
                .liquid()
                .color(0x7e6f82).secondaryColor(0x355e67).iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_PLATE,GENERATE_FRAME,GENERATE_ROD)
                .formula("WNiCu")
                .components(Tungsten, 1, Nickel, 1, Copper, 1)
                .buildAndRegister();
        TitaniumNoctite = new Material.Builder(FTECore.id("titanium_noctite"))
                .ingot()
                .blastTemp(4800, GasTier.HIGH, GTValues.VA[GTValues.EV], 780)
                .color(0x402e55).secondaryColor(0x130c1b).iconSet(MaterialIconSet.DULL)
                .flags(GENERATE_PLATE,GENERATE_FRAME,GENERATE_ROD)
                .formula("TiNc2")
                .components(Nocturium, 2, Titanium, 1)
                .buildAndRegister();
    }
}

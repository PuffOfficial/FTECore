package com.puffofficial.ftecore.common.data.materials;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;

import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.common.data.FTECreativeModeTabs;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.puffofficial.ftecore.api.materials.MaterialFlags.*;
import static com.puffofficial.ftecore.common.data.materials.lines.BotaniaMaterials.*;

public class FTEMaterials {

    static {
        FTECore.FTERegister.creativeModeTab(() -> FTECreativeModeTabs.MATERIALS);
    }

    public static Material Ceramic, AndesiteAlloy, Nocturium;
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

        RadiationResistantAlloy = new Material.Builder(FTECore.id("radiation_resistant_alloy"))
                .ingot()
                .liquid()
                .color(0x7e6f82).secondaryColor(0x355e67).iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_PLATE, GENERATE_FRAME, GENERATE_ROD)
                .formula("WNiCu")
                .components(Tungsten, 1, Nickel, 1, Copper, 1)
                .buildAndRegister();
        TitaniumNoctite = new Material.Builder(FTECore.id("titanium_noctite"))
                .ingot()
                .blastTemp(4800, GasTier.HIGH, GTValues.VA[GTValues.EV], 780)
                .color(0x402e55).secondaryColor(0x130c1b).iconSet(MaterialIconSet.DULL)
                .flags(GENERATE_PLATE, GENERATE_FRAME, GENERATE_ROD)
                .formula("TiNc2")
                .components(Nocturium, 2, Titanium, 1)
                .buildAndRegister();
        StargateAlloy = new Material.Builder(FTECore.id("stargate_alloy"))
                .ingot()
                .color(0x8eb2ba).secondaryColor(0x355e67).iconSet(MaterialIconSet.METALLIC)
                .blastTemp(3600, GasTier.MID, GTValues.VA[GTValues.EV], 1300)
                .flags(GENERATE_PLATE, GENERATE_FRAME, GENERATE_ROD, GENERATE_SMALL_GEAR, GENERATE_DENSE)
                .components(Titanium, 2, Molybdenum, 1, Steel, 12, Manasteel, 2)
                .buildAndRegister();
        SiliconCarbide = new Material.Builder(FTECore.id("silicon_carbide"))
                .ingot()
                .color(0x5b5b5b).secondaryColor(0x3c4952).iconSet(MaterialIconSet.DULL)
                .blastTemp(1200, GasTier.LOW, GTValues.VA[GTValues.LV], 400)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_DENSE)
                .components(Silicon, 1, Carbon, 1)
                .buildAndRegister();
    }
}

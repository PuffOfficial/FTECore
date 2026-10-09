package com.puffofficial.ftecore.common.materials;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.ToolProperty;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;

import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.common.data.FTECreativeModeTabs;
import com.puffofficial.ftecore.common.data.FTEItems;
import committee.nova.mods.avaritia.init.registry.ModBlocks;
import committee.nova.mods.avaritia.init.registry.ModItems;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.puffofficial.ftecore.api.materials.MaterialFlags.*;
import static com.puffofficial.ftecore.common.materials.lines.BotaniaMaterials.*;

public class FTEMaterials {

    static {
        FTECore.FTERegister.creativeModeTab(() -> FTECreativeModeTabs.MATERIALS);
    }

    public static Material Ceramic, Nocturium, Infinity, ArtificialAmethyst, Unbreakium;
    public static Material AndesiteAlloy, RadiationResistantAlloy, TitaniumNoctite, StargateAlloy, SiliconCarbide;
    public static Material Pyrotheum, Cryotheum, Aerotheum, Petrotheum;
    public static Material Thaumium, AlchemicalBronze, VoidMetal;

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
        ArtificialAmethyst = new Material.Builder(FTECore.id("artificial_amethyst"))
                .gem()
                .color(0xc796f6).secondaryColor(0x7a3f7f).iconSet(MaterialIconSet.RUBY)
                .flags(GENERATE_PLATE)
                .formula("(SiO2)4Fe")
                .buildAndRegister();
        Nocturium = new Material.Builder(FTECore.id("nocturium"))
                .ingot()
                .color(0x00f7e5).secondaryColor(0x171717)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, FUEL_ROD)
                .element(FTEElements.Nocturium)
                .buildAndRegister();
        Unbreakium = new Material.Builder(FTECore.id("unbreakium"))
                .ingot()
                .langValue("<neon p=8 r=2 a=0.15><grad from=#744a92 to=#1E90FF hue uni>Unbreakable™</grad></neon>")
                .color(0x744a92).secondaryColor(0x000000)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_MATERIAL_RECIPES)
                .toolStats(ToolProperty.Builder
                        .of(1.8F, 1.7F, 65535, 3, GTToolType.WRENCH, GTToolType.SCREWDRIVER, GTToolType.WIRE_CUTTER,
                                GTToolType.CROWBAR)
                        .magnetic().unbreakable().build())
                .buildAndRegister();

        Infinity = new Material.Builder(FTECore.id("infinity"))
                .ingot()
                .iconSet(FTEIconsets.INFINITY)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_DENSE, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .element(FTEElements.Infinity)
                .buildAndRegister();
        ingot.setIgnored(Infinity, ModItems.infinity_ingot);
        nugget.setIgnored(Infinity, ModItems.infinity_nugget);
        block.setIgnored(Infinity, ModBlocks.infinity);
        plate.setIgnored(Infinity, () -> FTEItems.INFINITY_PLATE);
        plateDouble.setIgnored(Infinity, () -> FTEItems.INFINITY_DOUBLE_PLATE);
        rod.setIgnored(Infinity, () -> FTEItems.INFINITY_ROD);
        gear.setIgnored(Infinity, () -> FTEItems.INFINITY_GEAR);
        gearSmall.setIgnored(Infinity, () -> FTEItems.INFINITY_SMALL_GEAR);
        dust.setIgnored(Infinity, () -> FTEItems.INFINITY_DUST);
        dustSmall.setIgnored(Infinity, () -> FTEItems.INFINITY_SMALL_DUST);
        dustTiny.setIgnored(Infinity, () -> FTEItems.INFINITY_TINY_DUST);
        bolt.setIgnored(Infinity, () -> FTEItems.INFINITY_BOLT);
        screw.setIgnored(Infinity, () -> FTEItems.INFINITY_SCREW);
        ring.setIgnored(Infinity, () -> FTEItems.INFINITY_RING);
        plateDense.setIgnored(Infinity, () -> FTEItems.INFINITY_DENSE_PLATE);

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

        Pyrotheum = new Material.Builder(FTECore.id("pyrotheum"))
                .dust()
                .liquid()
                .color(0xfed14b).secondaryColor(0xfe874b).iconSet(FTEIconsets.PRIMAL)
                .ignoredTagPrefixes(dustSmall, dustTiny)
                .langValue("<grad from=#ff8742 to=#ffbd42 hue uni>Blazing Pyrotheum</grad>")
                .buildAndRegister();
        Cryotheum = new Material.Builder(FTECore.id("cryotheum"))
                .dust()
                .liquid()
                .color(0xb6e7ff).secondaryColor(0x59b4e2).iconSet(FTEIconsets.PRIMAL)
                .ignoredTagPrefixes(dustSmall, dustTiny)
                .langValue("<grad from=#54d7ff to=#5496ff hue uni>Gelid Cryotheum</grad>")
                .buildAndRegister();
        Aerotheum = new Material.Builder(FTECore.id("aerotheum"))
                .dust()
                .liquid()
                .color(0xffed89).secondaryColor(0xe1dca0).iconSet(FTEIconsets.PRIMAL)
                .ignoredTagPrefixes(dustSmall, dustTiny)
                .langValue("<grad from=#a8a04a to=#fff694 hue uni>Zypherean Aerotheum</grad>")
                .buildAndRegister();
        Petrotheum = new Material.Builder(FTECore.id("petrotheum"))
                .dust()
                .liquid()
                .color(0xffed89).secondaryColor(0xe1dca0).iconSet(FTEIconsets.PRIMAL)
                .ignoredTagPrefixes(dustSmall, dustTiny)
                .langValue("<grad from=#261e1b to=#2e2e2e hue uni>Tectonic Petrotheum</grad>")
                .buildAndRegister();

        AlchemicalBronze = new Material.Builder(FTECore.id("alchemical_bronze"))
                .ingot()
                .iconSet(MaterialIconSet.BRIGHT)
                .color(0xe6ab7d).secondaryColor(0x6a3d39).langValue("Alchemical Bronze")
                .flags(GENERATE_PLATE, GENERATE_DENSE, GENERATE_FOIL, GENERATE_ROD, GENERATE_RING)
                .buildAndRegister();
        Thaumium = new Material.Builder(FTECore.id("thaumium"))
                .ingot()
                .iconSet(MaterialIconSet.METALLIC)
                .color(0x7d6694).secondaryColor(0x4c2f69).langValue("Thaumium")
                .flags(GENERATE_PLATE,
                        GENERATE_ROD,
                        GENERATE_FINE_WIRE,
                        GENERATE_FOIL,
                        GENERATE_FRAME,
                        GENERATE_ROTOR,
                        GENERATE_RING,
                        GENERATE_SMALL_GEAR,
                        GENERATE_GEAR,
                        GENERATE_SPRING,
                        GENERATE_BOLT_SCREW,
                        GENERATE_ROUND)
                .buildAndRegister();

        VoidMetal = new Material.Builder(FTECore.id("void_metal"))
                .ingot()
                .iconSet(MaterialIconSet.METALLIC)
                .color(0x2f1d40).secondaryColor(0x000000).langValue("Void Metal")
                .flags(GENERATE_PLATE, GENERATE_DENSE, GENERATE_FOIL, GENERATE_ROD, GENERATE_RING)
                .buildAndRegister();
    }
}

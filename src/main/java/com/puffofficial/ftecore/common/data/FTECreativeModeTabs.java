package com.puffofficial.ftecore.common.data;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;

import net.minecraft.world.item.CreativeModeTab;

import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.common.data.materials.FTEMaterials;
import com.puffofficial.ftecore.common.machine.FTEPrimitiveMachines;
import com.tterrag.registrate.util.entry.RegistryEntry;

public class FTECreativeModeTabs {

    // Machines
    public static RegistryEntry<CreativeModeTab> FTE_MACHINE_CREATIVE_TAB = FTECore.FTERegister
            .defaultCreativeTab(FTECore.MOD_ID,
                    builder -> builder
                            .displayItems(
                                    new GTCreativeModeTabs.RegistrateDisplayItemsGenerator(FTECore.MOD_ID,
                                            FTECore.FTERegister))
                            .title(FTECore.FTERegister.addLang("itemGroup", FTECore.id("creative_tab"),
                                    "Flatter Than Ever: Machines"))
                            .icon(FTEPrimitiveMachines.PRIMITIVE_POLARIZER[GTValues.ULV]::asStack)
                            .build())
            .register();
    // Materials
    public static RegistryEntry<CreativeModeTab> FTE_MATERIAL_CREATIVE_TAB = FTECore.FTERegister
            .defaultCreativeTab(FTECore.MOD_ID,
                    builder -> builder
                            .displayItems(
                                    new GTCreativeModeTabs.RegistrateDisplayItemsGenerator(FTECore.MOD_ID,
                                            FTECore.FTERegister))
                            .title(FTECore.FTERegister.addLang("itemGroup", FTECore.id("creative_tab"),
                                    "Flatter Than Ever: Materials"))
                            .icon(() -> ChemicalHelper.get(TagPrefix.ingot, FTEMaterials.PUFF_STEEL))
                            .build())
            .register();
    // Blocks
    public static RegistryEntry<CreativeModeTab> FTE_BLOCK_CREATIVE_TAB = FTECore.FTERegister
            .defaultCreativeTab(FTECore.MOD_ID,
                    builder -> builder
                            .displayItems(
                                    new GTCreativeModeTabs.RegistrateDisplayItemsGenerator(FTECore.MOD_ID,
                                            FTECore.FTERegister))
                            .title(FTECore.FTERegister.addLang("itemGroup", FTECore.id("creative_tab"),
                                    "Flatter Than Ever: Blocks"))
                            .icon(FTEBlocks.SOLID_WROUGHT_IRON_CASING::asStack)
                            .build())
            .register();

    public static void init() {}
}

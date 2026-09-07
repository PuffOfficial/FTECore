package com.puffofficial.ftecore.common.data;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs.*;

import net.minecraft.world.item.CreativeModeTab;

import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.common.data.materials.FTEMaterials;
import com.puffofficial.ftecore.common.machine.FTEPrimitiveMachines;
import com.tterrag.registrate.util.entry.RegistryEntry;

public class FTECreativeModeTabs {

    // Materials
    public static RegistryEntry<CreativeModeTab> MATERIALS = FTECore.FTERegister.defaultCreativeTab("fte_materials",
            builder -> builder
                    .displayItems(
                            new RegistrateDisplayItemsGenerator("fte_materials", FTECore.FTERegister))
                    .icon(
                            () -> ChemicalHelper.get(TagPrefix.ingot, FTEMaterials.PUFF_STEEL))
                    .title(FTECore.FTERegister.addLang(
                            "itemGroup", FTECore.id("materials"),
                            "Flatter Than Ever: Materials"))
                    .build())
            .register();
    // Machines
    public static RegistryEntry<CreativeModeTab> MACHINES = FTECore.FTERegister.defaultCreativeTab("fte_machines",
            builder -> builder
                    .displayItems(
                            new RegistrateDisplayItemsGenerator("fte_machines", FTECore.FTERegister))
                    .icon(
                            () -> FTEPrimitiveMachines.PRIMITIVE_POLARIZER[GTValues.ULV].asStack())
                    .title(FTECore.FTERegister.addLang(
                            "itemGroup", FTECore.id("machines"),
                            "Flatter Than Ever: Machines"))
                    .build())
            .register();
    // Blocks
    public static RegistryEntry<CreativeModeTab> BLOCKS = FTECore.FTERegister.defaultCreativeTab("fte_blocks",
            builder -> builder
                    .displayItems(
                            new RegistrateDisplayItemsGenerator("fte_blocks", FTECore.FTERegister))
                    .icon(
                            FTEBlocks.SOLID_WROUGHT_IRON_CASING::asStack)
                    .title(FTECore.FTERegister.addLang(
                            "itemGroup", FTECore.id("blocks"),
                            "Flatter Than Ever: Blocks"))
                    .build())
            .register();

    public static void init() {}
}

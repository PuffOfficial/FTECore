package com.puffofficial.ftecore.common.machine.multiblock;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.models.GTMachineModels;

import net.minecraft.world.level.block.Blocks;

import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.api.machine.multiblock.FTEPartAbility;
import com.puffofficial.ftecore.common.data.FTEBlocks;
import com.puffofficial.ftecore.common.data.FTECreativeModeTabs;
import com.puffofficial.ftecore.common.machine.FTERecipeTypes;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class FTEMultiblocks {

    static {
        FTECore.FTERegister.creativeModeTab(() -> FTECreativeModeTabs.MACHINES);
    }

    public static MultiblockMachineDefinition LARGE_BARREl = FTECore.FTERegister
            .multiblock("large_barrel", WorkableElectricMultiblockMachine::new)
            .langValue("Industrial-Size Treated Wood Barrel")
            .recipeType(FTERecipeTypes.LARGE_BARREL)
            .recipeModifiers()
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(GTBlocks.TREATED_WOOD_PLANK)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("RRR", "F#F", "F#F", "F#F")
                    .aisle("RRR", "# #", "# #", "# #")
                    .aisle("RRR", "FCF", "F#F", "F#F")
                    .where("C", Predicates.controller(Predicates.blocks(definition.get())))
                    .where("#", Predicates.blocks(GTBlocks.TREATED_WOOD_PLANK.get())
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setMaxGlobalLimited(1)
                                    .setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setMaxGlobalLimited(1)
                                    .setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setMaxGlobalLimited(1)
                                    .setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setMaxGlobalLimited(1)
                                    .setPreviewCount(1)))
                    .where("R", Predicates.blocks(GTBlocks.CASING_PUMP_DECK.get()))
                    .where("F", Predicates.blocks(ChemicalHelper.getBlock(frameGt, TreatedWood)))
                    .where(" ", Predicates.any())
                    .build())
            .model(
                    GTMachineModels.createWorkableCasingMachineModel(
                            GTCEu.id("block/treated_wood_planks"),
                            GTCEu.id("block/machines/brewery")))
            .register();

    public static MultiblockMachineDefinition LARGE_CRUCIBLE = FTECore.FTERegister
            .multiblock("large_crucible", WorkableElectricMultiblockMachine::new)
            .langValue("Industrial-Size Melting Crucible")
            .recipeType(FTERecipeTypes.LARGE_CRUCIBLE)
            .recipeModifiers()
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(GTBlocks.TREATED_WOOD_PLANK)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("a   a", "ccccc", "d e d", "deeed", "aevea", " eee ", "  e  ", "     ")
                    .aisle("     ", "c e c", " e e ", "e   e", "e   e", "e   e", " e e ", "  e  ")
                    .aisle("     ", "ceeec", "e   e", "e   e", "v   v", "e   e", "e   e", " efe ")
                    .aisle("     ", "c e c", " e e ", "e   e", "e   e", "e   e", " e e ", "  e  ")
                    .aisle("a   a", "ccccc", "d e d", "deeed", "aeOea", " eee ", "  e  ", "     ")
                    .where("O", Predicates.controller(Predicates.blocks(definition.get())))
                    .where("a", Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get()))
                    .where("c", Predicates.blocks(GTBlocks.STEEL_HULL.get()))
                    .where("d", Predicates.blocks(ChemicalHelper.getBlock(frameGt, Steel)))
                    .where("e", Predicates.blocks(FTEBlocks.PORCELAIN_BRICKS.get())
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setExactLimit(1).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setExactLimit(1).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setExactLimit(1).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setExactLimit(1).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setMaxGlobalLimited(2)
                                    .setPreviewCount(1)))
                    .where("v", Predicates.abilities(FTEPartAbility.VENTIlATION))
                    .where("f", Predicates.abilities(PartAbility.MUFFLER))
                    .where(" ", Predicates.any())
                    .build())
            .model(
                    GTMachineModels.createWorkableCasingMachineModel(
                            FTECore.id("block/porcelain_bricks"),
                            GTCEu.id("block/multiblock/primitive_blast_furnace")))
            .register();

    public static MultiblockMachineDefinition DAYCYCLE_SIMULATION_CHAMBER = FTECore.FTERegister
            .multiblock("daycycle_simulation_chamber", WorkableElectricMultiblockMachine::new)
            .langValue("Daycycle Simulation Chamber")
            .recipeType(FTERecipeTypes.DAYCYCLE_SIMULATION_CHAMBER)
            .recipeModifiers()
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("###", "#R#", "#R#", "#R#", "###")
                    .aisle("###", "RGR", "RSR", "R R", "#V#")
                    .aisle("#C#", "#R#", "#R#", "#R#", "###")
                    .where("C", Predicates.controller(Predicates.blocks(definition.get())))
                    .where("#", Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setMaxGlobalLimited(1)
                                    .setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setMaxGlobalLimited(1)
                                    .setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setMaxGlobalLimited(1)
                                    .setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.MAINTENANCE).setExactLimit(1).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.PARALLEL_HATCH).setMaxGlobalLimited(1))
                            .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setMaxGlobalLimited(1)
                                    .setPreviewCount(1)))
                    .where("R", Predicates.blocks(GTBlocks.CASING_TEMPERED_GLASS.get()))
                    .where("V", Predicates.abilities(FTEPartAbility.VENTIlATION))
                    .where("G", Predicates.blocks(Blocks.GRASS_BLOCK)
                            .or(Predicates.blocks(Blocks.DIRT)))
                    .where("S", Predicates.blocks(Blocks.OAK_SAPLING)
                            .or(Predicates.blocks(Blocks.SPRUCE_SAPLING))
                            .or(Predicates.blocks(Blocks.ACACIA_SAPLING))
                            .or(Predicates.blocks(Blocks.JUNGLE_SAPLING))
                            .or(Predicates.blocks(Blocks.CHERRY_SAPLING))
                            .or(Predicates.blocks(Blocks.DARK_OAK_SAPLING))
                            .or(Predicates.blocks(Blocks.BIRCH_SAPLING)))
                    .where(" ", Predicates.air())
                    .build())
            .model(
                    GTMachineModels.createWorkableCasingMachineModel(
                            GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                            FTECore.id("block/multiblock/daycycle_simulation_chamber")))
            .register();

    public static void init() {}
}

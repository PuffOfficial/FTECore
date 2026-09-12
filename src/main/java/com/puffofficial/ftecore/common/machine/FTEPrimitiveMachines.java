package com.puffofficial.ftecore.common.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.SimpleGeneratorMachine;
import com.gregtechceu.gtceu.api.machine.SimpleTieredMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.models.GTMachineModels;

import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;

import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.api.machine.multiblock.FTEPartAbility;
import com.puffofficial.ftecore.common.data.FTEBlocks;
import com.puffofficial.ftecore.common.data.FTECreativeModeTabs;
import com.puffofficial.ftecore.common.data.FTERecipeModifiers;
import com.puffofficial.ftecore.common.data.FTETooltips;
import com.puffofficial.ftecore.common.machine.multiblock.part.PrimitiveMaintenanceHatchPartMachine;
import com.puffofficial.ftecore.data.models.FTEMachineModels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.pattern.Predicates.blocks;
import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.*;
import static com.puffofficial.ftecore.common.machine.MachineUtils.*;

public class FTEPrimitiveMachines {

    static {
        FTECore.FTERegister.creativeModeTab(() -> FTECreativeModeTabs.MACHINES);
    }

    private static MachineDefinition registerPrimitiveMachine(String Name, String Id, GTRecipeType RecipeType) {
        List<Component> components = new ArrayList<>();
        components.add(Component.translatable("fte.components.ulv_machine"));
        components.addAll(Arrays.asList(workableTiered(GTValues.ULV, V[GTValues.ULV], V[GTValues.ULV] * 64, RecipeType,
                defaultTankSizeFunction.applyAsInt(GTValues.ULV), true)));

        return FTECore.FTERegister
                .machine("ulv_" + Id,
                        (holder) -> new SimpleTieredMachine(holder, GTValues.ULV, defaultTankSizeFunction))
                .langValue("§8Primitive " + Name)
                .editableUI(SimpleTieredMachine.EDITABLE_UI_CREATOR.apply(GTCEu.id(Id),
                        RecipeType))
                .rotationState(RotationState.NON_Y_AXIS)
                .tooltips(components)
                .recipeType(RecipeType)
                .workableTieredHullModel(GTCEu.id("block/machines/" + Id))
                .tier(GTValues.ULV)
                .register();
    }

    private static MachineDefinition registerPrimitiveGenerator(String Name, String Id, GTRecipeType RecipeType) {
        List<Component> components = new ArrayList<>();
        components.add(Component.translatable("fte.components.hydrokinetic_dynamo"));
        components.addAll(Arrays.asList(workableTiered(GTValues.ULV, V[GTValues.ULV], V[GTValues.ULV] * 64, RecipeType,
                defaultTankSizeFunction.applyAsInt(GTValues.ULV), false)));

        return FTECore.FTERegister
                .machine("ulv_" + Id,
                        (holder) -> new SimpleGeneratorMachine(holder, GTValues.ULV, defaultTankSizeFunction))
                .langValue("§8Primitive " + Name)
                .rotationState(RotationState.NON_Y_AXIS)
                .tooltips(components)
                .recipeType(RecipeType)
                .workableTieredHullModel(FTECore.id("block/machines/" + Id))
                .tier(GTValues.ULV)
                .register();
    }

    public static MachineDefinition PRIMITIVE_EXTRACTOR = registerPrimitiveMachine("Extractor", "extractor",
            GTRecipeTypes.EXTRACTOR_RECIPES);
    public static MachineDefinition PRIMITIVE_ASSEMBLER = registerPrimitiveMachine("Assembler", "assembler",
            GTRecipeTypes.ASSEMBLER_RECIPES);
    public static MachineDefinition PRIMITIVE_ARC_FURNACE = registerPrimitiveMachine("Arc Furnace",
            "arc_furnace", GTRecipeTypes.ARC_FURNACE_RECIPES);
    public static MachineDefinition PRIMITIVE_WIREMILL = registerPrimitiveMachine("Wiremill", "wiremill",
            GTRecipeTypes.WIREMILL_RECIPES);
    public static MachineDefinition PRIMITIVE_POLARIZER = registerPrimitiveMachine("Polarizer", "polarizer",
            GTRecipeTypes.POLARIZER_RECIPES);
    public static MachineDefinition PRIMITIVE_ELECTROLYZER = registerPrimitiveMachine("Electrolyzer",
            "electrolyzer", GTRecipeTypes.ELECTROLYZER_RECIPES);
    public static MachineDefinition PRIMITIVE_EXTRUDER = registerPrimitiveMachine("Extruder", "extruder",
            GTRecipeTypes.EXTRUDER_RECIPES);
    public static MachineDefinition PRIMITIVE_FORGE_HAMMER = registerPrimitiveMachine("Forge Hammer",
            "forge_hammer", GTRecipeTypes.FORGE_HAMMER_RECIPES);
    public static MachineDefinition PRIMITIVE_MACERATOR = registerPrimitiveMachine("Macerator",
            "macerator", GTRecipeTypes.MACERATOR_RECIPES);
    public static MachineDefinition PRIMITIVE_SIFTER = registerPrimitiveMachine("Sifter",
            "sifter", GTRecipeTypes.SIFTER_RECIPES);
    public static MachineDefinition PRIMITIVE_COMPRESSOR = registerPrimitiveMachine("Compressor",
            "compressor", GTRecipeTypes.COMPRESSOR_RECIPES);

    public static final MachineDefinition PRIMITIVE_MAINTENANCE_HATCH = FTECore.FTERegister
            .machine("primitive_maintenance_hatch",
                    (blockEntity) -> new PrimitiveMaintenanceHatchPartMachine(blockEntity, true))
            .langValue("§8Primitive Maintenance Hatch")
            .rotationState(RotationState.ALL)
            .abilities(FTEPartAbility.PRIMITIVE_MAINTENANCE)
            .tooltips(Component.translatable("fte.components.primitive_maintenance"))
            .modelProperty(GTMachineModelProperties.IS_FORMED, false)
            .modelProperty(GTMachineModelProperties.IS_TAPED, false)
            .model(FTEMachineModels
                    .createPrimitiveMaintenanceModel(FTECore.id("block/machine/part/primitive_maintenance_hatch")))
            .tier(GTValues.ULV)
            .register();

    public static MachineDefinition PRIMITIVE_HYDROKINETIC_DYNAMO = registerPrimitiveGenerator("Hydrokinetic Dynamo",
            "hydrokinetic_dynamo", FTERecipeTypes.HYDROKINETIC_DYNAMO_TYPE);

    public static MultiblockMachineDefinition PRIMITIVE_BENDER = FTECore.FTERegister
            .multiblock("primitive_bender", WorkableElectricMultiblockMachine::new)
            .langValue("§8Primitive Bender")
            .recipeType(GTRecipeTypes.BENDER_RECIPES)
            .recipeModifiers(GTRecipeModifiers.OC_NON_PERFECT, FTERecipeModifiers::primitiveMultiblockLogic)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(FTEBlocks.SOLID_WROUGHT_IRON_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("RRRR", "####", "  # ")
                    .aisle("RRRR", "#  #", "####")
                    .aisle("RRRR", "##C#", "  # ")
                    .where("C", Predicates.controller(blocks(definition.get())))
                    .where("#", blocks(FTEBlocks.SOLID_WROUGHT_IRON_CASING.get())
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setMaxGlobalLimited(1)
                                    .setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setMaxGlobalLimited(1)
                                    .setPreviewCount(1))
                            .or(Predicates.abilities(FTEPartAbility.PRIMITIVE_MAINTENANCE).setExactLimit(1)
                                    .setPreviewCount(1))
                            .or(blocks(PartAbility.INPUT_ENERGY.getBlocks(GTValues.ULV).toArray(Block[]::new))
                                    .setMaxGlobalLimited(2).setPreviewCount(1)))
                    .where("R", blocks(FTEBlocks.WROUGHT_IRON_FIREBOX.get()))
                    .where(" ", Predicates.any())
                    .build())
            .model(
                    GTMachineModels.createWorkableCasingMachineModel(
                            FTECore.id("block/casings/solid/solid_wrought_iron_casing"),
                            GTCEu.id("block/machines/bender")))
            .tooltips(FTETooltips.primitiveMultiblockTooltips(4))
            .register();

    public static MultiblockMachineDefinition PRIMITIVE_ALLOY_SMELTER = FTECore.FTERegister
            .multiblock("primitive_alloy_smelter", WorkableElectricMultiblockMachine::new)
            .langValue("§8Primitive Alloy Smelter")
            .recipeType(GTRecipeTypes.ALLOY_SMELTER_RECIPES)
            .recipeModifiers(GTRecipeModifiers.OC_NON_PERFECT, FTERecipeModifiers::primitiveMultiblockLogic)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(FTEBlocks.SOLID_WROUGHT_IRON_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("RRR", "###", " # ")
                    .aisle("RRR", "# #", "###")
                    .aisle("RRR", "#C#", " # ")
                    .where("C", Predicates.controller(blocks(definition.get())))
                    .where("#", blocks(FTEBlocks.SOLID_WROUGHT_IRON_CASING.get())
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setMaxGlobalLimited(1)
                                    .setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setMaxGlobalLimited(1)
                                    .setPreviewCount(1))
                            .or(Predicates.abilities(FTEPartAbility.PRIMITIVE_MAINTENANCE).setExactLimit(1)
                                    .setPreviewCount(1))
                            .or(blocks(PartAbility.INPUT_ENERGY.getBlocks(GTValues.ULV).toArray(Block[]::new))
                                    .setMaxGlobalLimited(2).setPreviewCount(1)))
                    .where("R", blocks(FTEBlocks.WROUGHT_IRON_FIREBOX.get()))
                    .where(" ", Predicates.any())
                    .build())
            .model(
                    GTMachineModels.createWorkableCasingMachineModel(
                            FTECore.id("block/casings/solid/solid_wrought_iron_casing"),
                            GTCEu.id("block/machines/alloy_smelter")))
            .tooltips(FTETooltips.primitiveMultiblockTooltips(4))
            .register();

    public static MultiblockMachineDefinition PRIMITIVE_ELECTRIC_FURNACE = FTECore.FTERegister
            .multiblock("primitive_electric_furnace", WorkableElectricMultiblockMachine::new)
            .langValue("§8Primitive Electric Furnace")
            .recipeType(GTRecipeTypes.FURNACE_RECIPES)
            .recipeModifiers(GTRecipeModifiers.OC_NON_PERFECT, FTERecipeModifiers::primitiveMultiblockLogic)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(FTEBlocks.SOLID_WROUGHT_IRON_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("RRR", "###", " # ")
                    .aisle("RRR", "# #", " # ")
                    .aisle("RRR", "# #", " # ")
                    .aisle("RRR", "#C#", " # ")
                    .where("C", Predicates.controller(blocks(definition.get())))
                    .where("#", blocks(FTEBlocks.SOLID_WROUGHT_IRON_CASING.get())
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setMaxGlobalLimited(1)
                                    .setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setMaxGlobalLimited(1)
                                    .setPreviewCount(1))
                            .or(Predicates.abilities(FTEPartAbility.PRIMITIVE_MAINTENANCE).setExactLimit(1)
                                    .setPreviewCount(1))
                            .or(blocks(PartAbility.INPUT_ENERGY.getBlocks(GTValues.ULV).toArray(Block[]::new))
                                    .setMaxGlobalLimited(2).setPreviewCount(1)))
                    .where("R", blocks(FTEBlocks.WROUGHT_IRON_FIREBOX.get()))
                    .where(" ", Predicates.any())
                    .build())
            .model(
                    GTMachineModels.createWorkableCasingMachineModel(
                            FTECore.id("block/casings/solid/solid_wrought_iron_casing"),
                            GTCEu.id("block/machines/furnace")))
            .tooltips(FTETooltips.primitiveMultiblockTooltips(4))
            .register();

    public static MultiblockMachineDefinition PRIMITIVE_LARGE_COMPRESSOR = FTECore.FTERegister
            .multiblock("primitive_large_compressor", WorkableElectricMultiblockMachine::new)
            .langValue("§8Primitive Large Compressor")
            .recipeType(GTRecipeTypes.COMPRESSOR_RECIPES)
            .recipeModifiers(GTRecipeModifiers.OC_NON_PERFECT, FTERecipeModifiers::primitiveMultiblockLogic)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(FTEBlocks.SOLID_WROUGHT_IRON_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("RRR", "###", "###")
                    .aisle("RRR", "# #", "###")
                    .aisle("RRR", "#C#", "###")
                    .where("C", Predicates.controller(blocks(definition.get())))
                    .where("#", blocks(FTEBlocks.SOLID_WROUGHT_IRON_CASING.get())
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setMaxGlobalLimited(1)
                                    .setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setMaxGlobalLimited(1)
                                    .setPreviewCount(1))
                            .or(Predicates.abilities(FTEPartAbility.PRIMITIVE_MAINTENANCE).setExactLimit(1)
                                    .setPreviewCount(1))
                            .or(blocks(PartAbility.INPUT_ENERGY.getBlocks(GTValues.ULV).toArray(Block[]::new))
                                    .setMaxGlobalLimited(2).setPreviewCount(1)))
                    .where("R", blocks(FTEBlocks.WROUGHT_IRON_FIREBOX.get()))
                    .where(" ", Predicates.any())
                    .build())
            .model(
                    GTMachineModels.createWorkableCasingMachineModel(
                            FTECore.id("block/casings/solid/solid_wrought_iron_casing"),
                            GTCEu.id("block/machines/compressor")))
            .tooltips(FTETooltips.primitiveMultiblockTooltips(4))
            .register();

    public static void init() {
        FTECore.FTERegister.creativeModeTab(() -> FTECreativeModeTabs.MATERIALS);
    }
}

package com.puffofficial.ftecore.common.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.SimpleTieredMachine;
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.machine.multiblock.part.MaintenanceHatchPartMachine;

import com.puffofficial.ftecore.common.machine.multiblock.part.PrimitiveMaintenanceHatchPartMachine;
import com.puffofficial.ftecore.data.models.FTEMachineModels;
import net.minecraft.network.chat.Component;

import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.api.machine.multiblock.FTEPartAbility;
import com.puffofficial.ftecore.common.data.FTECreativeModeTabs;
import com.puffofficial.ftecore.common.data.FTERecipeModifiers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.*;
import static com.puffofficial.ftecore.common.machine.MachineUtils.*;

public class FTEPrimitiveMachines {

    static {
        FTECore.FTERegister.creativeModeTab(() -> FTECreativeModeTabs.MACHINES);
    }


    private static MachineDefinition[] registerPrimitiveMachine(String Name, String Id, GTRecipeType RecipeType) {
        List<Component> components = new ArrayList<>();
        components.add(Component.translatable("fte.components.ulv_machine"));
        components.addAll(Arrays.asList(workableTiered(GTValues.ULV, V[GTValues.ULV], V[GTValues.ULV] * 64, RecipeType,
                defaultTankSizeFunction.applyAsInt(GTValues.ULV), true)));

        return TieredMachines(Id,
                (holder, tier) -> new SimpleTieredMachine(holder, tier, defaultTankSizeFunction),
                (tier, builder) -> builder
                        .langValue("§8Primitive " + Name)
                        .editableUI(SimpleTieredMachine.EDITABLE_UI_CREATOR.apply(GTCEu.id(Id),
                                RecipeType))
                        .rotationState(RotationState.NON_Y_AXIS)
                        .recipeType(RecipeType)
                        .recipeModifiers(GTRecipeModifiers.OC_NON_PERFECT, FTERecipeModifiers::ulvMachineLogic)
                        .workableTieredHullModel(GTCEu.id("block/machines/" + Id))
                        .tooltips(components)
                        .register(),
                ULV);
    }

    public static MachineDefinition[] PRIMITIVE_EXTRACTOR = registerPrimitiveMachine("Extractor", "extractor",
            GTRecipeTypes.EXTRACTOR_RECIPES);
    public static MachineDefinition[] PRIMITIVE_ASSEMBLER = registerPrimitiveMachine("Assembler", "assembler",
            GTRecipeTypes.ASSEMBLER_RECIPES);
    public static MachineDefinition[] PRIMITIVE_ARC_FURNACE = registerPrimitiveMachine("Arc Furnace",
            "arc_furnace", GTRecipeTypes.ARC_FURNACE_RECIPES);
    public static MachineDefinition[] PRIMITIVE_WIREMILL = registerPrimitiveMachine("Wiremill", "wiremill",
            GTRecipeTypes.WIREMILL_RECIPES);
    public static MachineDefinition[] PRIMITIVE_POLARIZER = registerPrimitiveMachine("Polarizer", "polarizer",
            GTRecipeTypes.POLARIZER_RECIPES);
    public static MachineDefinition[] PRIMITIVE_ELECTROLYZER = registerPrimitiveMachine("Electrolyzer",
            "electrolyzer", GTRecipeTypes.ELECTROLYZER_RECIPES);
    public static MachineDefinition[] PRIMITIVE_EXTRUDER = registerPrimitiveMachine("Extruder", "extruder",
            GTRecipeTypes.EXTRUDER_RECIPES);
    public static MachineDefinition[] PRIMITIVE_FORGE_HAMMER = registerPrimitiveMachine("Forge Hammer",
            "forge_hammer", GTRecipeTypes.FORGE_HAMMER_RECIPES);

    public static final MachineDefinition PRIMITIVE_MAINTENANCE_HATCH = FTECore.FTERegister
            .machine("primitive_maintenance_hatch",
                    (blockEntity) -> new PrimitiveMaintenanceHatchPartMachine(blockEntity, false))
            .langValue("§8Primitive Maintenance Hatch")
            .rotationState(RotationState.ALL)
            .abilities(FTEPartAbility.PRIMITIVE_MAINTENANCE)
            .tooltips(Component.translatable("fte.components.primitive_maintenance"))
            .modelProperty(GTMachineModelProperties.IS_FORMED, false)
            .modelProperty(GTMachineModelProperties.IS_TAPED, false)
            .model(FTEMachineModels.createPrimitiveMaintenanceModel(FTECore.id("block/machine/part/primitive_maintenance_hatch")))
            .tier(GTValues.ULV)
            .register();

    public static void init() {}
}

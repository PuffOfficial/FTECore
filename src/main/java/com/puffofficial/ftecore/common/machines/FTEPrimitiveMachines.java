package com.puffofficial.ftecore.common.machines;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.SimpleTieredMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.minecraft.network.chat.Component;

import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.common.data.FTERecipeModifiers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.*;
import static com.puffofficial.ftecore.common.machines.MachineUtils.*;

public class FTEPrimitiveMachines {

    static {
        FTECore.FTERegister.creativeModeTab(() -> FTECore.FTE_CREATIVE_TAB);
    }

    private static MachineDefinition[] registerPrimitiveMachine(String Name, String Id, GTRecipeType RecipeType) {
        List<Component> components = new ArrayList<>();
        components.add(Component.translatable("gtfte.components.ulv_machine"));
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

    public static final MachineDefinition[] PRIMITIVE_EXTRACTOR = registerPrimitiveMachine("Extractor", "extractor",
            GTRecipeTypes.EXTRACTOR_RECIPES);
    public static final MachineDefinition[] PRIMITIVE_ASSEMBLER = registerPrimitiveMachine("Assembler", "assembler",
            GTRecipeTypes.ASSEMBLER_RECIPES);
    public static final MachineDefinition[] PRIMITIVE_ARC_FURNACE = registerPrimitiveMachine("Arc Furnace",
            "arc_furnace", GTRecipeTypes.ARC_FURNACE_RECIPES);
    public static final MachineDefinition[] PRIMITIVE_WIREMILL = registerPrimitiveMachine("Wiremill", "wiremill",
            GTRecipeTypes.WIREMILL_RECIPES);
    public static final MachineDefinition[] PRIMITIVE_POLARIZER = registerPrimitiveMachine("Polarizer", "polarizer",
            GTRecipeTypes.POLARIZER_RECIPES);
    public static final MachineDefinition[] PRIMITIVE_ELECTROLYZER = registerPrimitiveMachine("Electrolyzer",
            "electrolyzer", GTRecipeTypes.ELECTROLYZER_RECIPES);
    public static final MachineDefinition[] PRIMITIVE_EXTRUDER = registerPrimitiveMachine("Extruder", "extruder",
            GTRecipeTypes.EXTRUDER_RECIPES);
    public static final MachineDefinition[] PRIMITIVE_FORGE_HAMMER = registerPrimitiveMachine("Forge Hammer",
            "forge_hammer", GTRecipeTypes.FORGE_HAMMER_RECIPES);

    public static void init() {}
}

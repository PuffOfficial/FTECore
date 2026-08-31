package com.puffofficial.ftecore.common.machines;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import com.gregtechceu.gtceu.api.machine.SimpleTieredMachine;
import com.puffofficial.ftecore.FTECore;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.*;
import static com.puffofficial.ftecore.common.machines.MachineUtils.*;

public class FTEPrimitiveMachines {

    static {
        FTECore.FTERegister.creativeModeTab(() -> FTECore.FTE_CREATIVE_TAB);
    }

    private static MachineDefinition[] RegisterPrimitiveMachine(String Name, String Id, GTRecipeType RecipeType) {
        return TieredMachines(Id,
                (holder, tier) -> new SimpleTieredMachine(holder,tier,defaultTankSizeFunction),
                (tier,builder) -> builder
                        .langValue("Primitive "+Name)
                        .editableUI(SimpleTieredMachine.EDITABLE_UI_CREATOR.apply(GTCEu.id(Id),
                                RecipeType))
                        .rotationState(RotationState.NON_Y_AXIS)
                        .recipeType(RecipeType)
                        .recipeModifiers(GTRecipeModifiers.OC_NON_PERFECT)
                        .workableTieredHullModel(GTCEu.id("block/machines/"+Id))
                        .register(),
                ULV);
    }

    public static MachineDefinition[] PRIMITIVE_EXTRACTOR = RegisterPrimitiveMachine("Extractor","extractor",GTRecipeTypes.EXTRACTOR_RECIPES);
    public static MachineDefinition[] PRIMITIVE_ASSEMBLER = RegisterPrimitiveMachine("Assembler","assembler",GTRecipeTypes.ASSEMBLER_RECIPES);

    public static void init() {}
}

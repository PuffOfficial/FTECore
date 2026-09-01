package com.puffofficial.ftecore.common.machines.multiblock;

import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import com.puffofficial.ftecore.FTECore;

public class FTEPrimitiveMultiblocks {

    public static void init() {}

    static {
        FTECore.FTERegister.creativeModeTab(() -> FTECore.FTE_CREATIVE_TAB);
    }

    public static MultiblockMachineDefinition PRIMITIVE_BENDER = FTECore.FTERegister
            .multiblock("primitive_bender", WorkableElectricMultiblockMachine::new)
            .recipeType(GTRecipeTypes.BENDER_RECIPES)
            .recipeModifiers(GTRecipeModifiers.OC_PERFECT_SUBTICK)
            .register();
}

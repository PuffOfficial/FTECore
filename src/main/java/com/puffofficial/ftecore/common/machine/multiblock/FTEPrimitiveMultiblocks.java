package com.puffofficial.ftecore.common.machine.multiblock;

import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.common.data.FTECreativeModeTabs;

public class FTEPrimitiveMultiblocks {

    public static void init() {}

    static {
        FTECore.FTERegister.creativeModeTab(() -> FTECreativeModeTabs.FTE_MACHINE_CREATIVE_TAB);
    }

    public static MultiblockMachineDefinition PRIMITIVE_BENDER = FTECore.FTERegister
            .multiblock("primitive_bender", WorkableElectricMultiblockMachine::new)
            .recipeType(GTRecipeTypes.BENDER_RECIPES)
            .recipeModifiers(GTRecipeModifiers.OC_PERFECT_SUBTICK)
            .register();
}

package com.puffofficial.ftecore.common.machine;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.part.MultiblockPartMachine;
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.api.machine.multiblock.FTEPartAbility;
import com.puffofficial.ftecore.common.data.FTECreativeModeTabs;

public class FTEMachines {
    static {
        FTECore.FTERegister.creativeModeTab(() -> FTECreativeModeTabs.MACHINES);
    }

    public static final MachineDefinition VENTILATION = FTECore.FTERegister
            .machine("ventilation", MultiblockPartMachine::new)
            .langValue("Ventilation")
            .recipeType(GTRecipeTypes.DUMMY_RECIPES)
            .rotationState(RotationState.ALL)
            .abilities(FTEPartAbility.VENTIlATION)
            .modelProperty(GTMachineModelProperties.IS_FORMED, false)
            .workableTieredHullModel(FTECore.id("block/machines/ventilation"))
            .tier(GTValues.LV)
            .register();

    public static final MachineDefinition HEAT_VENT = FTECore.FTERegister
            .machine("heat_vent", MultiblockPartMachine::new)
            .langValue("Heat Vent")
            .recipeType(GTRecipeTypes.DUMMY_RECIPES)
            .rotationState(RotationState.ALL)
            .abilities(FTEPartAbility.HEAT_VENT)
            .modelProperty(GTMachineModelProperties.IS_FORMED, false)
            .workableTieredHullModel(FTECore.id("block/machines/heat_vent"))
            .tier(GTValues.EV)
            .register();

    public static void init() {}
}

package com.puffofficial.ftecore.common.data;

import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;

public class FTERecipeModifiers {

    public static ModifierFunction ulvMachineLogic(MetaMachine machine, GTRecipe recipe) {
        return ModifierFunction.builder()
                .durationMultiplier(2)
                .build();
    }
}

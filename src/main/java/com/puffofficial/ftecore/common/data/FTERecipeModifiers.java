package com.puffofficial.ftecore.common.data;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.content.Content;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.ParallelLogic;
import com.gregtechceu.gtceu.common.data.GTMachines;

import java.util.List;

public class FTERecipeModifiers {

    public static ModifierFunction ulvMachineLogic(MetaMachine machine, GTRecipe recipe) {
        return ModifierFunction.builder()
                .durationMultiplier(2)
                .build();
    }

    public static ModifierFunction primitiveMultiblockLogic(MetaMachine machine, GTRecipe recipe) {
        int parallels = ParallelLogic.getParallelAmountWithoutEU(machine,recipe,4);

        if (recipe.getInputEUt().voltage() > GTValues.ULV)  {
            return ModifierFunction.builder()
                    .durationMultiplier(2)
                    .modifyAllContents(ContentModifier.multiplier(parallels))
                    .eutModifier(ContentModifier.multiplier(1))
                    .parallels(parallels)
                    .build();
        }
        return ModifierFunction.IDENTITY;
    }
}

package com.puffofficial.ftecore.common.data;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.CoilWorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.ParallelLogic;

import net.minecraft.network.chat.Component;

import org.apache.commons.lang3.Range;

public class FTERecipeModifiers {

    public static ModifierFunction primitiveMultiblockLogic(MetaMachine machine, GTRecipe recipe) {
        if (!(machine instanceof WorkableElectricMultiblockMachine electricMulti)) return ModifierFunction.NULL;
        int parallels = ParallelLogic.getParallelAmountWithoutEU(machine, recipe, 4);

        if (electricMulti.getMaxVoltage() >= GTValues.V[GTValues.LV]) {
            return ModifierFunction.builder()
                    .durationMultiplier(2)
                    .modifyAllContents(ContentModifier.multiplier(parallels))
                    .eutModifier(ContentModifier.multiplier(1))
                    .parallels(parallels)
                    .build();
        } else {
            return ModifierFunction.builder().build();
        }
    }

    public static ModifierFunction defaultParallelWithoutEu(MetaMachine machine, GTRecipe recipe, int parallelCount) {
        int parallels = ParallelLogic.getParallelAmountWithoutEU(machine, recipe, parallelCount);
        return ModifierFunction.builder()
                .modifyAllContents(ContentModifier.multiplier(parallels))
                .parallels(parallels)
                .build();
    }

    public static ModifierFunction defaultParallel(MetaMachine machine, GTRecipe recipe, int parallelCount) {
        int parallels = ParallelLogic.getParallelAmount(machine, recipe, parallelCount);
        return ModifierFunction.builder()
                .modifyAllContents(ContentModifier.multiplier(parallels))
                .parallels(parallels)
                .build();
    }

    public static ModifierFunction alchemicalCrucibleLogic(MetaMachine machine, GTRecipe recipe) {
        if (!(machine instanceof CoilWorkableElectricMultiblockMachine coilMachine)) return ModifierFunction.NULL;

        int temperature = coilMachine.getCoilType().getCoilTemperature() +
                (75 * Math.max(0, coilMachine.getTier() - GTValues.MV));

        int minTemp = recipe.data.getInt("min_temp");
        int maxTemp = recipe.data.getInt("max_temp");

        Range<Integer> tempRange = Range.between(minTemp, maxTemp);

        if (tempRange.contains(temperature)) {
            return ModifierFunction.IDENTITY;
        }

        if (temperature < minTemp) {
            return ModifierFunction.cancel(Component.translatable("fte.components.display.error_temp_low"));
        } else if (temperature > maxTemp) {
            return ModifierFunction.cancel(Component.translatable("fte.components.display.error_temp_high"));
        }

        return ModifierFunction.NULL;
    }
}

package com.puffofficial.ftecore.common.recipes;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.fluids.FluidStack;

import com.puffofficial.ftecore.common.data.materials.lines.AspectMaterials;
import com.puffofficial.ftecore.common.machine.FTERecipeTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AspectRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        for (Material aspect : AspectMaterials.Aspects) {
            List<MaterialStack> aspectComponents = aspect.getMaterialComponents();
            List<FluidStack> inputAspects = new ArrayList<>();
            if (aspectComponents.size() >= 2) {
                for (MaterialStack component : aspectComponents) {
                    inputAspects.add(component.material().getFluid(50));
                }

                FTERecipeTypes.ALCHEMICAl_MIXER_TYPE.recipeBuilder(aspect.getName() + "_synthetyzing")
                        .inputFluids(inputAspects.toArray(new FluidStack[0]))
                        .outputFluids(aspect.getFluid(100))
                        .EUt(GTValues.VHA[GTValues.HV]).duration(100).save(provider);

                FTERecipeTypes.ALCHEMICAL_SEPARATOR_TYPE.recipeBuilder(aspect.getName() + "_separation")
                        .inputFluids(aspect.getFluid(100))
                        .outputFluids(inputAspects.toArray(new FluidStack[0]))
                        .EUt(GTValues.VHA[GTValues.HV]).duration(100).save(provider);
            }
        }
    }
}

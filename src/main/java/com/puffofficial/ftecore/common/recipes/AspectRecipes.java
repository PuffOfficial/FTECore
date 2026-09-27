package com.puffofficial.ftecore.common.recipes;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.fluids.FluidStack;

import com.puffofficial.ftecore.common.data.materials.lines.AspectMaterials;

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
                GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder(aspect.getName() + "_synthetyzing")
                        .inputFluids(inputAspects.toArray(new FluidStack[0]))
                        .outputFluids(aspect.getFluid(100))
                        .duration(60).save(provider);
            }
        }
    }
}

package com.puffofficial.ftecore.common.recipes.lines;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.common.data.GTItems;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.fluids.FluidStack;

import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.api.helpers.RecipeHelper;
import com.puffofficial.ftecore.common.machine.FTERecipeTypes;
import com.puffofficial.ftecore.common.materials.lines.AspectMaterials;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.ingot;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.puffofficial.ftecore.common.materials.FTEMaterials.*;
import static com.puffofficial.ftecore.common.materials.lines.AspectMaterials.*;

public class AspectRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        for (Material aspect : AspectMaterials.Aspects) {
            List<MaterialStack> aspectComponents = aspect.getMaterialComponents();
            List<FluidStack> inputAspects = new ArrayList<>();
            if (aspectComponents.size() >= 2) {
                for (MaterialStack component : aspectComponents) {
                    inputAspects.add(component.material().getFluid(50));
                }

                FTERecipeTypes.ALCHEMICAl_MIXER_TYPE.recipeBuilder(FTECore.id(aspect.getName() + "_synthetyzing"))
                        .inputFluids(inputAspects.toArray(new FluidStack[0]))
                        .outputFluids(aspect.getFluid(100))
                        .EUt(GTValues.VHA[GTValues.HV]).duration(100).save(provider);

                FTERecipeTypes.ALCHEMICAL_SEPARATOR_TYPE.recipeBuilder(FTECore.id(aspect.getName() + "_separation"))
                        .inputFluids(aspect.getFluid(100))
                        .outputFluids(inputAspects.toArray(new FluidStack[0]))
                        .EUt(GTValues.VHA[GTValues.HV]).duration(100).save(provider);
            }
        }

        RecipeHelper.registerAlchemicalCrucibleRecipe(provider, "thaumium",
                3200, 5400,
                GTValues.EV, 400,
                ChemicalHelper.get(ingot, TungstenSteel, 1),
                ChemicalHelper.get(ingot, Thaumium, 1),
                Praecantatio.getFluid(100), Metallum.getFluid(50));
        RecipeHelper.registerAlchemicalCrucibleRecipe(provider, "alchemical_bronze",
                1200, 2000,
                GTValues.MV, 200,
                ChemicalHelper.get(ingot, Bronze, 1),
                ChemicalHelper.get(ingot, AlchemicalBronze, 1),
                Praecantatio.getFluid(100), Vitreus.getFluid(50));
        RecipeHelper.registerAlchemicalCrucibleRecipe(provider, "void_metal",
                3000, 4200,
                GTValues.IV, 1000,
                ChemicalHelper.get(ingot, Thaumium, 1),
                ChemicalHelper.get(ingot, VoidMetal, 1),
                Tenebrae.getFluid(150), Vitium.getFluid(100));

        RecipeHelper.registerAlchemicalCrucibleRecipe(provider, "crystal_cpu",
                5800, 6900,
                GTValues.IV, 1200,
                GTItems.ENGRAVED_CRYSTAL_CHIP.asStack(1),
                GTItems.CRYSTAL_CENTRAL_PROCESSING_UNIT.asStack(1),
                Venenum.getFluid(250), Limus.getFluid(150), Lucrum.getFluid(50));
        RecipeHelper.registerAlchemicalCrucibleRecipe(provider, "crystal_soc",
                6800, 9600,
                GTValues.ZPM, 2400,
                GTItems.CRYSTAL_CENTRAL_PROCESSING_UNIT.asStack(1),
                GTItems.CRYSTAL_SYSTEM_ON_CHIP.asStack(1),
                Instrumentum.getFluid(250), Sensus.getFluid(150), Lucrum.getFluid(50));
    }
}

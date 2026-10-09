package com.puffofficial.ftecore.common.recipes;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;

import net.minecraft.data.recipes.FinishedRecipe;

import com.puffofficial.ftecore.api.helpers.RecipeHelper;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.puffofficial.ftecore.common.materials.FTEMaterials.*;

public class AlloyRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        RecipeHelper.registerDustRecipe(provider, GTValues.VA[GTValues.ULV], 3, true,
                new MaterialStack(AndesiteAlloy, 5),
                new MaterialStack(Zinc, 1), new MaterialStack(Andesite, 2), new MaterialStack(Iron, 2));

        RecipeHelper.registerAlloySmelterRecipe(provider, GTValues.VHA[GTValues.EV],
                new MaterialStack(TitaniumNoctite, 3),
                new MaterialStack[] { new MaterialStack(Titanium, 1), new MaterialStack(Nocturium, 2) });
    }
}

package com.puffofficial.ftecore.common.recipes;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;

import com.puffofficial.ftecore.api.helpers.RecipeHelper;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.puffofficial.ftecore.common.data.materials.FTEMaterials.*;

public class AlloyRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {

        RecipeHelper.registerDustRecipe(provider, GTValues.VA[GTValues.ULV], 3, true,
                new MaterialStack(AndesiteAlloy, 5),
                new MaterialStack(Zinc, 1), new MaterialStack(Andesite, 2), new MaterialStack(Iron, 2)
        );

        RecipeHelper.registerAlloySmelterRecipe(provider,
                new MaterialStack(TitaniumNoctite, 3),
                GTValues.VHA[GTValues.EV],
                new MaterialStack[] {new MaterialStack(Titanium, 1), new MaterialStack(Nocturium, 2)}
        );
    }
}

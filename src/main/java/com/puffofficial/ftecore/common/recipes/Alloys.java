package com.puffofficial.ftecore.common.recipes;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.puffofficial.ftecore.common.data.materials.FTEMaterials.*;

public class Alloys {

    public static void init(Consumer<FinishedRecipe> provider) {
        // Alloys
        VanillaRecipeHelper.addShapelessRecipe(provider, "andesite_alloy_by_hand",
                ChemicalHelper.get(dust, AndesiteAlloy, 5),
                new MaterialEntry(dust, Zinc),
                new MaterialEntry(dust, Andesite),
                new MaterialEntry(dust, Andesite),
                new MaterialEntry(dust, Iron),
                new MaterialEntry(dust, Iron));

        GTRecipeTypes.MIXER_RECIPES.recipeBuilder("andesite_alloy")
                .inputItems(dust, Andesite, 2)
                .inputItems(dust, Iron, 2)
                .inputItems(dust, Zinc)
                .circuitMeta(5)
                .outputItems(dust, AndesiteAlloy, 5)
                .duration(400).EUt(GTValues.VA[GTValues.LV]).save(provider);

        GTRecipeTypes.MIXER_RECIPES.recipeBuilder("titanium_noctite")
                .inputItems(dust, Nocturium, 2)
                .inputItems(dust, Titanium, 1)
                .circuitMeta(1)
                .outputItems(dust, TitaniumNoctite, 3)
                .duration(720).EUt(GTValues.VA[GTValues.EV]).save(provider);
    }
}

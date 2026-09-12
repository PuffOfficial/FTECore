package com.puffofficial.ftecore.common.recipes;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.puffofficial.ftecore.common.data.materials.FTEMaterials.*;

public class FTERecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        // Ceramic stuff
        GTRecipeTypes.PRIMITIVE_BLAST_FURNACE_RECIPES.recipeBuilder("ceramic_plate")
                .inputItems(ingot, Ceramic)
                .inputItems(ItemTags.COALS, 2)
                .notConsumable(GTItems.SHAPE_MOLD_PLATE)
                .outputItems(plate, Ceramic)
                .duration(1200).save(provider);
        GTRecipeTypes.ARC_FURNACE_RECIPES.recipeBuilder("ceramic_ingot")
                .inputItems(Items.CLAY_BALL)
                .inputFluids(Oxygen, 250)
                .outputItems(ingot, Ceramic)
                .duration(600).EUt(GTValues.VA[GTValues.ULV]).save(provider);
    }
}

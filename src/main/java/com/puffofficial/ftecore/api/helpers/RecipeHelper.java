package com.puffofficial.ftecore.api.helpers;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;

public class RecipeHelper {

    public static void registerAlloySmelterRecipe(Consumer<FinishedRecipe> provider, MaterialStack output, int eut,
                                                  MaterialStack[] inputs) {
        GTRecipeTypes.ALLOY_SMELTER_RECIPES
                .recipeBuilder(inputs[0].material().getName() + "_" + inputs[1].material().getName() + "_into_" +
                        output.material().getName() + "_ingots")
                .inputItems(ingot, inputs[0].material(), (int) inputs[0].amount())
                .inputItems(ingot, inputs[1].material(), (int) inputs[1].amount())
                .outputItems(ingot, output.material(), (int) output.amount())
                .duration((int) output.amount() * 50).EUt(eut).save(provider);

        GTRecipeTypes.ALLOY_SMELTER_RECIPES
                .recipeBuilder(inputs[0].material().getName() + "_" + inputs[1].material().getName() + "_into_" +
                        output.material().getName() + "_mixed")
                .inputItems(dust, inputs[0].material(), (int) inputs[0].amount())
                .inputItems(ingot, inputs[1].material(), (int) inputs[1].amount())
                .outputItems(ingot, output.material(), (int) output.amount())
                .duration((int) output.amount() * 50).EUt(eut).save(provider);

        GTRecipeTypes.ALLOY_SMELTER_RECIPES
                .recipeBuilder(inputs[0].material().getName() + "_" + inputs[1].material().getName() + "_into_" +
                        output.material().getName() + "_dusts")
                .inputItems(dust, inputs[0].material(), (int) inputs[0].amount())
                .inputItems(dust, inputs[1].material(), (int) inputs[1].amount())
                .outputItems(ingot, output.material(), (int) output.amount())
                .duration((int) output.amount() * 50).EUt(eut).save(provider);
    }

    public static void registerDustRecipe(Consumer<FinishedRecipe> provider, int eut, int circuit,
                                          Boolean registerHandCrafting, MaterialStack output, MaterialStack... inputs) {
        List<MaterialEntry> shapelessInputResult = new ArrayList<>();
        List<ItemStack> mixerInputResult = new ArrayList<>();

        for (MaterialStack input : inputs) {
            for (int i = 0; i < input.amount(); i++) {
                shapelessInputResult.add(new MaterialEntry(dust, input.material()));
            }
            mixerInputResult.add(ChemicalHelper.get(dust, input.material(), (int) input.amount()));
        }

        if (registerHandCrafting) {
            VanillaRecipeHelper.addShapelessRecipe(provider,
                    output.material().getName() + "_by_hand",
                    ChemicalHelper.get(dust, output.material(), (int) output.amount()),
                    shapelessInputResult.toArray());
        }

        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(output.material().getName() + "_mixing")
                .inputItems(mixerInputResult.toArray(new ItemStack[0])).circuitMeta(circuit)
                .outputItems(dust, output.material(), (int) output.amount())
                .EUt(eut).duration((int) (output.amount() * 50)).save(provider);
    }
}

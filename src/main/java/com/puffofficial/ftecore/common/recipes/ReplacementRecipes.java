package com.puffofficial.ftecore.common.recipes;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.data.recipe.GTCraftingComponents;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.plate;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.puffofficial.ftecore.common.materials.lines.ChemistryMaterials.*;

public class ReplacementRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        VanillaRecipeHelper.addShapedRecipe(provider, GTCEu.id("lv_machine_hull"),
                GTMachines.HULL[LV].asStack(),
                "   ",
                "BAB",
                "CHC",
                'A', GTCraftingComponents.PLATE.get(LV),
                'B', new MaterialEntry(plate, Rubber),
                'C', GTCraftingComponents.CABLE.get(LV),
                'H', GTCraftingComponents.CASING.get(LV));
        VanillaRecipeHelper.addShapedRecipe(provider, GTCEu.id("mv_machine_hull"),
                GTMachines.HULL[MV].asStack(),
                "   ",
                "BAB",
                "CHC",
                'A', GTCraftingComponents.PLATE.get(MV),
                'B', new MaterialEntry(plate, PolylacticAcid),
                'C', GTCraftingComponents.CABLE.get(MV),
                'H', GTCraftingComponents.CASING.get(MV));
    }
}

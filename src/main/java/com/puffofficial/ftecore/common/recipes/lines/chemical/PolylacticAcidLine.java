package com.puffofficial.ftecore.common.recipes.lines.chemical;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;

import com.puffofficial.ftecore.FTECore;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.puffofficial.ftecore.common.materials.lines.ChemistryMaterials.*;

public class PolylacticAcidLine {

    public static void init(Consumer<FinishedRecipe> provider) {
        GTRecipeTypes.FERMENTING_RECIPES.recipeBuilder(FTECore.id("fermented_biomass"))
                .inputItems(Items.POTATO, 4)
                .outputItems(dust, RawStarch, 3)
                .duration(400).EUt(VA[ULV]).save(provider);
        GTRecipeTypes.FERMENTING_RECIPES.recipeBuilder(FTECore.id("propylene"))
                .inputItems(Items.SUGAR_CANE, 12)
                .outputFluids(Propylene.getFluid(500))
                .duration(400).EUt(VHA[LV]).save(provider);

        GTRecipeTypes.MACERATOR_RECIPES.recipeBuilder(FTECore.id("starch"))
                .inputItems(dust, RawStarch)
                .outputItems(dust, Starch)
                .duration(40).EUt(VA[ULV]).save(provider);

        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder(FTECore.id("tin_dioxide"))
                .inputItems(dust, Tin)
                .inputFluids(Oxygen.getFluid(2000))
                .outputItems(dust, TinDioxide)
                .duration(200).EUt(VA[LV]).save(provider);
        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder(FTECore.id("2_ethylhexanoic_acid"))
                .inputFluids(Propylene.getFluid(3000), CarbonMonoxide.getFluid(2000), Hydrogen.getFluid(3000))
                .outputFluids(EthylhexanoicAcid.getFluid(1000))
                .outputItems(dust, Carbon)
                .duration(300).EUt(VA[LV]).save(provider);
        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder(FTECore.id("stannous_octoate"))
                .inputItems(dust, TinDioxide)
                .inputFluids(EthylhexanoicAcid.getFluid(1000))
                .outputItems(dust, StannousOctoate)
                .outputFluids(Oxygen.getFluid(2000))
                .duration(200).EUt(VA[LV]).save(provider);
        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder(FTECore.id("lactic_acid"))
                .inputItems(dust, Starch, 12)
                .inputItems(Items.SUGAR_CANE, 12)
                .outputFluids(LacticAcid.getFluid(2000), Water.getFluid(3000))
                .duration(800).EUt(VA[LV]).save(provider);
        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder(FTECore.id("polylactic_acid"))
                .chancedInput(ChemicalHelper.get(dust, StannousOctoate, 2), 100, 0)
                .inputFluids(LacticAcid.getFluid(1000))
                .outputFluids(PolylacticAcid.getFluid(1296), Water.getFluid(1000))
                .duration(800).EUt(VA[ULV]).save(provider);
    }
}

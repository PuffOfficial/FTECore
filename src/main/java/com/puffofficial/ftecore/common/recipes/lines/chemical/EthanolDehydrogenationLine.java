package com.puffofficial.ftecore.common.recipes.lines.chemical;

import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.minecraft.data.recipes.FinishedRecipe;

import com.puffofficial.ftecore.FTECore;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.puffofficial.ftecore.common.materials.lines.ChemistryMaterials.*;

public class EthanolDehydrogenationLine {

    public static void init(Consumer<FinishedRecipe> provider) {
        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder(FTECore.id("vanadium_pentoxide"))
                .inputItems(dust, Vanadium, 2)
                .inputFluids(Oxygen.getFluid(5000))
                .outputItems(dust, VanadiumPentoxide)
                .duration(300).EUt(VA[LV]).save(provider);
        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder(FTECore.id("molybdenum_trioxide"))
                .inputItems(dust, Molybdenum)
                .inputFluids(Oxygen.getFluid(3000))
                .outputItems(dust, MolybdenumTrioxide, 4)
                .duration(300).EUt(VA[LV]).save(provider);

        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder(FTECore.id("maleic_anhydride"))
                .notConsumable(dust, VanadiumPentoxide)
                .notConsumable(dust, MolybdenumTrioxide)
                .inputFluids(Benzene.getFluid(1000), Air.getFluid(3500))
                .outputFluids(Water.getFluid(2000), MaleicAnhydride.getFluid(1000))
                .outputItems(dust, Carbon, 2)
                .duration(300).EUt(VHA[HV]).save(provider);

        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder(FTECore.id("acetaldehyde_diethyl_succinate"))
                .notConsumable(dust, Sapphire)
                .inputFluids(Ethanol.getFluid(1000), MaleicAnhydride.getFluid(1000))
                .outputFluids(Acetaldehyde.getFluid(1000), SuccinicAnhydride.getFluid(500))
                .duration(600).EUt(VHA[MV]).save(provider);

        GTRecipeTypes.LARGE_CHEMICAL_RECIPES.recipeBuilder(FTECore.id("butadiene_from_acetaldehyde"))
                .notConsumable(dust, Sapphire)
                .notConsumable(dust, Zincite)
                .inputFluids(Acetaldehyde.getFluid(2000))
                .outputFluids(Butadiene.getFluid(1000), Water.getFluid(1000))
                .duration(600).EUt(VHA[EV]).save(provider);

        GTRecipeTypes.ELECTROLYZER_RECIPES.recipeBuilder(FTECore.id("diethyl_succinate_electrolyzing"))
                .inputFluids(SuccinicAnhydride.getFluid(11000))
                .outputFluids(Hydrogen.getFluid(4000), Oxygen.getFluid(3000))
                .outputItems(dust, Carbon, 4)
                .duration(1200).EUt(VHA[HV]).save(provider);
    }
}

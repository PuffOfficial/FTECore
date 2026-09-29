package com.puffofficial.ftecore.common.recipes;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.puffofficial.ftecore.common.data.FTEBlocks;
import com.puffofficial.ftecore.common.data.materials.lines.AspectMaterials;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.puffofficial.ftecore.common.data.materials.FTEMaterials.*;
import static com.puffofficial.ftecore.common.data.materials.lines.BotaniaMaterials.*;

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

        // Casings

        // Wrought Iron
        VanillaRecipeHelper.addShapedRecipe(provider, "solid_wrought_iron_casing",
                FTEBlocks.SOLID_WROUGHT_IRON_CASING.asStack(2),
                "BhB",
                "BAB",
                "BwB",
                'A', new MaterialEntry(frameGt, AndesiteAlloy),
                'B', new MaterialEntry(plate, WroughtIron));

        GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder("solid_wrought_iron_casing_assembler")
                .inputItems(plate, WroughtIron, 6)
                .inputItems(frameGt, AndesiteAlloy)
                .circuitMeta(6)
                .outputItems(FTEBlocks.SOLID_WROUGHT_IRON_CASING, 2)
                .duration(50).EUt(GTValues.VH[GTValues.LV]).save(provider);

        VanillaRecipeHelper.addShapedRecipe(provider, "wrought_iron_firebox", FTEBlocks.WROUGHT_IRON_FIREBOX.asStack(2),
                "BAB",
                "ACA",
                "BAB",
                'A', new MaterialEntry(rod, WroughtIron),
                'B', new MaterialEntry(plate, WroughtIron),
                'C', new MaterialEntry(frameGt, AndesiteAlloy));

        GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder("wrought_iron_firebox")
                .inputItems(plate, WroughtIron, 3)
                .inputItems(frameGt, AndesiteAlloy)
                .inputItems(rod, WroughtIron, 3)
                .outputItems(FTEBlocks.WROUGHT_IRON_FIREBOX, 2)
                .duration(100).EUt(GTValues.VA[GTValues.LV]).save(provider);

        // Titanium Noctite
        GTRecipeTypes.ASSEMBLY_LINE_RECIPES.recipeBuilder("titanium_noctium_casing")
                .inputItems(plate, TitaniumNoctite, 6)
                .inputItems(rod, Gaia, 2)
                .inputItems(screw, RhodiumPlatedPalladium, 24)
                .inputItems(foil, StyreneButadieneRubber, 16)
                .inputFluids(SolderingAlloy.getFluid(432))
                .outputItems(FTEBlocks.CORRUPTION_PROOF_TITANIUM_NOCTITE_CASING, 2)
                .scannerResearch(b -> b
                        .researchFluidStack(AspectMaterials.Perditio.getFluid(144))
                        .duration(1200)
                        .EUt(GTValues.VHA[GTValues.EV]))
                .duration(300).EUt(GTValues.VA[GTValues.IV]).save(provider);
    }
}

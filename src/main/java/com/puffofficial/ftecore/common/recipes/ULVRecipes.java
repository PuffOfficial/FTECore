package com.puffofficial.ftecore.common.recipes;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.puffofficial.ftecore.common.data.FTEItems;
import com.puffofficial.ftecore.common.machine.FTEPrimitiveMachines;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class ULVRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        // ULV Components
        VanillaRecipeHelper.addShapedRecipe(provider, "ulv_electric_motor", FTEItems.ELECTRIC_MOTOR_ULV.asStack(),
                "ABC",
                "BDB",
                "CBA",
                'A', new MaterialEntry(cableGtSingle, RedAlloy),
                'B', new MaterialEntry(wireGtSingle, Lead),
                'C', new MaterialEntry(rod, Copper),
                'D', Items.REDSTONE
        );
        VanillaRecipeHelper.addShapedRecipe(provider, "ulv_electric_piston", FTEItems.ELECTRIC_PISTON_ULV.asStack(),
                "EEE",
                "ADD",
                "ABC",
                'A', new MaterialEntry(cableGtSingle, RedAlloy),
                'B', FTEItems.ELECTRIC_MOTOR_ULV,
                'C', new MaterialEntry(gear, WroughtIron),
                'D', new MaterialEntry(rod, Copper),
                'E', new MaterialEntry(plate,Copper)
        );
        VanillaRecipeHelper.addShapedRecipe(provider, "ulv_conveyor_module", FTEItems.CONVEYOR_MODULE_ULV.asStack(),
                "CCC",
                "BAB",
                "CCC",
                'A', new MaterialEntry(cableGtSingle, RedAlloy),
                'B', FTEItems.ELECTRIC_MOTOR_ULV,
                'C', new MaterialEntry(plate, Rubber)
        );
        VanillaRecipeHelper.addShapedRecipe(provider, "ulv_electric_pump", FTEItems.ELECTRIC_PUMP_ULV.asStack(),
                "EFB",
                "sDw",
                "BCA",
                'A', new MaterialEntry(cableGtSingle, RedAlloy),
                'B', new MaterialEntry(ring, Rubber),
                'C', FTEItems.ELECTRIC_MOTOR_ULV,
                'D', new MaterialEntry(pipeNormalFluid, Potin),
                'E', new MaterialEntry(rotor, Copper),
                'F', new MaterialEntry(screw, Copper)
        );
        VanillaRecipeHelper.addShapedRecipe(provider, "ulv_robot_arm", FTEItems.ROBOT_ARM_ULV.asStack(),
                "AAA",
                "BDB",
                "CED",
                'A', new MaterialEntry(cableGtSingle, RedAlloy),
                'B', FTEItems.ELECTRIC_MOTOR_ULV,
                'C', FTEItems.ELECTRIC_PISTON_ULV,
                'D', new MaterialEntry(rod, Potin),
                'E', CustomTags.ULV_CIRCUITS
        );
        // Primitive Generator
        VanillaRecipeHelper.addShapedRecipe(provider, "ulv_hydrokinetic_dynamo", FTEPrimitiveMachines.PRIMITIVE_HYDROKINETIC_DYNAMO.asStack(),
                "FBF",
                "EAE",
                "CDC",
                'A', GTMachines.HULL[GTValues.ULV].asStack(),
                'B', new MaterialEntry(rotor,Iron),
                'C', new MaterialEntry(cableGtSingle, RedAlloy),
                'D', FTEItems.ELECTRIC_PUMP_ULV,
                'E', FTEItems.ELECTRIC_MOTOR_ULV,
                'F', Tags.Blocks.GLASS
        );
        // Primitive Maintenance Hatch
        VanillaRecipeHelper.addShapedRecipe(provider, "primitive_maintenance_hatch", FTEPrimitiveMachines.PRIMITIVE_MAINTENANCE_HATCH.asStack(),
                "dDw",
                "CAB",
                "ExE",
                'A', GTMachines.HULL[GTValues.ULV].asStack(),
                'B', new MaterialEntry(plate,Wood),
                'C', new MaterialEntry(pipeNormalFluid, Copper),
                'D', new MaterialEntry(cableGtSingle, RedAlloy),
                'E', new MaterialEntry(screw, Copper)
        );
        GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder("primitive_maintenance_hatch_assembler")
                .inputItems(GTMachines.HULL[GTValues.ULV].asStack())
                .inputItems(plate,Wood)
                .inputItems(cableGtSingle,RedAlloy,2)
                .inputFluids(Copper,432)
                .outputItems(FTEPrimitiveMachines.PRIMITIVE_MAINTENANCE_HATCH.asStack())
                .duration(600).EUt(GTValues.VA[GTValues.ULV]).save(provider);
        // Primitive Machines
        VanillaRecipeHelper.addShapedRecipe(provider, "ulv_assembler", FTEPrimitiveMachines.PRIMITIVE_ASSEMBLER.asStack(),
                "EBE",
                "DAD",
                "CBC",
                'A', GTMachines.HULL[GTValues.ULV].asStack(),
                'B', CustomTags.ULV_CIRCUITS,
                'C', new MaterialEntry(cableGtSingle, RedAlloy),
                'D', FTEItems.CONVEYOR_MODULE_ULV,
                'E', FTEItems.ROBOT_ARM_ULV
        );
        VanillaRecipeHelper.addShapedRecipe(provider, "ulv_compressor", FTEPrimitiveMachines.PRIMITIVE_COMPRESSOR.asStack(),
                " B ",
                "DAD",
                "CBC",
                'A', GTMachines.HULL[GTValues.ULV].asStack(),
                'B', CustomTags.ULV_CIRCUITS,
                'C', new MaterialEntry(cableGtSingle, RedAlloy),
                'D', FTEItems.ELECTRIC_PISTON_ULV
        );
        VanillaRecipeHelper.addShapedRecipe(provider, "ulv_electrolyzer", FTEPrimitiveMachines.PRIMITIVE_ELECTROLYZER.asStack(),
                "DED",
                "DAD",
                "BCB",
                'A', GTMachines.HULL[GTValues.ULV].asStack(),
                'B', CustomTags.ULV_CIRCUITS,
                'C', new MaterialEntry(cableGtSingle, RedAlloy),
                'D', new MaterialEntry(wireGtSingle, Copper),
                'E', Tags.Items.GLASS
        );
        VanillaRecipeHelper.addShapedRecipe(provider, "ulv_forge_hammer", FTEPrimitiveMachines.PRIMITIVE_FORGE_HAMMER.asStack(),
                "CDC",
                "BAB",
                "CEC",
                'A', GTMachines.HULL[GTValues.ULV].asStack(),
                'B', CustomTags.ULV_CIRCUITS,
                'C', new MaterialEntry(cableGtSingle, RedAlloy),
                'D', FTEItems.ELECTRIC_PISTON_ULV,
                'E', Blocks.IRON_BLOCK
        );
        VanillaRecipeHelper.addShapedRecipe(provider, "ulv_macerator", FTEPrimitiveMachines.PRIMITIVE_MACERATOR.asStack(),
                "DEF",
                "CCA",
                "BBC",
                'A', GTMachines.HULL[GTValues.ULV].asStack(),
                'B', CustomTags.ULV_CIRCUITS,
                'C', new MaterialEntry(cableGtSingle, RedAlloy),
                'D', FTEItems.ELECTRIC_PISTON_ULV,
                'E', FTEItems.ELECTRIC_MOTOR_ULV,
                'F', Items.DIAMOND
        );
        VanillaRecipeHelper.addShapedRecipe(provider, "ulv_polarizer", FTEPrimitiveMachines.PRIMITIVE_POLARIZER.asStack(),
                "CDC",
                "BAB",
                "CDC",
                'A', GTMachines.HULL[GTValues.ULV].asStack(),
                'B', new MaterialEntry(cableGtSingle, RedAlloy),
                'C', new MaterialEntry(wireGtDouble, RedAlloy),
                'D', new MaterialEntry(rod, Copper)
        );
        VanillaRecipeHelper.addShapedRecipe(provider, "ulv_sifter", FTEPrimitiveMachines.PRIMITIVE_SIFTER.asStack(),
                "ECE",
                "DAD",
                "BCB",
                'A', GTMachines.HULL[GTValues.ULV].asStack(),
                'B', CustomTags.ULV_CIRCUITS,
                'C', GTItems.ITEM_FILTER,
                'D', FTEItems.ELECTRIC_PISTON_ULV,
                'E', new MaterialEntry(cableGtSingle, RedAlloy)
        );
        VanillaRecipeHelper.addShapedRecipe(provider, "ulv_arc_furnace", FTEPrimitiveMachines.PRIMITIVE_ARC_FURNACE.asStack(),
                "CDC",
                "BAB",
                "EEE",
                'A', GTMachines.HULL[GTValues.ULV].asStack(),
                'B', CustomTags.ULV_CIRCUITS,
                'C', new MaterialEntry(cableGtQuadruple, RedAlloy),
                'D', new MaterialEntry(dust, Coal),
                'E', new MaterialEntry(plate, WroughtIron)
        );
        VanillaRecipeHelper.addShapedRecipe(provider, "ulv_extruder", FTEPrimitiveMachines.PRIMITIVE_EXTRUDER.asStack(),
                "CCB",
                "EAD",
                "CCB",
                'A', GTMachines.HULL[GTValues.ULV].asStack(),
                'B', CustomTags.ULV_CIRCUITS,
                'C', new MaterialEntry(wireGtQuadruple, RedAlloy),
                'D', new MaterialEntry(pipeNormalFluid, Copper),
                'E', FTEItems.ELECTRIC_PISTON_ULV
        );
        VanillaRecipeHelper.addShapedRecipe(provider, "ulv_wiremill", FTEPrimitiveMachines.PRIMITIVE_WIREMILL.asStack(),
                "CDC",
                "BAB",
                "CDC",
                'A', GTMachines.HULL[GTValues.ULV].asStack(),
                'B', CustomTags.ULV_CIRCUITS,
                'C', FTEItems.ELECTRIC_MOTOR_ULV,
                'D', new MaterialEntry(cableGtSingle, RedAlloy)
        );
        VanillaRecipeHelper.addShapedRecipe(provider, "ulv_extractor", FTEPrimitiveMachines.PRIMITIVE_EXTRACTOR.asStack(),
                "FBF",
                "CAD",
                "EBE",
                'A', GTMachines.HULL[GTValues.ULV].asStack(),
                'B', CustomTags.ULV_CIRCUITS,
                'C', FTEItems.ELECTRIC_PISTON_ULV,
                'D', FTEItems.ELECTRIC_PUMP_ULV,
                'E', new MaterialEntry(cableGtSingle, RedAlloy),
                'F', Tags.Blocks.GLASS
        );
        // Multiblocks
        VanillaRecipeHelper.addShapedRecipe(provider, "ulv_bender", FTEPrimitiveMachines.PRIMITIVE_BENDER.asStack(),
                "CFC",
                "BAB",
                "DED",
                'A', GTMachines.HULL[GTValues.ULV].asStack(),
                'B', CustomTags.ULV_CIRCUITS,
                'C', FTEItems.ELECTRIC_PISTON_ULV,
                'D', FTEItems.ELECTRIC_MOTOR_ULV,
                'E', new MaterialEntry(cableGtSingle, RedAlloy),
                'F', new MaterialEntry(plate, WroughtIron)
        );
        VanillaRecipeHelper.addShapedRecipe(provider, "ulv_electric_furnace", FTEPrimitiveMachines.PRIMITIVE_ELECTRIC_FURNACE.asStack(),
                "BCB",
                "CAC",
                "DCD",
                'A', GTMachines.HULL[GTValues.ULV].asStack(),
                'B', CustomTags.ULV_CIRCUITS,
                'C', new MaterialEntry(wireGtDouble, RedAlloy),
                'D', new MaterialEntry(cableGtSingle, RedAlloy)
        );
        VanillaRecipeHelper.addShapedRecipe(provider, "ulv_alloy_smelter", FTEPrimitiveMachines.PRIMITIVE_ALLOY_SMELTER.asStack(),
                "BCB",
                "CAC",
                "DCD",
                'A', GTMachines.HULL[GTValues.ULV].asStack(),
                'B', CustomTags.ULV_CIRCUITS,
                'C', new MaterialEntry(wireGtQuadruple, RedAlloy),
                'D', new MaterialEntry(cableGtSingle, RedAlloy)
        );
        VanillaRecipeHelper.addShapedRecipe(provider, "ulv_large_compressor", FTEPrimitiveMachines.PRIMITIVE_LARGE_COMPRESSOR.asStack(),
                "BEB",
                "CAC",
                "DBD",
                'A', GTMachines.HULL[GTValues.ULV].asStack(),
                'B', CustomTags.ULV_CIRCUITS,
                'C', FTEItems.ELECTRIC_PISTON_ULV,
                'D', new MaterialEntry(cableGtQuadruple, RedAlloy),
                'E', new MaterialEntry(plate, WroughtIron)
        );
    }
}

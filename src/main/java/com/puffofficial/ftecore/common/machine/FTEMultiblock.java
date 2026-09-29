package com.puffofficial.ftecore.common.machine;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.CoilWorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.data.models.GTMachineModels;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.api.helpers.TooltipHelper;
import com.puffofficial.ftecore.api.machine.multiblock.FTEPartAbility;
import com.puffofficial.ftecore.common.data.FTEBlocks;
import com.puffofficial.ftecore.common.data.FTECreativeModeTabs;
import com.puffofficial.ftecore.common.data.FTERecipeModifiers;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;

public class FTEMultiblock {
    static {
        FTECore.FTERegister.creativeModeTab(() -> FTECreativeModeTabs.MACHINES);
    }

    public static MultiblockMachineDefinition ALCHEMICAL_CRUCIBLE = FTECore.FTERegister
            .multiblock("alchemical_crucible", CoilWorkableElectricMultiblockMachine::new)
            .langValue("Alchemical Crucible")
            .recipeType(FTERecipeTypes.ALCHEMICAL_CRUCIBLE_TYPE)
            .recipeModifiers(GTRecipeModifiers.OC_NON_PERFECT, FTERecipeModifiers::alchemicalCrucibleLogic)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(FTEBlocks.CORRUPTION_PROOF_TITANIUM_NOCTITE_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("S S", "###", "###", "###", "###")
                    .aisle("   ", "#R#", "# #", "# #", "#V#")
                    .aisle("S S", "###", "#C#", "###", "###")
                    .where("C", Predicates.controller(blocks(definition.get())))
                    .where("#", blocks(FTEBlocks.CORRUPTION_PROOF_TITANIUM_NOCTITE_CASING.get())
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS)
                                    .setMaxGlobalLimited(1).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS)
                                    .setMaxGlobalLimited(1).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS)
                                    .setMaxGlobalLimited(3).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.INPUT_ENERGY)
                                    .setMaxGlobalLimited(1).setPreviewCount(1)))
                    .where("V", Predicates.abilities(FTEPartAbility.HEAT_VENT))
                    .where("S", blocks(GTBlocks.STEEL_HULL.get()))
                    .where("R", heatingCoils())
                    .where(" ", air())
                    .build())
            .model(
                    GTMachineModels.createWorkableCasingMachineModel(
                            FTECore.id("block/casings/solid/corruption_proof_titanium_noctite_casing"),
                            FTECore.id("block/machines/multiblock/alchemical_crucible")))
            .additionalDisplay((controller, components) -> {
                        if (controller instanceof CoilWorkableElectricMultiblockMachine coilMachine && controller.isFormed()) {

                            MutableComponent temp = Component.literal(FormattingUtil.formatNumbers(
                                    coilMachine.getCoilType().getCoilTemperature() + (75*Math.max(0, coilMachine.getTier() - GTValues.MV)))).setStyle(Style.EMPTY.withColor(ChatFormatting.RED));

                            components.add(Component.translatable("fte.components.display.temperature", temp));
                        }
                    }
            )
            .register();

    public static MultiblockMachineDefinition ALCHEMICAL_MIXER = FTECore.FTERegister
            .multiblock("alchemical_mixer", WorkableElectricMultiblockMachine::new)
            .langValue("Alchemical Mixer")
            .tooltips(
                    Component.translatable("fte.components.tooltip.alchemical_mixer"),
                    TooltipHelper.defaultParallelTooltip(16)
            )
            .recipeType(FTERecipeTypes.ALCHEMICAl_MIXER_TYPE)
            .recipeModifiers(GTRecipeModifiers.OC_NON_PERFECT, (machine, recipe) -> FTERecipeModifiers.defaultParallel(machine, recipe, 16))
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(FTEBlocks.CORRUPTION_PROOF_TITANIUM_NOCTITE_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("### ###", "#S# ###", "### ###", "#S#    ", "###    ")
                    .aisle("### ###", "IRRRRRO", "#R# ###", "IR#    ", "###    ")
                    .aisle("### ###", "#S# #C#", "### ###", "#S#    ", "###    ")
                    .where("C", Predicates.controller(blocks(definition.get())))
                    .where("#", blocks(FTEBlocks.CORRUPTION_PROOF_TITANIUM_NOCTITE_CASING.get())
                            .or(Predicates.abilities(PartAbility.MAINTENANCE).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setMaxGlobalLimited(2).setPreviewCount(1)))
                    .where("S", Predicates.abilities(FTEPartAbility.HEAT_VENT))
                    .where("I", Predicates.abilities(PartAbility.IMPORT_FLUIDS_1X))
                    .where("O", Predicates.abilities(PartAbility.EXPORT_FLUIDS))
                    .where("R", blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where(" ", Predicates.any())
                    .build())
            .model(
                    GTMachineModels.createWorkableCasingMachineModel(
                            FTECore.id("block/casings/solid/corruption_proof_titanium_noctite_casing"),
                            FTECore.id("block/machines/multiblock/alchemical_crucible")))
            .register();

    public static MultiblockMachineDefinition ALCHEMICAL_SEPARATOR = FTECore.FTERegister
            .multiblock("alchemical_separator", WorkableElectricMultiblockMachine::new)
            .langValue("Alchemical Separator")
            .tooltips(
                    Component.translatable("fte.components.tooltip.alchemical_separator"),
                    TooltipHelper.defaultParallelTooltip(16)
            )
            .recipeType(FTERecipeTypes.ALCHEMICAL_SEPARATOR_TYPE)
            .recipeModifiers(GTRecipeModifiers.OC_NON_PERFECT, (machine, recipe) -> FTERecipeModifiers.defaultParallel(machine, recipe, 16))
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(FTEBlocks.CORRUPTION_PROOF_TITANIUM_NOCTITE_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("###", "#S#", "###", "#S#", "###")
                    .aisle("###", "#RO", "IR#", "#RO", "###")
                    .aisle("###", "###", "#C#", "###", "###")
                    .where("C", Predicates.controller(blocks(definition.get())))
                    .where("#", blocks(FTEBlocks.CORRUPTION_PROOF_TITANIUM_NOCTITE_CASING.get())
                            .or(Predicates.abilities(PartAbility.MAINTENANCE).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.INPUT_ENERGY).setMaxGlobalLimited(2).setPreviewCount(1)))
                    .where("S", Predicates.abilities(FTEPartAbility.HEAT_VENT))
                    .where("I", Predicates.abilities(PartAbility.IMPORT_FLUIDS_1X))
                    .where("O", Predicates.abilities(PartAbility.EXPORT_FLUIDS))
                    .where("R", blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where(" ", Predicates.any())
                    .build())
            .model(
                    GTMachineModels.createWorkableCasingMachineModel(
                            FTECore.id("block/casings/solid/corruption_proof_titanium_noctite_casing"),
                            FTECore.id("block/machines/multiblock/alchemical_crucible")))
            .register();

    public static void init() {}
}

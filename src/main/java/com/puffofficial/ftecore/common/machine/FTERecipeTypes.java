package com.puffofficial.ftecore.common.machine;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.ui.GTRecipeTypeUI;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;

import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;

import net.minecraft.network.chat.Component;

public class FTERecipeTypes {

    public static final GTRecipeType HYDROKINETIC_DYNAMO_TYPE = GTRecipeTypes
            .register("hydrokinetic_dynamo", GTRecipeTypes.GENERATOR)
            .setEUIO(IO.OUT)
            .setMaxIOSize(0, 1, 1, 0)
            .setSound(GTSoundEntries.BATH);

    public static final GTRecipeType ALCHEMICAL_CRUCIBLE_TYPE = GTRecipeTypes
            .register("alchemical_crucible", GTRecipeTypes.MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(1, 1, 3, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .addDataInfo((data) -> (Component.translatable("fte.components.data.temperature_range",
                    data.getInt("min_temp"), data.getInt("max_temp")).getString()))
            .setSound(GTSoundEntries.BATH);
    public static final GTRecipeType ALCHEMICAl_MIXER_TYPE = GTRecipeTypes
            .register("alchemical_mixer", GTRecipeTypes.MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(0, 0, 2, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.BATH);
    public static final GTRecipeType ALCHEMICAL_SEPARATOR_TYPE = GTRecipeTypes
            .register("alchemical_separator", GTRecipeTypes.MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(0, 0, 1, 2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.BATH);

    public static final GTRecipeType LARGE_CRUCIBLE = GTRecipeTypes
            .register("large_crucible", GTRecipeTypes.MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(0, 0, 1, 2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.BATH);
    public static final GTRecipeType LARGE_BARREL = GTRecipeTypes
            .register("large_barrel", GTRecipeTypes.MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(0, 0, 1, 2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.BATH);
    public static final GTRecipeType DAYCYCLE_SIMULATION_CHAMBER = GTRecipeTypes
            .register("daycycle_simulation_chamber", GTRecipeTypes.MULTIBLOCK)
            .setEUIO(IO.IN)
            .setMaxIOSize(2, 2, 2, 2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING);

    public static void init() {}
}

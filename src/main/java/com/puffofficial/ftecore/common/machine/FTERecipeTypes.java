package com.puffofficial.ftecore.common.machine;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;

public class FTERecipeTypes {

    public static final GTRecipeType HYDROKINETIC_DYNAMO_TYPE = GTRecipeTypes
            .register("hydrokinetic_dynamo", GTRecipeTypes.GENERATOR)
            .setEUIO(IO.OUT)
            .setMaxIOSize(0, 1, 1, 0)
            .setSound(GTSoundEntries.BATH);

    public static void init() {}
}

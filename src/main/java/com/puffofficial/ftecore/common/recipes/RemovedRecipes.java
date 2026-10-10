package com.puffofficial.ftecore.common.recipes;

import com.gregtechceu.gtceu.GTCEu;

import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class RemovedRecipes {

    public static void init(Consumer<ResourceLocation> provider) {
        provider.accept(GTCEu.id("laser_engraver/crystal_soc"));
        provider.accept(GTCEu.id("laser_engraver/crystal_cpu"));
    }
}

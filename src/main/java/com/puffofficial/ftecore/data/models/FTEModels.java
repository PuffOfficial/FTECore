package com.puffofficial.ftecore.data.models;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.api.block.property.GTBlockStateProperties;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ModelFile;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;

public class FTEModels {

    public static NonNullBiConsumer<DataGenContext<Block, ActiveBlock>, RegistrateBlockstateProvider> createFireboxModel(ResourceLocation topTexture,
                                                                                                                         ResourceLocation sideTexture) {
        return (ctx, prov) -> {
            String name = ctx.getName();
            ActiveBlock block = ctx.getEntry();
            ModelFile inactive = prov.models().cubeBottomTop(name, sideTexture, topTexture, topTexture);
            ModelFile active = prov.models().withExistingParent(name + "_active", GTCEu.id("block/fire_box_active"))
                    .texture("side", sideTexture)
                    .texture("bottom", topTexture)
                    .texture("top", topTexture);
            prov.getVariantBuilder(block)
                    .partialState().with(GTBlockStateProperties.ACTIVE, false)
                    .modelForState().modelFile(inactive).addModel()
                    .partialState().with(GTBlockStateProperties.ACTIVE, true)
                    .modelForState().modelFile(active).addModel();
        };
    }
}

package com.puffofficial.ftecore;

import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;

import com.puffofficial.ftecore.common.data.FTECovers;
import com.puffofficial.ftecore.common.materials.FTEElements;
import com.puffofficial.ftecore.common.recipes.*;
import com.puffofficial.ftecore.common.recipes.lines.AlloyRecipes;
import com.puffofficial.ftecore.common.recipes.lines.AspectRecipes;
import com.puffofficial.ftecore.common.recipes.lines.PrimitiveRecipes;
import com.puffofficial.ftecore.common.recipes.lines.chemical.EthanolDehydrogenationLine;
import com.puffofficial.ftecore.common.recipes.lines.chemical.PolylacticAcidLine;

import java.util.function.Consumer;

@SuppressWarnings("unused")
@GTAddon
public class FTECoreGTAddon implements IGTAddon {

    @Override
    public GTRegistrate getRegistrate() {
        return FTECore.FTERegister;
    }

    @Override
    public void initializeAddon() {}

    @Override
    public String addonModId() {
        return FTECore.MOD_ID;
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        PrimitiveRecipes.init(provider);
        FTERecipes.init(provider);
        AlloyRecipes.init(provider);
        AspectRecipes.init(provider);
        ReplacementRecipes.init(provider);

        PolylacticAcidLine.init(provider);
        EthanolDehydrogenationLine.init(provider);
    }

    @Override
    public void removeRecipes(Consumer<ResourceLocation> consumer) {
        RemovedRecipes.init(consumer);
    }

    @Override
    public void registerElements() {
        IGTAddon.super.registerElements();
        FTEElements.init();
    }

    @Override
    public void registerCovers() {
        for (var cover : FTECovers.ALL_COVERS) {
            GTRegistries.COVERS.register(cover.getId(), cover);
        }
    }
}

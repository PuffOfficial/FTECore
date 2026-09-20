package com.puffofficial.ftecore;

import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

import com.puffofficial.ftecore.common.recipes.Alloys;
import net.minecraft.data.recipes.FinishedRecipe;

import com.puffofficial.ftecore.common.data.FTECovers;
import com.puffofficial.ftecore.common.data.materials.FTEElement;
import com.puffofficial.ftecore.common.recipes.FTERecipes;
import com.puffofficial.ftecore.common.recipes.ULVRecipes;

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
    public void registerTagPrefixes() {
        // CustomTagPrefixes.init();
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        ULVRecipes.init(provider);
        FTERecipes.init(provider);
        Alloys.init(provider);
    }

    @Override
    public void registerElements() {
        IGTAddon.super.registerElements();
        FTEElement.init();
    }

    @Override
    public void registerCovers() {
        for (var cover : FTECovers.ALL_COVERS) {
            GTRegistries.COVERS.register(cover.getId(), cover);
        }
    }
}

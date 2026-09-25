package com.puffofficial.ftecore.api.helpers;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;

import com.puffofficial.ftecore.FTECore;

public class MaterialHelper {

    public static Material registerFluidChemical(String name, String formula, int color) {
        return new Material.Builder(FTECore.id(name))
                .fluid()
                .color(color).iconSet(MaterialIconSet.DULL)
                .formula(formula)
                .buildAndRegister();
    }

    public static Material registerFluidChemical(String name, int color) {
        return new Material.Builder(FTECore.id(name))
                .fluid()
                .color(color).iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
    }

    public static Material registerFluidChemical(String name, String formula, int color, int temperature) {
        return new Material.Builder(FTECore.id(name))
                .liquid(temperature)
                .color(color).iconSet(MaterialIconSet.DULL)
                .formula(formula)
                .buildAndRegister();
    }

    public static Material registerGasChemical(String name, String formula, int color) {
        return new Material.Builder(FTECore.id(name))
                .gas()
                .color(color).iconSet(MaterialIconSet.DULL)
                .formula(formula)
                .buildAndRegister();
    }

    public static Material registerGasChemical(String name, int color) {
        return new Material.Builder(FTECore.id(name))
                .gas()
                .color(color).iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
    }

    public static Material registerGasChemical(String name, int color, int temperature) {
        return new Material.Builder(FTECore.id(name))
                .gas(temperature)
                .color(color).iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
    }

    public static Material registerDustChemical(String name, String formula, int color, int secondaryColor) {
        return new Material.Builder(FTECore.id(name))
                .dust()
                .color(color).secondaryColor(secondaryColor).iconSet(MaterialIconSet.DULL)
                .formula(formula)
                .buildAndRegister();
    }

    public static Material registerDustChemical(String name, String formula, int color) {
        return new Material.Builder(FTECore.id(name))
                .dust()
                .color(color).iconSet(MaterialIconSet.DULL)
                .formula(formula)
                .buildAndRegister();
    }

    public static Material registerDustChemical(String name, String formula, int color, Object... components) {
        return new Material.Builder(FTECore.id(name))
                .dust()
                .color(color).iconSet(MaterialIconSet.DULL)
                .formula(formula)
                .components(components)
                .buildAndRegister();
    }
}

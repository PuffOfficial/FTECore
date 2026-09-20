package com.puffofficial.ftecore.api.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.properties.IMaterialProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;

import com.puffofficial.ftecore.api.materials.properties.FuelRodProperty;

public class PropertyKeys<T extends IMaterialProperty> {

    public static final PropertyKey<FuelRodProperty> FUEL_ROD = new PropertyKey<>("fuel_rod", FuelRodProperty.class);
}

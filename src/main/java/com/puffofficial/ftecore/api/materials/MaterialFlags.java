package com.puffofficial.ftecore.api.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlag;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;

public class MaterialFlags {

    public static final MaterialFlag FUEL_ROD = new MaterialFlag.Builder("fuel_rod")
            .requireProps(PropertyKey.FLUID, PropertyKey.DUST)
            .build();
}

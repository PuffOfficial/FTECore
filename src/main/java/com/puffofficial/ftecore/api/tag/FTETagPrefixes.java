package com.puffofficial.ftecore.api.tag;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;

import com.puffofficial.ftecore.api.materials.FTEMaterialIconType;
import com.puffofficial.ftecore.api.materials.MaterialFlags;
import com.puffofficial.ftecore.api.materials.PropertyKeys;

import java.util.function.Predicate;

@SuppressWarnings("unused")
public class FTETagPrefixes {

    public static void init() {}

    public static class Conditions {

        public static final Predicate<Material> hasFuelRodProperty = mat -> mat.hasProperty(PropertyKeys.FUEL_ROD);
    }

    public static final TagPrefix singeFuelRod = new TagPrefix("fuelRod")
            .langValue("%s Fuel Rod")
            .defaultTagPath("fuel_rods/%s")
            .unformattedTagPath("fuel_rods")
            .materialAmount(GTValues.M)
            .materialIconType(FTEMaterialIconType.fuelRod)
            .unificationEnabled(false)
            .generateItem(true)
            .maxStackSize(1)
            .generationCondition(mat -> mat.hasFlag(MaterialFlags.FUEL_ROD));
}

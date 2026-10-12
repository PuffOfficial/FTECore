package com.puffofficial.ftecore.api.helpers;

import com.gregtechceu.gtceu.data.recipe.CustomTags;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

@SuppressWarnings("unchecked")
public class FTEValues {

    public static final TagKey<Item>[] VCT = new TagKey[] {
            CustomTags.ULV_CIRCUITS,
            CustomTags.LV_CIRCUITS,
            CustomTags.MV_CIRCUITS,
            CustomTags.HV_CIRCUITS,
            CustomTags.EV_CIRCUITS,
            CustomTags.IV_CIRCUITS,
            CustomTags.LuV_CIRCUITS,
            CustomTags.ZPM_CIRCUITS,
            CustomTags.UV_CIRCUITS,
            CustomTags.UHV_BATTERIES,
            CustomTags.UIV_CIRCUITS,
            CustomTags.UEV_CIRCUITS,
            CustomTags.UXV_CIRCUITS,
            CustomTags.OpV_CIRCUITS,
            CustomTags.MAX_CIRCUITS,
    };

    public static final int[] VC = {
            0x545454,
            0xA8A8A8,
            0x54FCFC,
            0xFCA800,
            0xA800A8,
            0x5454FC,
            0xFC54FC,
            0xFC5454,
            0x00A8A8,
            0xA80000,
            0x54FC54,
            0x00A800,
            0xFCFC54,
            0x5454FC,
            0xFC5454
    };

    public static final String[] romanNumbers = {
            "I",
            "II",
            "III",
            "IV",
            "V",
            "VI",
            "VII",
            "VIII",
            "IX",
            "X",
            "XI",
            "XII",
            "XIII",
            "XIV",
            "XV"
    };
}

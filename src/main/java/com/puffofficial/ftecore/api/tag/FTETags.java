package com.puffofficial.ftecore.api.tag;

import com.gregtechceu.gtceu.api.data.tag.TagUtil;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

@SuppressWarnings("unchecked")
public class FTETags {

    public static final TagKey<Item>[] CERTUS_CIRCUIT = new TagKey[] {
            TagUtil.createItemTag("certus_1"),
            TagUtil.createItemTag("certus_2"),
            TagUtil.createItemTag("certus_3"),
            TagUtil.createItemTag("certus_4"),
            TagUtil.createItemTag("certus_5")
    };
}

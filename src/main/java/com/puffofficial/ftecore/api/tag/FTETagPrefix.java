package com.puffofficial.ftecore.api.tag;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class FTETagPrefix {

    public static final TagPrefix oreBedrock = TagPrefix.oreTagPrefix("bedrock", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("%s Bedrock Ore")
            .registerOre(
                    Blocks.BEDROCK::defaultBlockState, () -> GTMaterials.Stone, BlockBehaviour.Properties.of()
                            .mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(15.0F,15.0F),
                    ResourceLocation.withDefaultNamespace("block/bedrock"),false,false,false);

    public static void init() {}
}

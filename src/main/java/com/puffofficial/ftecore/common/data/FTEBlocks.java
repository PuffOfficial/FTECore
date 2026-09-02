package com.puffofficial.ftecore.common.data;

import com.gregtechceu.gtceu.data.recipe.CustomTags;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import com.puffofficial.ftecore.FTECore;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiFunction;

public class FTEBlocks {

    public static void init() {}

    static {
        FTECore.FTERegister.creativeModeTab(() -> FTECreativeModeTabs.FTE_BLOCK_CREATIVE_TAB);
    }

    // All the casing stuff
    public static final BlockEntry<Block> SOLID_WROUGHT_IRON_CASING = createSimpleCasing(
            "§8Solid Wrought Iron Casing", "solid_wrought_iron_casing", "solid_wrought_iron_casing", BlockItem::new);

    public static BlockEntry<Block> createSimpleCasing(String name, String id, String texture,
                                                       NonNullBiFunction<Block, Item.Properties, ? extends BlockItem> func) {
        return FTECore.FTERegister
                .block(id, Block::new)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false)
                        .strength(5.0f, 6.0f)
                        .requiresCorrectToolForDrops())
                .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(),
                        prov.models().cubeAll(ctx.getName(), FTECore.id("block/casings/solid/" + texture))))
                .lang(name)
                .item(func)
                .build()
                .register();
    }
}

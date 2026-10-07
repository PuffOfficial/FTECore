package com.puffofficial.ftecore.api.helpers;

import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.data.models.FTEModels;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiFunction;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class BlockHelper {

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

    public static BlockEntry<ActiveBlock> createFirebox(String name, String id, ResourceLocation topTexture,
                                                        ResourceLocation sideTexture) {
        return FTECore.FTERegister
                .block(id, ActiveBlock::new)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(FTEModels.createFireboxModel(topTexture, sideTexture))
                .lang(name)
                .tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH)
                .item(BlockItem::new)
                .build()
                .register();
    }
}

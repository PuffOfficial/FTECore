package com.puffofficial.ftecore.common.data;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.data.recipe.CustomTags;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.data.models.FTEModels;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiFunction;

public class FTEBlocks {

    static {
        FTECore.FTERegister.creativeModeTab(() -> FTECreativeModeTabs.BLOCKS);
    }

    // All the casing stuff
    public static final BlockEntry<Block> SOLID_WROUGHT_IRON_CASING = createSimpleCasing(
            "§8Solid Wrought Iron Casing", "solid_wrought_iron_casing", "solid_wrought_iron_casing", Blocks.IRON_BLOCK,
            BlockItem::new);

    // Fireboxes
    public static final BlockEntry<ActiveBlock> WROUGHT_IRON_FIREBOX = createFirebox(
            "Wrought Iron Firebox", "wrought_iron_firebox", FTECore.id("block/casings/solid/solid_wrought_iron_casing"),
            GTCEu.id("block/casings/firebox/machine_casing_firebox_steel"));

    public static BlockEntry<Block> createSimpleCasing(String name, String id, String texture, Block initialProperty,
                                                       NonNullBiFunction<Block, Item.Properties, ? extends BlockItem> func) {
        return FTECore.FTERegister
                .block(id, Block::new)
                .initialProperties(() -> initialProperty)
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

    public static void init() {}
}

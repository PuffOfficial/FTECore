package com.puffofficial.ftecore.common;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.block.ActiveBlock;

import com.puffofficial.ftecore.common.data.FTECreativeModeTabs;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MapColor;

import com.puffofficial.ftecore.FTECore;
import com.tterrag.registrate.util.entry.BlockEntry;

import static com.puffofficial.ftecore.api.helpers.BlockHelper.*;

public class FTEBlocks {

    static {
        FTECore.FTERegister.creativeModeTab(() -> FTECreativeModeTabs.BLOCKS);
    }

    // All the casing stuff
    public static final BlockEntry<Block> SOLID_WROUGHT_IRON_CASING = createSimpleCasing(
            "Solid Wrought Iron Casing", "solid_wrought_iron_casing", "solid/solid_wrought_iron_casing",
            BlockItem::new);
    public static final BlockEntry<Block> CORRUPTION_PROOF_TITANIUM_NOCTITE_CASING = createSimpleCasing(
            "Corruption Proof Titanium Noctite Casing", "corruption_proof_titanium_noctite_casing",
            "solid/corruption_proof_titanium_noctite_casing",
            BlockItem::new);
    public static final BlockEntry<Block> RADIATION_RESISTANT_CASING = createSimpleCasing(
            "Radiation Resistant Casing", "radiation_resistant_casing", "solid/radiation_resistant_casing",
            BlockItem::new);
    public static final BlockEntry<Block> FRAMED_TREATED_WOOD_PLANKS = createSimpleCasing(
            "Framed Treated Wood Planks", "framed_treated_wood_planks", "wood/framed_treated_wood_planks_casing",
            BlockItem::new);
    public static final BlockEntry<Block> MANASTEEL_PLATED_LIVINGROCK_BRICKS = createSimpleCasing(
            "Manasteel Plated Livingrock bricks", "manasteel_plated_livingstone_bricks", "solid/manasteel_plated_livingrock_casing",
            BlockItem::new);
    public static final BlockEntry<Block> TERRASTEEL_PLATED_LIVINGWOOD_PLANKS = createSimpleCasing(
            "Terrasteel Plated Livingwood Planks", "terrasteel_plated_livingwood_planks", "wood/terrasteel_plated_livingwood_casing",
            BlockItem::new);

    // Fireboxes
    public static final BlockEntry<ActiveBlock> WROUGHT_IRON_FIREBOX = createFirebox(
            "Wrought Iron Firebox", "wrought_iron_firebox", FTECore.id("block/casings/solid/solid_wrought_iron_casing"),
            GTCEu.id("block/casings/firebox/machine_casing_firebox_steel"));

    public static final BlockEntry<Block> PORCELAIN_BRICKS = FTECore.FTERegister
            .block("porcelain_bricks", Block::new)
            .initialProperties(() -> Blocks.BRICKS)
            .lang("Porcelain Bricks")
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_GRAY))// matches IE treated wood tag
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .item()
            .build()
            .register();

    public static void init() {}
}

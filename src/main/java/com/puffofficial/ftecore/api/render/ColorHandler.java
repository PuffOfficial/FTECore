package com.puffofficial.ftecore.api.render;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;

import net.minecraft.util.Mth;

import vazkii.botania.client.core.handler.ClientTickHandler;
import vazkii.botania.client.render.ColorHandler.BlockHandlerConsumer;
import vazkii.botania.client.render.ColorHandler.ItemHandlerConsumer;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.puffofficial.ftecore.common.data.materials.lines.BotaniaMaterials.*;

public class ColorHandler {

    public static void colorGradientItems(ItemHandlerConsumer consumer) {
        consumer.register(
                (s, t) -> t == 0 ? Mth.hsvToRgb(ClientTickHandler.ticksInGame * 2 % 360 / 360F, 0.25F, 1F) : 1,
                () -> ChemicalHelper.get(plate, Gaia).getItem(),
                () -> ChemicalHelper.get(plateDense, Gaia).getItem(),
                () -> ChemicalHelper.get(plateDouble, Gaia).getItem(),
                () -> ChemicalHelper.get(rod, Gaia).getItem(),
                () -> ChemicalHelper.get(dust, Gaia).getItem(),
                () -> ChemicalHelper.get(dustSmall, Gaia).getItem(),
                () -> ChemicalHelper.get(dustTiny, Gaia).getItem(),
                () -> ChemicalHelper.get(screw, Gaia).getItem(),
                () -> ChemicalHelper.get(bolt, Gaia).getItem(),
                () -> ChemicalHelper.get(nugget, Gaia).getItem(),
                () -> ChemicalHelper.get(block, Gaia).getItem());
    }

    public static void colorGradientBlocks(BlockHandlerConsumer consumer) {
        consumer.register(
                (state, world, pos, tintIndex) -> {
                    float time = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks;
                    return Mth.hsvToRgb(time * 5 % 360 / 360F, 0.4F, 0.9F);
                },
                ChemicalHelper.getBlock(block, Gaia));
    }
}

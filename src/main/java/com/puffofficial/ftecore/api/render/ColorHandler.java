package com.puffofficial.ftecore.api.render;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;

import net.minecraft.util.Mth;

import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import vazkii.botania.client.core.handler.ClientTickHandler;

import java.awt.*;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.puffofficial.ftecore.common.materials.lines.BotaniaMaterials.*;

public class ColorHandler {

    public static void colorGradientItems(RegisterColorHandlersEvent.Item consumer) {
        consumer.register(
                (pStack, pTintIndex) -> pTintIndex == 0 ? Mth.hsvToRgb(ClientTickHandler.ticksInGame * 2 % 360 / 360F, 0.25F, 1F) : 1,
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

    public static void colorGradientBlocks(RegisterColorHandlersEvent.Block consumer) {
        consumer.register(
                (state, world, pos, tintIndex) -> {
                    float time = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks;
                    return Mth.hsvToRgb(time * 5 % 360 / 360F, 0.25F, 1F);
                },
                ChemicalHelper.getBlock(block, Gaia));
    }
}

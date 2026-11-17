package com.puffofficial.ftecore.data.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.puffofficial.ftecore.FTECore;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = FTECore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
@OnlyIn(Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onTooltipEvent(ItemTooltipEvent event) {
        TooltipHandler.appendTooltips(event.getItemStack(), event.getFlags(), event.getToolTip());
    }
}

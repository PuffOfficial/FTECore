package com.puffofficial.ftecore.init;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.api.render.ColorHandler;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = FTECore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSubscribe {

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        ColorHandler.colorGradientItems(event::register);
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        ColorHandler.colorGradientBlocks(event::register);
    }
}

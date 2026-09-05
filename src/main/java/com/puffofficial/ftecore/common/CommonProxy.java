package com.puffofficial.ftecore.common;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.common.data.FTEBlocks;
import com.puffofficial.ftecore.common.data.FTECreativeModeTabs;
import com.puffofficial.ftecore.common.data.materials.FTEMaterials;
import com.puffofficial.ftecore.common.machine.FTEPrimitiveMachines;
import com.puffofficial.ftecore.data.lang.FTELangHandler;
import com.tterrag.registrate.providers.ProviderType;

import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class CommonProxy {

    public static void init() {

        FTECore.FTERegister.addDataGenerator(ProviderType.LANG, FTELangHandler::init);
        FTEBlocks.init();
        FTECreativeModeTabs.init();
    }

}

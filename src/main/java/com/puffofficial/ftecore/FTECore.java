package com.puffofficial.ftecore;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.api.sound.SoundEntry;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.puffofficial.ftecore.api.tag.FTETagPrefixes;
import com.puffofficial.ftecore.common.data.FTEBlocks;
import com.puffofficial.ftecore.common.data.FTECreativeModeTabs;
import com.puffofficial.ftecore.common.data.FTEItems;
import com.puffofficial.ftecore.common.data.materials.FTEMaterials;
import com.puffofficial.ftecore.common.data.materials.lines.BotaniaMaterials;
import com.puffofficial.ftecore.common.data.materials.lines.ChemistryMaterials;
import com.puffofficial.ftecore.common.data.materials.lines.RootsMaterials;
import com.puffofficial.ftecore.common.machine.FTEPrimitiveMachines;
import com.puffofficial.ftecore.common.machine.FTERecipeTypes;
import com.puffofficial.ftecore.data.lang.FTELangHandler;
import com.tterrag.registrate.providers.ProviderType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(FTECore.MOD_ID)
@SuppressWarnings("removal")
public class FTECore {

    public static final String MOD_ID = "ftecore";
    public static final Logger LOGGER = LogManager.getLogger();
    public static GTRegistrate FTERegister = GTRegistrate.create(FTECore.MOD_ID);

    public FTECore() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        modEventBus.addListener(this::addMaterialRegistries);
        modEventBus.addListener(this::addMaterials);
        modEventBus.addListener(this::modifyMaterials);

        modEventBus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
        modEventBus.addGenericListener(MachineDefinition.class, this::registerMachines);
        modEventBus.addGenericListener(SoundEntry.class, this::registerSounds);

        MinecraftForge.EVENT_BUS.register(this);

        FTERegister.registerRegistrate();

        FTECore.FTERegister.addDataGenerator(ProviderType.LANG, FTELangHandler::init);

        init();
    }

    private void init() {
        FTEBlocks.init();
        FTECreativeModeTabs.init();
        FTEItems.init();
        FTETagPrefixes.init();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            LOGGER.info("Hello from common setup! This is *after* registries are done, so we can do this:");
            LOGGER.info("Look, I found a {}!", Items.DIAMOND);
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Hey, we're on Minecraft version {}!", Minecraft.getInstance().getLaunchedVersion());
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    private void addMaterialRegistries(MaterialRegistryEvent event) {
        GTCEuAPI.materialManager.createRegistry(FTECore.MOD_ID);
    }

    private void modifyMaterials(PostMaterialEvent event) {}

    private void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        FTERecipeTypes.init();
    }

    private void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        FTEPrimitiveMachines.init();
    }

    private void addMaterials(MaterialEvent event) {
        ChemistryMaterials.init();
        BotaniaMaterials.init();
        RootsMaterials.init();
        FTEMaterials.init();
    }

    public void registerSounds(GTCEuAPI.RegisterEvent<ResourceLocation, SoundEntry> event) {
        // CustomSounds.init();
    }
}

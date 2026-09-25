package com.puffofficial.ftecore.common.data.materials.lines;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;

import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.common.data.FTECreativeModeTabs;
import com.puffofficial.ftecore.common.data.materials.FTEElements;
import com.puffofficial.ftecore.common.data.materials.FTEIconsets;
import vazkii.botania.common.block.BotaniaBlocks;
import vazkii.botania.common.item.BotaniaItems;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;

public class BotaniaMaterials {

    static {
        FTECore.FTERegister.creativeModeTab(() -> FTECreativeModeTabs.MATERIALS);
    }

    public static Material Manasteel, Elementium, Terrasteel, Gaia;

    public static void init() {
        Manasteel = new Material.Builder(FTECore.id("manasteel"))
                .ingot()
                .iconSet(FTEIconsets.MANASTEEL)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_DENSE, GENERATE_BOLT_SCREW)
                .formula("ᛗFe")
                .buildAndRegister();
        TagPrefix.ingot.setIgnored(Manasteel, () -> BotaniaItems.manaSteel);
        TagPrefix.nugget.setIgnored(Manasteel, () -> BotaniaItems.manasteelNugget);
        TagPrefix.block.setIgnored(Manasteel, () -> BotaniaBlocks.manasteelBlock);

        Elementium = new Material.Builder(FTECore.id("elementium"))
                .ingot()
                .iconSet(FTEIconsets.ELEMENTIUM)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_DENSE, GENERATE_BOLT_SCREW)
                .element(FTEElements.Elementium)
                .buildAndRegister();
        TagPrefix.ingot.setIgnored(Elementium, () -> BotaniaItems.elementium);
        TagPrefix.nugget.setIgnored(Elementium, () -> BotaniaItems.elementiumNugget);
        TagPrefix.block.setIgnored(Elementium, () -> BotaniaBlocks.elementiumBlock);

        Terrasteel = new Material.Builder(FTECore.id("terrasteel"))
                .ingot()
                .iconSet(FTEIconsets.TERRASTEEL)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_DENSE, GENERATE_BOLT_SCREW)
                .element(FTEElements.Terrasteel)
                .buildAndRegister();
        TagPrefix.ingot.setIgnored(Terrasteel, () -> BotaniaItems.terrasteel);
        TagPrefix.nugget.setIgnored(Terrasteel, () -> BotaniaItems.terrasteelNugget);
        TagPrefix.block.setIgnored(Terrasteel, () -> BotaniaBlocks.terrasteelBlock);

        Gaia = new Material.Builder(FTECore.id("gaia"))
                .ingot()
                .langValue("Gaia Spirit")
                .iconSet(FTEIconsets.GAIA)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_DENSE, GENERATE_BOLT_SCREW)
                .buildAndRegister();
        TagPrefix.ingot.setIgnored(Gaia, () -> BotaniaItems.gaiaIngot);
    }
}

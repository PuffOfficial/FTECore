package com.puffofficial.ftecore.data.handlers;

import com.gregtechceu.gtceu.common.data.GTMaterialItems;

import net.minecraftforge.common.Tags;

import com.tterrag.registrate.providers.RegistrateItemTagsProvider;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.puffofficial.ftecore.common.materials.FTEMaterials.*;

@SuppressWarnings("DataFlowIssue")
public class FTETagHandler {

    public static void itemInit(RegistrateItemTagsProvider provider) {
        provider.addTag(Tags.Items.GEMS_AMETHYST)
                .add(GTMaterialItems.MATERIAL_ITEMS.get(gem, ArtificialAmethyst).get());
    }
}

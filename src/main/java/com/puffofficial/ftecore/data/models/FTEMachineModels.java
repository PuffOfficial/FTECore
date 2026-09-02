package com.puffofficial.ftecore.data.models;

import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.common.data.models.GTMachineModels;

import net.minecraft.resources.ResourceLocation;

import com.puffofficial.ftecore.FTECore;

import static com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties.*;

public class FTEMachineModels {

    public static final ResourceLocation PRIMITIVE_MAINTENANCE_TAPED_OVERLAY = FTECore
            .id("block/overlay/machine/primitive_maintenance_hatch_taped");

    public static MachineBuilder.ModelInitializer createPrimitiveMaintenanceModel(ResourceLocation overlayModel) {
        return (ctx, prov, builder) -> {
            builder.forAllStatesModels(state -> {
                var baseModel = prov.models().nested()
                        .parent(prov.models().getExistingFile(overlayModel));
                GTMachineModels.tieredHullTextures(baseModel, builder.getOwner().getTier());

                if (state.getValue(IS_TAPED)) {
                    baseModel.texture("overlay_2", PRIMITIVE_MAINTENANCE_TAPED_OVERLAY);
                }
                return baseModel;
            });

            builder.addReplaceableTextures("bottom", "top", "side");
        };
    }
}

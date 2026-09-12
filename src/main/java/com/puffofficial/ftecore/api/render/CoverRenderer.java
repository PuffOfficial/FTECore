package com.puffofficial.ftecore.api.render;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.client.renderer.cover.ICoverRenderer;
import com.gregtechceu.gtceu.client.renderer.cover.IOCoverRenderer;

public class CoverRenderer {

    public static ICoverRenderer ROBOT_ARM_RENDERER = new IOCoverRenderer(
            GTCEu.id("block/cover/arm"),
            null,
            GTCEu.id("block/cover/arm_emissive"),
            GTCEu.id("block/cover/arm_inverted_emissive"));

    public static ICoverRenderer CONVEYOR_RENDERER = new IOCoverRenderer(
            GTCEu.id("block/cover/conveyor"),
            null,
            GTCEu.id("block/cover/conveyor_emissive"),
            GTCEu.id("block/cover/conveyor_inverted_emissive"));
}

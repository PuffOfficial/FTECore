package com.puffofficial.ftecore.common.data;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.network.chat.Component;

public class FTETooltips {

    public static List<Component> primitiveMultiblockTooltips(int parallelAmount) {
        List<Component> components = new ArrayList<>();

        components.add(Component.translatable("fte.components.ulv_multiblock"));
        components.add(Component.translatable("fte.components.ulv_multiblock_parallels","§5"+parallelAmount));

        return components;
    }
}

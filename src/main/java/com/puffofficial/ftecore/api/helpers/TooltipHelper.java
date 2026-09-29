package com.puffofficial.ftecore.api.helpers;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;

public class TooltipHelper {
    public static Component defaultParallelTooltip(int parallels) {
        MutableComponent formattedParallels = Component.literal(String.valueOf(parallels)).setStyle(Style.EMPTY.withColor(ChatFormatting.WHITE));
        return Component.translatable("fte.components.tooltip.default_parallels", formattedParallels);
    }
}

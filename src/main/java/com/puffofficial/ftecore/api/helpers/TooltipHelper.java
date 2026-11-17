package com.puffofficial.ftecore.api.helpers;

import com.gregtechceu.gtceu.common.cover.ConveyorCover;
import com.gregtechceu.gtceu.utils.FormattingUtil;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.puffofficial.ftecore.api.helpers.FTEValues.romanNumbers;

public class TooltipHelper {

    private static final Logger log = LoggerFactory.getLogger(TooltipHelper.class);

    public static Component defaultParallelTooltip(int parallelAmount, Boolean isWithEu) {
        MutableComponent formattedParallels = Component.literal(String.valueOf(parallelAmount))
                .setStyle(Style.EMPTY.withColor(ChatFormatting.WHITE));
        Component textComponent;

        if (isWithEu) {
            textComponent = Component.translatable("fte.components.tooltip.default_parallels", "§5" + parallelAmount);
        } else {
            textComponent = Component.translatable("fte.components.tooltip.default_parallels_without_eu",
                    "§5" + parallelAmount);
        }

        return textComponent;
    }

    public static Component itemRateTooltip(int tier) {
        var itemsPerSecond = ConveyorCover.CONVEYOR_SCALING.applyAsInt(tier);
        return itemsPerSecond > 64 ?
                Component.translatable("gtceu.universal.tooltip.item_transfer_rate_stacks", itemsPerSecond / 64) :
                Component.translatable("gtceu.universal.tooltip.item_transfer_rate", itemsPerSecond);
    }

    public static Component ulvFluidRateTooltip() {
        return Component.translatable("gtceu.universal.tooltip.fluid_transfer_rate",
                FormattingUtil.formatNumbers(32));
    }

    public static List<Component> primitiveMultiblockTooltips(int parallelAmount) {
        List<Component> components = new ArrayList<>();

        components.add(Component.translatable("fte.components.ulv_multiblock"));
        components.add(Component.translatable("fte.components.ulv_multiblock_parallels", "§5" + parallelAmount));

        return components;
    }

    public static MutableComponent circuitTooltip(int tier, String type) {
        return Component.literal(
                Component.translatable("fte.components.tooltip.circuit_type." + type, romanNumbers[tier]).getString())
                .withStyle(ChatFormatting.DARK_GRAY);
    }
}

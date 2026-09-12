package com.puffofficial.ftecore.common.data;

import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.IComponentItem;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import com.gregtechceu.gtceu.common.cover.ConveyorCover;
import com.gregtechceu.gtceu.common.item.CoverPlaceBehavior;
import com.gregtechceu.gtceu.common.item.TooltipBehavior;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.utils.FormattingUtil;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

import com.puffofficial.ftecore.FTECore;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;

public class FTEItems {

    static {
        FTECore.FTERegister.creativeModeTab(() -> FTECreativeModeTabs.ITEMS);
    }

    public static ItemEntry<Item> ELECTRIC_MOTOR_ULV = FTECore.FTERegister.item("ulv_electric_motor", Item::new)
            .lang("ULV Electric Motor")
            .tag(CustomTags.ELECTRIC_MOTORS)
            .register();
    public static ItemEntry<Item> ELECTRIC_PISTON_ULV = FTECore.FTERegister.item("ulv_electric_piston", Item::new)
            .lang("ULV Electric Piston")
            .tag(CustomTags.ELECTRIC_MOTORS)
            .register();

    public static ItemEntry<ComponentItem> ROBOT_ARM_ULV = FTECore.FTERegister
            .item("ulv_robot_arm", ComponentItem::create)
            .lang("ULV Robot Arm")
            .onRegister(attach(new CoverPlaceBehavior(FTECovers.ULV_ROBOT_ARM)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.robot.arm.tooltip"));
                lines.add(itemRateTooltip(0));
            })))
            .tag(CustomTags.ROBOT_ARMS)
            .register();

    public static ItemEntry<ComponentItem> CONVEYOR_MODULE_ULV = FTECore.FTERegister
            .item("ulv_conveyor_module", ComponentItem::create)
            .lang("ULV Conveyor Module")
            .onRegister(attach(new CoverPlaceBehavior(FTECovers.ULV_CONVEYOR)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.conveyor.module.tooltip"));
                lines.add(itemRateTooltip(0));
            })))
            .tag(CustomTags.CONVEYOR_MODULES)
            .register();

    public static ItemEntry<ComponentItem> ELECTRIC_PUMP_ULV = FTECore.FTERegister
            .item("ulv_electric_pump", ComponentItem::create)
            .lang("ULV Electric Pump")
            .onRegister(attach(new CoverPlaceBehavior(FTECovers.ULV_PUMP)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.electric.pump.tooltip"));
                lines.add(ulvFluidRateTooltip());
            })))
            .tag(CustomTags.ELECTRIC_PUMPS)
            .register();

    public static <T extends IComponentItem> NonNullConsumer<T> attach(IItemComponent components) {
        return item -> item.attachComponents(components);
    }

    private static Component itemRateTooltip(int tier) {
        var itemsPerSecond = ConveyorCover.CONVEYOR_SCALING.applyAsInt(tier);
        return itemsPerSecond > 64 ?
                Component.translatable("gtceu.universal.tooltip.item_transfer_rate_stacks", itemsPerSecond / 64) :
                Component.translatable("gtceu.universal.tooltip.item_transfer_rate", itemsPerSecond);
    }

    private static Component ulvFluidRateTooltip() {
        return Component.translatable("gtceu.universal.tooltip.fluid_transfer_rate",
                FormattingUtil.formatNumbers(32));
    }

    public static void init() {}
}

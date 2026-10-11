package com.puffofficial.ftecore.common.data;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.IComponentItem;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import com.gregtechceu.gtceu.common.item.CoverPlaceBehavior;
import com.gregtechceu.gtceu.common.item.TooltipBehavior;
import com.gregtechceu.gtceu.data.recipe.CustomTags;

import com.puffofficial.ftecore.api.helpers.TooltipHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.api.helpers.ColorHelper;
import com.puffofficial.ftecore.api.helpers.FTEValues;
import com.puffofficial.ftecore.data.models.FTEModels;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import com.tterrag.registrate.util.nullness.NonNullConsumer;

@SuppressWarnings("unchecked")
public class FTEItems {

    private static final String infinityName = "<neon p=8 r=2 a=0.15><rainb>Infinity</rainb></neon>";

    static {
        FTECore.FTERegister.creativeModeTab(() -> FTECreativeModeTabs.ITEMS);
    }

    public static ItemEntry<Item> STONE_STICK = FTECore.FTERegister.item("stone_stick", Item::new)
            .lang("Stone Stick")
            .register();
    public static ItemEntry<Item> P_CREDIT = FTECore.FTERegister.item("p_credit", Item::new)
            .lang("P-Credit")
            .register();
    public static ItemEntry<Item> KNITTING_KNIT = FTECore.FTERegister.item("knitting_kit", Item::new)
            .lang("Knitting Kit")
            .properties(p -> p.durability(9))
            .register();
    public static ItemEntry<Item> MESH_CHUNK = FTECore.FTERegister.item("mesh_chunk", Item::new)
            .lang("Mesh Chunk")
            .register();
    public static ItemEntry<Item> COMPRESSED_PORCELAIN_CLAY = FTECore.FTERegister
            .item("compressed_porcelain_clay", Item::new)
            .lang("Compressed Porcelain Clay")
            .register();
    public static ItemEntry<Item> PORCELAIN_BRICK = FTECore.FTERegister.item("porcelain_brick", Item::new)
            .lang("Porcelain Brick")
            .register();
    public static ItemEntry<Item> ALFHEIM_RUNES = FTECore.FTERegister.item("alfheim_runes", Item::new)
            .lang("Alfheim Runes")
            .register();

    public static ItemEntry<Item> RANDOM_ACCESS_MEMORY_STICK = FTECore.FTERegister.item("ram_stick", Item::new)
            .lang("RAM Stick")
            .register();
    public static ItemEntry<Item> RANDOM_ACCESS_MEMORY_MAINFRAME = FTECore.FTERegister.item("ram_mainframe", Item::new)
            .lang("RAM Mainframe")
            .properties(p -> p.stacksTo(4))
            .register();

    public static ItemEntry<Item> STARGATE_COIL = FTECore.FTERegister.item("stargate_coil", Item::new)
            .lang("Stargate Coil")
            .register();
    public static ItemEntry<Item> STARGATE_CHEVRON = FTECore.FTERegister.item("stargate_chevron", Item::new)
            .lang("Stargate Chevron")
            .register();
    public static ItemEntry<Item> STARGATE_COMPUTATION_MAINFRAME = FTECore.FTERegister
            .item("stargate_computation_mainframe", Item::new)
            .lang("Stargate Computation Mainframe")
            .properties(p -> p.stacksTo(1))
            .register();

    public static ItemEntry<Item> STONE_SPADE = FTECore.FTERegister.item("stone_spade", Item::new)
            .lang("Stone Spade")
            .properties(p -> p.durability(64))
            .register();

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
                lines.add(TooltipHelper.itemRateTooltip(0));
            })))
            .tag(CustomTags.ROBOT_ARMS)
            .register();

    public static ItemEntry<ComponentItem> CONVEYOR_MODULE_ULV = FTECore.FTERegister
            .item("ulv_conveyor_module", ComponentItem::create)
            .lang("ULV Conveyor Module")
            .onRegister(attach(new CoverPlaceBehavior(FTECovers.ULV_CONVEYOR)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.conveyor.module.tooltip"));
                lines.add(TooltipHelper.itemRateTooltip(0));
            })))
            .tag(CustomTags.CONVEYOR_MODULES)
            .register();

    public static ItemEntry<ComponentItem> ELECTRIC_PUMP_ULV = FTECore.FTERegister
            .item("ulv_electric_pump", ComponentItem::create)
            .lang("ULV Electric Pump")
            .onRegister(attach(new CoverPlaceBehavior(FTECovers.ULV_PUMP)))
            .onRegister(attach(new TooltipBehavior(lines -> {
                lines.add(Component.translatable("item.gtceu.electric.pump.tooltip"));
                lines.add(TooltipHelper.ulvFluidRateTooltip());
            })))
            .tag(CustomTags.ELECTRIC_PUMPS)
            .register();

    public static ItemEntry<Item>[] UNIVERSAL_CIRCUITS = new ItemEntry[GTValues.TIER_COUNT];

    static {
        for (int tier : GTValues.ALL_TIERS) {
            UNIVERSAL_CIRCUITS[tier] = makeUniversalCircuit(tier);
        }
    }

    public static <T extends IComponentItem> NonNullConsumer<T> attach(IItemComponent components) {
        return item -> item.attachComponents(components);
    }

    public static ItemEntry<Item> INFINITY_PLATE = makeMaterialItem("infinity_plate", infinityName + " Plate");
    public static ItemEntry<Item> INFINITY_DOUBLE_PLATE = makeMaterialItem("infinity_double_plate",
            "Double " + infinityName + " Plate");
    public static ItemEntry<Item> INFINITY_ROD = makeMaterialItem("infinity_rod", infinityName + " Rod");
    public static ItemEntry<Item> INFINITY_GEAR = makeMaterialItem("infinity_plate", infinityName + " Plate");
    public static ItemEntry<Item> INFINITY_SMALL_GEAR = makeMaterialItem("infinity_small_gear",
            "Small " + infinityName + " Gear");
    public static ItemEntry<Item> INFINITY_BOLT = makeMaterialItem("infinity_bolt", infinityName + " Bolt");
    public static ItemEntry<Item> INFINITY_SCREW = makeMaterialItem("infinity_screw", infinityName + " Screw");
    public static ItemEntry<Item> INFINITY_DUST = makeMaterialItem("infinity_dust", infinityName + " Dust");
    public static ItemEntry<Item> INFINITY_SMALL_DUST = makeMaterialItem("infinity_small_dust",
            "Small Pile of " + infinityName + " Dust");
    public static ItemEntry<Item> INFINITY_TINY_DUST = makeMaterialItem("infinity_tiny_dust",
            "Tiny Pile of " + infinityName + " Dust");
    public static ItemEntry<Item> INFINITY_RING = makeMaterialItem("infinity_ring", infinityName + " Ring");
    public static ItemEntry<Item> INFINITY_DENSE_PLATE = makeMaterialItem("infinity_dense_plate",
            "Dense " + infinityName + " Plate");

    private static ItemEntry<Item> makeMaterialItem(String name, String lang) {
        return FTECore.FTERegister
                .item(name, Item::new)
                .lang(lang)
                .model(NonNullBiConsumer.noop())
                .register();
    }

    private static ItemEntry<Item> makeUniversalCircuit(int tier) {
        return FTECore.FTERegister
                .item(GTValues.VN[tier].toLowerCase() + "_universal_circuit", Item::new)
                .lang(GTValues.VNF[tier] + " Universal Circuit")
                .tag(FTEValues.VCT[tier])
                .model((ctx, prov) -> FTEModels.itemModelFromFile(ctx, prov,
                        FTECore.id("item/components/universal_circuit")))
                .color(ColorHelper.itemTintFromHex(FTEValues.VC[tier], 1))
                .register();
    }

    public static void init() {}
}

package com.puffofficial.ftecore.common;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.IComponentItem;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import com.gregtechceu.gtceu.common.item.CoverPlaceBehavior;
import com.gregtechceu.gtceu.common.item.TooltipBehavior;
import com.gregtechceu.gtceu.data.recipe.CustomTags;

import com.puffofficial.ftecore.api.helpers.TooltipHelper;
import com.puffofficial.ftecore.api.tag.FTETags;
import com.puffofficial.ftecore.common.data.FTECovers;
import com.puffofficial.ftecore.common.data.FTECreativeModeTabs;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

import com.puffofficial.ftecore.FTECore;
import com.puffofficial.ftecore.api.helpers.ColorHelper;
import com.puffofficial.ftecore.api.helpers.FTEValues;
import com.puffofficial.ftecore.data.models.FTEModels;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;

@SuppressWarnings("unchecked")
public class FTEItems {

    static {
        FTECore.FTERegister.creativeModeTab(() -> FTECreativeModeTabs.ITEMS);
    }

    public static ItemEntry<Item> P_CREDIT = FTECore.FTERegister.item("p_credit", Item::new)
            .lang("P-Credit")
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

    // Universal circuit stuff
    public static ItemEntry<Item>[] UNIVERSAL_CIRCUITS = new ItemEntry[GTValues.TIER_COUNT];

    static {
        for (int tier : GTValues.ALL_TIERS) {
            UNIVERSAL_CIRCUITS[tier] = makeUniversalCircuit(tier);
        }
    }

    // Circuit stuff

    public static ItemEntry<Item> CERTUS_CHIP = FTECore.FTERegister
            .item("certus_chip", Item::new)
            .lang("Certus Chip")
            .model(FTEModels.itemModelFromTexture(FTECore.id("item/circuit/certus/chip")))
            .tag(FTETags.CERTUS_CIRCUIT[0])
            .register();
    public static ItemEntry<Item> BASIC_CERTUS_CIRCUIT = FTECore.FTERegister
            .item("basic_certus_circuit", Item::new)
            .lang("Basic Certus Circuit")
            .model(FTEModels.itemModelFromTexture(FTECore.id("item/circuit/certus/basic")))
            .tag(FTETags.CERTUS_CIRCUIT[1])
            .register();
    public static ItemEntry<Item> GOOD_CERTUS_CIRCUIT = FTECore.FTERegister
            .item("good_certus_circuit", Item::new)
            .lang("Good Certus Circuit")
            .model(FTEModels.itemModelFromTexture(FTECore.id("item/circuit/certus/good")))
            .tag(FTETags.CERTUS_CIRCUIT[2])
            .register();
    public static ItemEntry<Item> ADVANCED_CERTUS_CIRCUIT = FTECore.FTERegister
            .item("advanced_certus_circuit", Item::new)
            .lang("Advanced Certus Circuit")
            .model(FTEModels.itemModelFromTexture(FTECore.id("item/circuit/certus/advanced")))
            .tag(FTETags.CERTUS_CIRCUIT[3])
            .register();

    public static ItemEntry<Item> FLUIX_CHIP = FTECore.FTERegister
            .item("fluix_chip", Item::new)
            .lang("Fluix Chip")
            .model(FTEModels.itemModelFromTexture(FTECore.id("item/circuit/fluix/chip")))
            .tag(FTETags.CERTUS_CIRCUIT[1])
            .register();
    public static ItemEntry<Item> BASIC_FLUIX_CIRCUIT = FTECore.FTERegister
            .item("basic_fluix_circuit", Item::new)
            .lang("Basic Fluix Circuit")
            .model(FTEModels.itemModelFromTexture(FTECore.id("item/circuit/fluix/basic")))
            .tag(FTETags.CERTUS_CIRCUIT[2])
            .register();
    public static ItemEntry<Item> ADVANCED_FLUIX_CIRCUIT = FTECore.FTERegister
            .item("advanced_fluix_circuit", Item::new)
            .lang("Advanced Fluix Circuit")
            .model(FTEModels.itemModelFromTexture(FTECore.id("item/circuit/fluix/advanced")))
            .tag(FTETags.CERTUS_CIRCUIT[3])
            .register();
    public static ItemEntry<Item> FLUIX_MAINFRAME = FTECore.FTERegister
            .item("fluix_mainframe", Item::new)
            .lang("Fluix Mainframe")
            .model(FTEModels.itemModelFromTexture(FTECore.id("item/circuit/fluix/mainframe")))
            .tag(FTETags.CERTUS_CIRCUIT[4])
            .register();

    private static ItemEntry<Item> makeUniversalCircuit(int tier) {
        return FTECore.FTERegister
                .item(GTValues.VN[tier].toLowerCase() + "_universal_circuit", Item::new)
                .lang(GTValues.VNF[tier] + " Universal Circuit")
                .tag(FTEValues.VCT[tier])
                .tag(CustomTags.CIRCUITS)
                .model(FTEModels.itemModelFromFile(FTECore.id("item/components/universal_circuit")))
                .color(ColorHelper.itemTintFromHex(FTEValues.VC[tier], 1))
                .register();
    }

    public static <T extends IComponentItem> NonNullConsumer<T> attach(IItemComponent components) {
        return item -> item.attachComponents(components);
    }

    public static void init() {}
}

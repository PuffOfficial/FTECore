package com.puffofficial.ftecore.common.machine;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.api.registry.registrate.MultiblockMachineBuilder;

import com.puffofficial.ftecore.FTECore;

import java.util.Locale;
import java.util.function.BiFunction;

// This horrible thing was made by Argx/Phoenixvine, I have NO idea how this works and why this works.

public class MachineUtils {

    public static MultiblockMachineDefinition[] TieredMultis(String name,
                                                             BiFunction<IMachineBlockEntity, Integer, MultiblockControllerMachine> factory,
                                                             BiFunction<Integer, MultiblockMachineBuilder<?, ?>, MultiblockMachineDefinition> builder,
                                                             int... tiers) {
        return TieredMultis(FTECore.FTERegister, name, factory, builder, tiers);
    }

    public static MultiblockMachineDefinition[] TieredMultis(GTRegistrate registrate, String name,
                                                             BiFunction<IMachineBlockEntity, Integer, MultiblockControllerMachine> factory,
                                                             BiFunction<Integer, MultiblockMachineBuilder<?, ?>, MultiblockMachineDefinition> builder,
                                                             int... tiers) {
        MultiblockMachineDefinition[] definitions = new MultiblockMachineDefinition[GTValues.TIER_COUNT];
        for (int tier : tiers) {
            var register = registrate
                    .multiblock(GTValues.VN[tier].toLowerCase(Locale.ROOT) + "_" + name,
                            holder -> factory.apply(holder, tier))
                    .tier(tier);
            definitions[tier] = builder.apply(tier, register);
        }
        return definitions;
    }

    public static MachineDefinition[] TieredMachines(String name,
                                                     BiFunction<IMachineBlockEntity, Integer, MetaMachine> factory,
                                                     BiFunction<Integer, MachineBuilder<MachineDefinition, ?>, MachineDefinition> builder,
                                                     int... tiers) {
        MachineDefinition[] definitions = new MachineDefinition[GTValues.TIER_COUNT];
        for (int tier : tiers) {
            var register = FTECore.FTERegister
                    .machine(GTValues.VN[tier].toLowerCase(Locale.ROOT) + "_" + name,
                            holder -> factory.apply(holder, tier))
                    .tier(tier);
            definitions[tier] = builder.apply(tier, register);
        }
        return definitions;
    }
}

package com.puffofficial.ftecore.common.data;

import com.gregtechceu.gtceu.api.block.OreBlock;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.puffofficial.ftecore.FTECore;

import java.util.Random;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;

@Mod.EventBusSubscriber(modid = FTECore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FTEBedrockOreLogic {

    @SubscribeEvent
    public static void onBreakEvent(BlockEvent.BreakEvent event) {
        int minRandom = 1;
        int maxRandom = 4;

        if (!(event.getLevel() instanceof Level level)) return;
        if (level.isClientSide()) return;

        BlockPos pos = event.getPos();
        BlockState state = event.getState();
        Player player = event.getPlayer();

        int random = new Random().nextInt(maxRandom - minRandom + 1) + minRandom;

        if (state.getBlock() instanceof OreBlock && state.getBlock().getDescriptionId().contains("bedrock")) {

            Material blockMaterial = ((OreBlock) state.getBlock()).material;
            ItemStack itemStack = ChemicalHelper.get(rawOre, blockMaterial, random);

            event.setCanceled(true);
            level.setBlock(pos, Blocks.BEDROCK.defaultBlockState(), Block.UPDATE_ALL);

            if (!(player.hasCorrectToolForDrops(state))) return;

            if (player.getInventory().add(itemStack)) {
                player.getInventory().add(itemStack);
            } else {
                player.drop(itemStack, true, true);
            }
        }
    }
}

package com.therealm18.mineandslash.expansion.blocks;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;

import com.therealm18.mineandslash.expansion.Ref;
import com.therealm18.mineandslash.expansion.blocks.chest.master_chest.MasterChestTile;
import com.therealm18.mineandslash.expansion.registry.BlockReferance;

public class TileEntityTypes
{
    @ObjectHolder(BlockReferance.MASTER_CHEST)
    public static TileEntityType<?> MASTER_CHEST;

    public TileEntityTypes()
    {

    }

    @Mod.EventBusSubscriber(modid = Ref.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration
    {
        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> e)
        {
            e.getRegistry().registerAll(
                    TileEntityType.Builder.create((Supplier<TileEntity>) MasterChestTile::new, BlockReferance.BLOCK_MASTER_CHEST).build(null).setRegistryName(BlockReferance.MASTER_CHEST));
        }
    }
}
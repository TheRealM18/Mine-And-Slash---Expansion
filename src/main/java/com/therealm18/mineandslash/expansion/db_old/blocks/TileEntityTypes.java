package com.therealm18.mineandslash.expansion.db_old.blocks;

import com.therealm18.mineandslash.expansion.db_old.blocks.chest.master_chest.MasterChestTile;
import com.therealm18.mineandslash.expansion.registry.BlockReferance;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class TileEntityTypes{

@SubscribeEvent
public static void onTileEntityRegistry(
        final RegistryEvent.Register<TileEntityType<?>> e) {

    IForgeRegistry<TileEntityType<?>> r = e.getRegistry();

    r.register(TileEntityType.Builder.create(MasterChestTile::new, BlockReferance.BLOCK_MASTER_CHEST)
            .build(null)
            .setRegistryName(BlockReferance.MASTER_CHEST));
    
    r.register(TileEntityType.Builder.create(MasterChestTile::new, BlockReferance.BLOCK_MASTER_CHEST)
            .build(null)
            .setRegistryName(BlockReferance.MASTER_CHEST));
	}
}
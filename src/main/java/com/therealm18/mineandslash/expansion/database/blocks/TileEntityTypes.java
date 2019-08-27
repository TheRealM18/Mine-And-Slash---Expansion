package com.therealm18.mineandslash.expansion.database.blocks;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TileEntityTypes{

@SubscribeEvent
public static void onTileEntityRegistry(
        final RegistryEvent.Register<TileEntityType<?>> e) {

//    IForgeRegistry<TileEntityType<?>> r = e.getRegistry();
//
//    r.register(TileEntityType.Builder.create(MasterChestTile::new, BlockReferance.BLOCK_MASTER_CHEST)
//            .build(null)
//            .setRegistryName(BlockReferance.MASTER_CHEST));
//    
//    r.register(TileEntityType.Builder.create(MasterChestTile::new, BlockReferance.BLOCK_MASTER_CHEST)
//            .build(null)
//            .setRegistryName(BlockReferance.MASTER_CHEST));
	}
}
package com.therealm18.mineandslash.expansion.registry;

import com.therealm18.mineandslash.expansion.Ref;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class BlockReferance {
	

    public static final String GEAR_SALVAGE_CREATIVE = Ref.MODID + ":salvage_block_creative";
    public static final String MASTER_CHEST = Ref.MODID + ":master_block_chest";
	
	
    

    // NEW BLOCK
//    @ObjectHolder(GEAR_SALVAGE_CREATIVE)
//    public static TileEntityType<?> SALVAGE_STATION_CREATIVE;
    @ObjectHolder(GEAR_SALVAGE_CREATIVE)
    public static Block BLOCK_GEAR_SALVAGE_CREATIVE;
    @ObjectHolder(GEAR_SALVAGE_CREATIVE)
    public static BlockItem ITEMBLOCK_GEAR_SALVAGE_CREATIVE;
    
    
    // NEW BLOCK CHEST
    @ObjectHolder(MASTER_CHEST)
    public static TileEntityType<?> TILE_MASTER_CHEST;
    @ObjectHolder(MASTER_CHEST)
    public static Block BLOCK_MASTER_CHEST;
    @ObjectHolder(MASTER_CHEST)
    public static BlockItem ITEMBLOCK_MASTER_CHEST;
    
//	@ObjectHolder(Ref.MODID + ":salvage_block_creative")
//    public static SalvageStationCreative SALVAGESTATIONCREATIVE;
}

package com.therealm18.mineandslash.expansion.registry;

import com.therealm18.mineandslash.expansion.Ref;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class BlockReferance {
	

    public static final String GEAR_SALVAGE_CREATIVE = Ref.MODID + ":salvage_block_creative";
    public static final String MASTER_CHEST = Ref.MODID + ":master_block_chest";
    public static final String COMPRESSOR = Ref.MODID + ":compressor_block_common";
    public static final String HOPPER_COMMON = Ref.MODID + ":hopper_block_common";
    public static final String HOPPER_UNCOMMON = Ref.MODID + ":hopper_block_uncommon";
    public static final String HOPPER_RARE = Ref.MODID + ":hopper_block_rare";
    public static final String HOPPER_EPIC = Ref.MODID + ":hopper_block_epic";
    public static final String HOPPER_LEGENDARY = Ref.MODID + ":hopper_block_legedary";
    public static final String HOPPER_MYTHICAL = Ref.MODID + ":hopper_block_mythical";
    public static final String SHULKER_COMMON = Ref.MODID + ":shulker_block_common";
    public static final String SHULKER_UNCOMMON = Ref.MODID + ":shulker_block_uncommon";
    public static final String SHULKER_RARE = Ref.MODID + ":shulker_block_rare";
    public static final String SHULKER_EPIC = Ref.MODID + ":shulker_block_epic";
    public static final String SHULKER_LEGENDARY = Ref.MODID + ":shulker_block_legendary";
    public static final String SHULKER_MYTHICAL = Ref.MODID + ":shulker_block_mythical";
	
	
    

    // NEW BLOCK Salvage Creative
    @ObjectHolder(GEAR_SALVAGE_CREATIVE)
    public static TileEntityType<?> SALVAGE_STATION_CREATIVE;
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

    // NEW BLOCK Compressor
    @ObjectHolder(COMPRESSOR)
    public static TileEntityType<?> TILE_COMPRESSOR;
    @ObjectHolder(COMPRESSOR)
    public static Block BLOCK_COMPRESSOR;
    @ObjectHolder(COMPRESSOR)
    public static BlockItem ITEMBLOCK_COMPRESSOR;
//    
//    // NEW BLOCK Common Hopper
//    @ObjectHolder(HOPPER_COMMON)
//    public static TileEntityType<?> TILE_HOPPER_COMMON;
//    @ObjectHolder(HOPPER_COMMON)
//    public static Block BLOCK_HOPPER_COMMON;
//    @ObjectHolder(HOPPER_COMMON)
//    public static BlockItem ITEMBLOCK_HOPPER_COMMON;

}

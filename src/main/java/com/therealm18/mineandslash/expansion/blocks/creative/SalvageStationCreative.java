package com.therealm18.mineandslash.expansion.blocks.creative;

import com.robertx22.mine_and_slash.blocks.bases.BaseInventoryBlock;
import com.robertx22.mine_and_slash.blocks.salvage_station.TileGearSalvage;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class SalvageStationCreative extends BaseInventoryBlock{
	
	public SalvageStationCreative() {
		super (Properties.create(Material.ROCK).harvestLevel(10000000).hardnessAndResistance(10000000F).noDrops());
	}


    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {

        return new TileGearSalvage();

    }

}

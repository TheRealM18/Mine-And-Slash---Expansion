package com.therealm18.mineandslash.expansion.database.blocks.chest.master_chest;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class MasterChestBlock  extends Block {

    public MasterChestBlock() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5F));
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {

        return new MasterChestTile();

    }
}
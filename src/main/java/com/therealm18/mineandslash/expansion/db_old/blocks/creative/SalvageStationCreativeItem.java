package com.therealm18.mineandslash.expansion.db_old.blocks.creative;

import com.therealm18.mineandslash.expansion.Ref;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SalvageStationCreativeItem extends Block {

    public SalvageStationCreativeItem() {
        super(Block.Properties.create(Material.IRON).noDrops());
        this.setRegistryName(Ref.MODID + ":salvage_block_creative");

    }

}
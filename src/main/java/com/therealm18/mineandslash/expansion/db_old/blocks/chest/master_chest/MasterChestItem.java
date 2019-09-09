package com.therealm18.mineandslash.expansion.db_old.blocks.chest.master_chest;

import com.therealm18.mineandslash.expansion.Ref;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MasterChestItem extends Block{

    public MasterChestItem() {
        super(Block.Properties.create(Material.IRON).noDrops());
        this.setRegistryName(Ref.MODID + ":master_chest");

    }

}

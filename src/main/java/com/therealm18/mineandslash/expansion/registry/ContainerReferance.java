package com.therealm18.mineandslash.expansion.registry;

import com.therealm18.mineandslash.expansion.blocks.chest.master_chest.MasterChestContainer;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.registries.ObjectHolder;

public class ContainerReferance {
	
    @ObjectHolder(BlockReferance.MASTER_CHEST)
    public static final ContainerType<MasterChestContainer> MASTER_CHEST_CONTAINER = null;
}

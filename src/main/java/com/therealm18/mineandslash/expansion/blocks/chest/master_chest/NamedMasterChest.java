package com.therealm18.mineandslash.expansion.blocks.chest.master_chest;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

import javax.annotation.Nullable;

public class NamedMasterChest implements INamedContainerProvider {

    private final ItemStack stack;
    MasterChestContainer.ItemType type;

    public NamedMasterChest(ItemStack stack, MasterChestContainer.ItemType type) {
        this.stack = stack;
        this.type = type;
    }

    @Nullable
    @Override
    public Container createMenu(int i, PlayerInventory inventory, PlayerEntity player) {
        return new MasterChestContainer(i, inventory, new MasterChestInventory(stack, type), type);
    }

    @Override
    public ITextComponent getDisplayName() {
        return new StringTextComponent("Master Chest");
    }

}
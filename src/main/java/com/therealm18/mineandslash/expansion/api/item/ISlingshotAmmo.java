package com.therealm18.mineandslash.expansion.api.item;

import net.minecraft.item.ItemStack;

public interface ISlingshotAmmo {
    default boolean isAmmo(ItemStack stack) {
        return true;
    }
}
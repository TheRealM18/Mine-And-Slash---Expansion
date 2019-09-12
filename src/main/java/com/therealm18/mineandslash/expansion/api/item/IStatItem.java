package com.therealm18.mineandslash.expansion.api.item;

import com.therealm18.mineandslash.expansion.api.stats.ItemStat;

import net.minecraft.item.ItemStack;

public interface IStatItem {
    float getStat(ItemStack stack, ItemStat stat);

    default int getStatInt(ItemStack stack, ItemStat stat) {
        return Math.round(getStat(stack, stat));
    }
}
package com.therealm18.mineandslash.expansion.api.item;

import com.google.common.collect.ImmutableSet;
import com.therealm18.mineandslash.expansion.api.stats.ItemStat;
import com.therealm18.mineandslash.expansion.api.stats.ItemStats;
import com.therealm18.mineandslash.expansion.database.items.parts.PartData;

import net.minecraft.item.ItemStack;

import java.util.Set;

public interface ICoreArmor extends ICoreItem {
    Set<ItemStat> RELEVANT_STATS = ImmutableSet.of(
            ItemStats.ARMOR,
            ItemStats.MAGIC_ARMOR,
            ItemStats.ARMOR_TOUGHNESS,
            ItemStats.DURABILITY,
            ItemStats.ENCHANTABILITY,
            ItemStats.RARITY
    );

    @Override
    default Set<ItemStat> getRelevantStats(ItemStack stack) {
        return RELEVANT_STATS;
    }

    @Override
    default PartData[] getRenderParts(ItemStack stack) {
        return new PartData[]{getPrimaryPart(stack)};
    }
}
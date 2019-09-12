package com.therealm18.mineandslash.expansion.api.item;

import com.google.common.collect.ImmutableSet;

import com.therealm18.mineandslash.expansion.api.parts.PartType;
import com.therealm18.mineandslash.expansion.api.stats.ItemStat;
import com.therealm18.mineandslash.expansion.api.stats.ItemStats;

import net.minecraft.item.ItemStack;

import java.util.Set;

public interface ICoreRangedWeapon extends ICoreTool {
    Set<ItemStat> RELEVANT_STATS = ImmutableSet.of(
            ItemStats.RANGED_DAMAGE,
            ItemStats.RANGED_SPEED,
            ItemStats.DURABILITY,
            ItemStats.ENCHANTABILITY,
            ItemStats.RARITY
    );

    @Override
    default Set<ItemStat> getRelevantStats(ItemStack stack) {
        return RELEVANT_STATS;
    }

    @Override
    default boolean requiresPartOfType(PartType type) {
        return type == PartType.MAIN || type == PartType.ROD || type == PartType.BOWSTRING;
    }

    @Override
    default boolean supportsPartOfType(PartType type) {
        return true;
    }

    @Override
    default int getAnimationFrames() {
        return 4;
    }

    default float getBaseDrawDelay(ItemStack stack) {
        return 20;
    }

    default float getDrawDelay(ItemStack stack) {
        float speed = getStat(stack, ItemStats.RANGED_SPEED);
        if (speed <= 0) speed = 1f;
        return getBaseDrawDelay(stack) / speed;
    }
}
package com.therealm18.mineandslash.expansion.api.item;

import com.google.common.collect.ImmutableSet;
import com.therealm18.mineandslash.expansion.api.stats.ItemStat;
import com.therealm18.mineandslash.expansion.api.stats.ItemStats;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

import java.util.Set;

public interface ICoreWeapon extends ICoreTool {
    Set<ItemStat> RELEVANT_STATS = ImmutableSet.of(
            ItemStats.MELEE_DAMAGE,
            ItemStats.MAGIC_DAMAGE,
            ItemStats.ATTACK_SPEED,
            ItemStats.DURABILITY,
            ItemStats.ENCHANTABILITY,
            ItemStats.RARITY
    );

    @Override
    default Set<ItemStat> getRelevantStats(ItemStack stack) {
        return RELEVANT_STATS;
    }

    @Override
    default int getDamageOnHitEntity(ItemStack gear, LivingEntity target, LivingEntity attacker) {
        return 1;
    }
}
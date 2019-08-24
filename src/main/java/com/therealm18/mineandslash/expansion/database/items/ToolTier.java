package com.therealm18.mineandslash.expansion.database.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum ToolTier implements IItemTier {
	
   COMMON(0, 128, 4.0F, 1.0F, 30),
   UNCOMMON(1, 256, 8.0F, 2.0F, 30),
   RARE(2, 512, 12.0F, 4.0F, 30),
   EPIC(3, 1024, 16.0F, 8.0F, 30),
   LEGENDARY(4, 3048, 20.0F, 16.0F, 30),
   MYTHICAL(5, 4096, 24.0F, 32.0F, 30);

   private final int harvestLevel;
   private final int maxUses;
   private final float efficiency;
   private final float attackDamage;
   private final int enchantability;

   private ToolTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn) {
      this.harvestLevel = harvestLevelIn;
      this.maxUses = maxUsesIn;
      this.efficiency = efficiencyIn;
      this.attackDamage = attackDamageIn;
      this.enchantability = enchantabilityIn;
   }

   public int getMaxUses() {
      return this.maxUses;
   }

   public float getEfficiency() {
      return this.efficiency;
   }

   public float getAttackDamage() {
      return this.attackDamage;
   }

   public int getHarvestLevel() {
      return this.harvestLevel;
   }

   public int getEnchantability() {
      return this.enchantability;
   }

@Override
public Ingredient getRepairMaterial() {
	return null;
}
}
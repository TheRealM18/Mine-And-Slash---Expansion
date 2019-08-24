package com.therealm18.mineandslash.expansion.database.items;

import java.util.function.Supplier;

import net.minecraft.block.Blocks;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;

public enum ToolTier implements IItemTier {
	
   COMMON(0, 128, 4.0F, 1.0F, 30, () -> {
	      return Ingredient.fromItems(Blocks.AIR);
	   }),
   UNCOMMON(1, 256, 8.0F, 2.0F, 30, () -> {
	      return Ingredient.fromItems(Blocks.AIR);
	   }),
   RARE(2, 512, 12.0F, 4.0F, 30, () -> {
	      return Ingredient.fromItems(Blocks.AIR);
	   }),
   EPIC(3, 1024, 16.0F, 8.0F, 30, () -> {
	      return Ingredient.fromItems(Blocks.AIR);
	   }),
   LEGENDARY(4, 3048, 20.0F, 16.0F, 30, () -> {
	      return Ingredient.fromItems(Blocks.AIR);
	   }),
   MYTHICAL(5, 4096, 24.0F, 32.0F, 30, () -> {
	      return Ingredient.fromItems(Blocks.AIR);
	   });

   private final int harvestLevel;
   private final int maxUses;
   private final float efficiency;
   private final float attackDamage;
   private final int enchantability;
   private final LazyLoadBase<Ingredient> repairMaterial;

   private ToolTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
      this.harvestLevel = harvestLevelIn;
      this.maxUses = maxUsesIn;
      this.efficiency = efficiencyIn;
      this.attackDamage = attackDamageIn;
      this.enchantability = enchantabilityIn;
      this.repairMaterial = new LazyLoadBase<>(repairMaterialIn);
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

   public Ingredient getRepairMaterial() {
      return this.repairMaterial.getValue();
   }
}
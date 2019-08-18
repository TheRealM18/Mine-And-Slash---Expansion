package com.therealm18.mineandslash.expansion.database.items.tools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.PickaxeItem;

public class Pickaxe extends PickaxeItem{

	public Pickaxe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

}

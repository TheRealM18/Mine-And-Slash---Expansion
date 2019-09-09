package com.therealm18.mineandslash.expansion.database.items.tools.type;

import com.therealm18.mineandslash.expansion.database.items.parts.Bindings;
import com.therealm18.mineandslash.expansion.database.items.parts.Heads;
import com.therealm18.mineandslash.expansion.database.items.parts.Rods;

import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;

public class Axe extends AxeItem {

	private static Class<?> tool;
	
	public Axe(IItemTier tool, Properties builder) {
		super(tool , 1.0F, 1.0F, builder);
		this.tool = Bindings.class;
		this.tool = Heads.class;
		this.tool = Rods.class;
	}
}

package com.therealm18.mineandslash.expansion.registry;

import com.therealm18.mineandslash.expansion.Ref;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.registries.ObjectHolder;

public class EnchantmentReferance {
	

    public static final String MASE_FORTUNE = Ref.MODID + ":fortune";
    public static final String MASE_LUCK_OF_THE_SEA = Ref.MODID + ":luck_of_the_sea";
    public static final String MASE_LOOTING = Ref.MODID + ":looting";
	
	
    

    // NEW Enchantment MASE Fortune
    @ObjectHolder(MASE_FORTUNE)
    public static Enchantment FORTURE;

    // NEW Enchantment MASE Fortune
    @ObjectHolder(MASE_LUCK_OF_THE_SEA)
    public static Enchantment LUCK_OF_THE_SEA;
    
    // NEW Enchantment MASE Fortune
    @ObjectHolder(MASE_LOOTING)
    public static Enchantment LOOTING;

}

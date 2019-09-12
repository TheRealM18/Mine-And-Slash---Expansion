package com.therealm18.mineandslash.expansion.registry;

import com.therealm18.mineandslash.expansion.Ref;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

public class PartsRegistry {

	//Tools
	public static final String AXE = Ref.MODID + ":test";

	//Heads
	public static final String AXEHEAD = Ref.MODID + ":axehead";
	
	//Bindings
	public static final String BINDING = Ref.MODID + ":binding";
	
	//Shafts
	public static final String STICK = "minecraft" + ":stick";
	public static final String COMMONROD = Ref.MODID + ":commonrod";
	public static final String UNCOMMONROD = Ref.MODID  + ":uncommonrod";
	public static final String RAREROD = Ref.MODID  + ":rarerod";
	public static final String EPICROD = Ref.MODID  + ":epicrod";
	public static final String LEGENDARYROD = Ref.MODID  + ":legendaryrod";
	public static final String MYTHICALROD = Ref.MODID  + ":mythicalrod";
	
	

	// New Tools
	@ObjectHolder(AXEHEAD)
    public static AxeItem JOBTOOLAXEHEAD;
	
//    // NEW Heads
//	@ObjectHolder(AXEHEAD)
//    public static Heads TOOLAXEHEAD;

    // NEW Bindings
	@ObjectHolder(BINDING)
    public static Item TOOLBINDING;
	
//    // NEW Rods
//	@ObjectHolder(STICK)
//    public static Rods stick;
//	@ObjectHolder(COMMONROD)
//    public static Rods conmonRod;
//	@ObjectHolder(UNCOMMONROD)
//    public static Rods unonmonRod;
//	@ObjectHolder(RAREROD)
//    public static Rods rareRod;
//	@ObjectHolder(EPICROD)
//    public static Rods epicRod;
//	@ObjectHolder(LEGENDARYROD)
//    public static Rods legendaryRod;
//	@ObjectHolder(MYTHICALROD)
//    public static Rods mythicalRod;
}

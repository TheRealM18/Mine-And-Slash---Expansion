package com.therealm18.mineandslash.expansion;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.robertx22.mine_and_slash.api.MineAndSlashAPI;
import com.therealm18.mineandslash.expansion.database.blocks.chest.master_chest.MasterChestBlock;
import com.therealm18.mineandslash.expansion.database.blocks.creative.SalvageStationCreative;
import com.therealm18.mineandslash.expansion.database.blocks.creative.SalvageStationCreativeTile;
import com.therealm18.mineandslash.expansion.database.items.ToolTier;
import com.therealm18.mineandslash.expansion.database.items.books.enchantments.LootBonusEnchantment;
import com.therealm18.mineandslash.expansion.database.items.ores.Ingot;
import com.therealm18.mineandslash.expansion.database.items.spell_items.self.ItemSelfBreath;
import com.therealm18.mineandslash.expansion.database.items.spell_items.self.ItemSelfFeatherFalling;
import com.therealm18.mineandslash.expansion.database.items.spell_items.self.ItemSelfFeed;
import com.therealm18.mineandslash.expansion.database.items.spell_items.self.ItemSelfFirePro;
import com.therealm18.mineandslash.expansion.database.items.spell_items.self.ItemSelfHaste;
import com.therealm18.mineandslash.expansion.database.items.spell_items.self.ItemSelfJumpBoost;
import com.therealm18.mineandslash.expansion.database.items.spell_items.self.ItemSelfNightVision;
import com.therealm18.mineandslash.expansion.database.items.spell_items.self.ItemSelfSpeed;
import com.therealm18.mineandslash.expansion.database.items.tools.Axe;
import com.therealm18.mineandslash.expansion.database.items.tools.Excavator;
import com.therealm18.mineandslash.expansion.database.items.tools.FishingRod;
import com.therealm18.mineandslash.expansion.database.items.tools.Hammer;
import com.therealm18.mineandslash.expansion.database.items.tools.Hoe;
import com.therealm18.mineandslash.expansion.database.items.tools.Pickaxe;
import com.therealm18.mineandslash.expansion.database.items.tools.Shovel;
import com.therealm18.mineandslash.expansion.database.spells.self.SpellSelfBreath;
import com.therealm18.mineandslash.expansion.database.spells.self.SpellSelfFeatherFalling;
import com.therealm18.mineandslash.expansion.database.spells.self.SpellSelfFeed;
import com.therealm18.mineandslash.expansion.database.spells.self.SpellSelfFirePro;
import com.therealm18.mineandslash.expansion.database.spells.self.SpellSelfHaste;
import com.therealm18.mineandslash.expansion.database.spells.self.SpellSelfJumpBoost;
import com.therealm18.mineandslash.expansion.database.spells.self.SpellSelfNightVision;
import com.therealm18.mineandslash.expansion.database.spells.self.SpellSelfSpeed;
import com.therealm18.mineandslash.expansion.registry.BlockReferance;

@Mod("mineandslashexpansion")
@EventBusSubscriber
public class MASE
{
    public static final Logger LOGGER = LogManager.getLogger();

    public static final ItemGroup DNU = new ItemGroup(Ref.MODID + "_dnu") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemSelfFeatherFalling.ITEM);
        }

    };
    
    public static final ItemGroup Tools = new ItemGroup(Ref.MODID + "_tools") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemSelfBreath.ITEM);
        }

    };
    
    public static final ItemGroup Ingrediants = new ItemGroup(Ref.MODID + "_ingedients") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemSelfFeed.ITEM);
        }

    };

    public MASE() {

        System.out.println("Starting Mine and Slash - Expansion");

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
        

        
    }
    
    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
  }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
    }

    private void processIMC(final InterModProcessEvent event)
    {
        MineAndSlashAPI.addSpell(new SpellSelfFeed());
        MineAndSlashAPI.addSpell(new SpellSelfHaste());
        MineAndSlashAPI.addSpell(new SpellSelfJumpBoost());
        MineAndSlashAPI.addSpell(new SpellSelfSpeed());
        MineAndSlashAPI.addSpell(new SpellSelfFeatherFalling());
        MineAndSlashAPI.addSpell(new SpellSelfNightVision());
        MineAndSlashAPI.addSpell(new SpellSelfBreath());
        MineAndSlashAPI.addSpell(new SpellSelfFirePro());
    }
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {


    	@SubscribeEvent
    	public static void registerItems(RegistryEvent.Register<Item> event) {

    		//Spells
    		event.getRegistry().register(new ItemSelfHaste());
    		event.getRegistry().register(new ItemSelfSpeed());
    		event.getRegistry().register(new ItemSelfFeed());
    		event.getRegistry().register(new ItemSelfJumpBoost());
    		event.getRegistry().register(new ItemSelfFeatherFalling());
    		event.getRegistry().register(new ItemSelfNightVision());
    		event.getRegistry().register(new ItemSelfBreath());
    		event.getRegistry().register(new ItemSelfFirePro());
    		
    		//Blocks
    		event.getRegistry().register(new BlockItem(BlockReferance.BLOCK_GEAR_SALVAGE_CREATIVE, new Item.Properties().group(DNU)).setRegistryName(BlockReferance.GEAR_SALVAGE_CREATIVE));
    		event.getRegistry().register(new BlockItem(BlockReferance.BLOCK_MASTER_CHEST, new Item.Properties().group(DNU)).setRegistryName(BlockReferance.MASTER_CHEST));
    		
    		
    		//Tools
    		event.getRegistry().register(new Pickaxe(ToolTier.COMMON, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.PICKAXE, 0).maxStackSize(1)).setRegistryName("commonpickaxe"));
    		event.getRegistry().register(new Pickaxe(ToolTier.UNCOMMON, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.PICKAXE, 0).maxStackSize(1)).setRegistryName("uncommonpickaxe"));
    		event.getRegistry().register(new Pickaxe(ToolTier.RARE, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.PICKAXE, 0).maxStackSize(1)).setRegistryName("rarepickaxe"));
    		event.getRegistry().register(new Pickaxe(ToolTier.EPIC, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.PICKAXE, 0).maxStackSize(1)).setRegistryName("epicpickaxe"));
    		event.getRegistry().register(new Pickaxe(ToolTier.LEGENDARY, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.PICKAXE, 0).maxStackSize(1)).setRegistryName("legendarypickaxe"));
    		event.getRegistry().register(new Pickaxe(ToolTier.MYTHICAL, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.PICKAXE, 0).maxStackSize(1)).setRegistryName("mythicalpickaxe"));
    		

    		event.getRegistry().register(new Axe(ToolTier.COMMON, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.AXE, 0).maxStackSize(1)).setRegistryName("commonaxe"));
    		event.getRegistry().register(new Axe(ToolTier.UNCOMMON, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.AXE, 0).maxStackSize(1)).setRegistryName("uncommonaxe"));
    		event.getRegistry().register(new Axe(ToolTier.RARE, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.AXE, 0).maxStackSize(1)).setRegistryName("rareaxe"));
    		event.getRegistry().register(new Axe(ToolTier.EPIC, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.AXE, 0).maxStackSize(1)).setRegistryName("epicaxe"));
    		event.getRegistry().register(new Axe(ToolTier.LEGENDARY, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.AXE, 0).maxStackSize(1)).setRegistryName("legendaryaxe"));
    		event.getRegistry().register(new Axe(ToolTier.MYTHICAL, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.AXE, 0).maxStackSize(1)).setRegistryName("mythicalaxe"));
    		

    		event.getRegistry().register(new Hoe(ToolTier.COMMON, 1, new Item.Properties().group(Tools).addToolType(ToolType.PICKAXE, 0).maxStackSize(1)).setRegistryName("commonhoe"));
    		event.getRegistry().register(new Hoe(ToolTier.UNCOMMON, 1, new Item.Properties().group(Tools).addToolType(ToolType.PICKAXE, 0).maxStackSize(1)).setRegistryName("uncommonhoe"));
    		event.getRegistry().register(new Hoe(ToolTier.RARE, 1, new Item.Properties().group(Tools).addToolType(ToolType.PICKAXE, 0).maxStackSize(1)).setRegistryName("rarehoe"));
    		event.getRegistry().register(new Hoe(ToolTier.EPIC, 1, new Item.Properties().group(Tools).addToolType(ToolType.PICKAXE, 0).maxStackSize(1)).setRegistryName("epichoe"));
    		event.getRegistry().register(new Hoe(ToolTier.LEGENDARY, 1, new Item.Properties().group(Tools).addToolType(ToolType.PICKAXE, 0).maxStackSize(1)).setRegistryName("legendaryhoe"));
    		event.getRegistry().register(new Hoe(ToolTier.MYTHICAL, 1, new Item.Properties().group(Tools).addToolType(ToolType.PICKAXE, 0).maxStackSize(1)).setRegistryName("mythicalhoe"));
    		

    		event.getRegistry().register(new Shovel(ToolTier.COMMON, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.SHOVEL, 0).maxStackSize(1)).setRegistryName("commonshovel"));
    		event.getRegistry().register(new Shovel(ToolTier.UNCOMMON, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.SHOVEL, 0).maxStackSize(1)).setRegistryName("uncommonshovel"));
    		event.getRegistry().register(new Shovel(ToolTier.RARE, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.SHOVEL, 0).maxStackSize(1)).setRegistryName("rareshovel"));
    		event.getRegistry().register(new Shovel(ToolTier.EPIC, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.SHOVEL, 0).maxStackSize(1)).setRegistryName("epicshovel"));
    		event.getRegistry().register(new Shovel(ToolTier.LEGENDARY, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.SHOVEL, 0).maxStackSize(1)).setRegistryName("legendaryshovel"));
    		event.getRegistry().register(new Shovel(ToolTier.MYTHICAL, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.SHOVEL, 0).maxStackSize(1)).setRegistryName("mythicalshovel"));

    		
    		event.getRegistry().register(new Hammer(ToolTier.COMMON, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.PICKAXE, 0).maxStackSize(1)).setRegistryName("commonhammer"));
    		event.getRegistry().register(new Hammer(ToolTier.UNCOMMON, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.PICKAXE, 0).maxStackSize(1)).setRegistryName("uncommonhammer"));
    		event.getRegistry().register(new Hammer(ToolTier.RARE, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.PICKAXE, 0).maxStackSize(1)).setRegistryName("rarehammer"));
    		event.getRegistry().register(new Hammer(ToolTier.EPIC, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.PICKAXE, 0).maxStackSize(1)).setRegistryName("epichammer"));
    		event.getRegistry().register(new Hammer(ToolTier.LEGENDARY, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.PICKAXE, 0).maxStackSize(1)).setRegistryName("legendaryhammer"));
    		event.getRegistry().register(new Hammer(ToolTier.MYTHICAL, 1, 1F, new Item.Properties().group(Tools).addToolType(ToolType.PICKAXE, 0).maxStackSize(1)).setRegistryName("mythicalhammer"));
    		
    		
    		event.getRegistry().register(new Excavator(ToolTier.COMMON, 1, 1.5F, new Item.Properties().group(Tools).addToolType(ToolType.SHOVEL, 0).maxStackSize(1)).setRegistryName("commonexcavator"));
    		event.getRegistry().register(new Excavator(ToolTier.UNCOMMON, 1, 1.6F, new Item.Properties().group(Tools).addToolType(ToolType.SHOVEL, 0).maxStackSize(1)).setRegistryName("uncommonexcavator"));
    		event.getRegistry().register(new Excavator(ToolTier.RARE, 1, 1.7F, new Item.Properties().group(Tools).addToolType(ToolType.SHOVEL, 0).maxStackSize(1)).setRegistryName("rareexcavator"));
    		event.getRegistry().register(new Excavator(ToolTier.EPIC, 1, 1.8F, new Item.Properties().group(Tools).addToolType(ToolType.SHOVEL, 0).maxStackSize(1)).setRegistryName("epicexcavator"));
    		event.getRegistry().register(new Excavator(ToolTier.LEGENDARY, 1, 1.9F, new Item.Properties().group(Tools).addToolType(ToolType.SHOVEL, 0).maxStackSize(1)).setRegistryName("legendaryexcavator"));
    		event.getRegistry().register(new Excavator(ToolTier.MYTHICAL, 1, 2F, new Item.Properties().group(Tools).addToolType(ToolType.SHOVEL, 0).maxStackSize(1)).setRegistryName("mythicalexcavator"));
    		
    		
    		event.getRegistry().register(new FishingRod(new Item.Properties().group(Tools).maxDamage(128)).setRegistryName("commonfishingrod"));
    		event.getRegistry().register(new FishingRod(new Item.Properties().group(Tools).maxDamage(256)).setRegistryName("uncommonfishingrod"));
    		event.getRegistry().register(new FishingRod(new Item.Properties().group(Tools).maxDamage(512)).setRegistryName("rarefishingrod"));
    		event.getRegistry().register(new FishingRod(new Item.Properties().group(Tools).maxDamage(1024)).setRegistryName("epicfishingrod"));
    		event.getRegistry().register(new FishingRod(new Item.Properties().group(Tools).maxDamage(2048)).setRegistryName("legendaryfishingrod"));
    		event.getRegistry().register(new FishingRod(new Item.Properties().group(Tools).maxDamage(4096)).setRegistryName("mythicalfishingrod"));
    		
    		
    		event.getRegistry().register(new Ingot(new Item.Properties().group(Ingrediants).maxStackSize(32)).setRegistryName("commoningot"));
    		event.getRegistry().register(new Ingot(new Item.Properties().group(Ingrediants).maxStackSize(32)).setRegistryName("uncommoningot"));
    		event.getRegistry().register(new Ingot(new Item.Properties().group(Ingrediants).maxStackSize(32)).setRegistryName("rareingot"));
    		event.getRegistry().register(new Ingot(new Item.Properties().group(Ingrediants).maxStackSize(32)).setRegistryName("epicingot"));
    		event.getRegistry().register(new Ingot(new Item.Properties().group(Ingrediants).maxStackSize(32)).setRegistryName("legendaryingot"));
    		event.getRegistry().register(new Ingot(new Item.Properties().group(Ingrediants).maxStackSize(32)).setRegistryName("mythicalingot"));
    		
    		
    		event.getRegistry().register(new Ingot(new Item.Properties().group(Ingrediants).maxStackSize(32)).setRegistryName("commonmixedingot"));
    		event.getRegistry().register(new Ingot(new Item.Properties().group(Ingrediants).maxStackSize(32)).setRegistryName("uncommonmixedingot"));
    		event.getRegistry().register(new Ingot(new Item.Properties().group(Ingrediants).maxStackSize(32)).setRegistryName("raremixedingot"));
    		event.getRegistry().register(new Ingot(new Item.Properties().group(Ingrediants).maxStackSize(32)).setRegistryName("epicmixedingot"));
    		event.getRegistry().register(new Ingot(new Item.Properties().group(Ingrediants).maxStackSize(32)).setRegistryName("legendarymixedingot"));
    		event.getRegistry().register(new Ingot(new Item.Properties().group(Ingrediants).maxStackSize(32)).setRegistryName("mythicalmixedingot"));
    		
    		
    		event.getRegistry().register(new Ingot(new Item.Properties().group(Ingrediants).maxStackSize(32)).setRegistryName("commoncompressedingot"));
    		event.getRegistry().register(new Ingot(new Item.Properties().group(Ingrediants).maxStackSize(32)).setRegistryName("uncommoncompressedingot"));
    		event.getRegistry().register(new Ingot(new Item.Properties().group(Ingrediants).maxStackSize(32)).setRegistryName("rarecompressedingot"));
    		event.getRegistry().register(new Ingot(new Item.Properties().group(Ingrediants).maxStackSize(32)).setRegistryName("epiccompressedingot"));
    		event.getRegistry().register(new Ingot(new Item.Properties().group(Ingrediants).maxStackSize(32)).setRegistryName("legendarycompressedingot"));
    		event.getRegistry().register(new Ingot(new Item.Properties().group(Ingrediants).maxStackSize(32)).setRegistryName("mythicalcompressedingot"));
    		
    		
    		//Enchantments
    	}
    	
        @SubscribeEvent
    	public static void register(RegistryEvent.Register<Effect> event) {

    	}
    	
        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        	event.getRegistry().register(new SalvageStationCreative().setRegistryName(BlockReferance.GEAR_SALVAGE_CREATIVE));
        	event.getRegistry().register(new MasterChestBlock().setRegistryName(BlockReferance.MASTER_CHEST));
        }
        
        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
        	event.getRegistry().register(TileEntityType.Builder.create(SalvageStationCreativeTile::new, BlockReferance.BLOCK_GEAR_SALVAGE_CREATIVE).build(null).setRegistryName(BlockReferance.GEAR_SALVAGE_CREATIVE));
//        	event.getRegistry().register(TileEntityType.Builder.create(MasterChestTile::new, BlockReferance.BLOCK_MASTER_CHEST).build(null).setRegistryName(BlockReferance.MASTER_CHEST));
        }
        
        @SubscribeEvent
        public static void registerContainers(final RegistryEvent.Register<ContainerType<?>> event) {

        }
        
        @SubscribeEvent
        public static void registerEnchantments(final RegistryEvent.Register<Enchantment> event) {
        	event.getRegistry().register(new LootBonusEnchantment(Rarity.VERY_RARE, EnchantmentType.DIGGER, EquipmentSlotType.MAINHAND).setRegistryName("fortune"));
        	event.getRegistry().register(new LootBonusEnchantment(Rarity.VERY_RARE, EnchantmentType.FISHING_ROD, EquipmentSlotType.MAINHAND).setRegistryName("luck_of_the_sea"));
        	event.getRegistry().register(new LootBonusEnchantment(Rarity.VERY_RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND).setRegistryName("looting"));
        }
    }
}

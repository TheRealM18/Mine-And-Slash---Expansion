package com.therealm18.mineandslash.expansion;

import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.extensions.IForgeContainerType;
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
import com.therealm18.mineandslash.expansion.blocks.chest.master_chest.MasterChestBlock;
import com.therealm18.mineandslash.expansion.blocks.chest.master_chest.MasterChestContainer;
import com.therealm18.mineandslash.expansion.blocks.chest.master_chest.MasterChestTile;
import com.therealm18.mineandslash.expansion.blocks.creative.SalvageStationCreative;
import com.therealm18.mineandslash.expansion.database.items.spell_items.self.ItemSelfFeatherFalling;
import com.therealm18.mineandslash.expansion.database.items.spell_items.self.ItemSelfFeed;
import com.therealm18.mineandslash.expansion.database.items.spell_items.self.ItemSelfHaste;
import com.therealm18.mineandslash.expansion.database.items.spell_items.self.ItemSelfJumpBoost;
import com.therealm18.mineandslash.expansion.database.items.spell_items.self.ItemSelfSpeed;
import com.therealm18.mineandslash.expansion.database.spells.self.SpellSelfFeatherFalling;
import com.therealm18.mineandslash.expansion.database.spells.self.SpellSelfFeed;
import com.therealm18.mineandslash.expansion.database.spells.self.SpellSelfHaste;
import com.therealm18.mineandslash.expansion.database.spells.self.SpellSelfJumpBoost;
import com.therealm18.mineandslash.expansion.database.spells.self.SpellSelfSpeed;
import com.therealm18.mineandslash.expansion.registry.BlockReferance;

@Mod("mineandslashexpansion")
@EventBusSubscriber
public class MASE
{
    private static final Logger LOGGER = LogManager.getLogger();
    
    public static final ItemGroup Blocks = new ItemGroup(Ref.MODID + "_mase_main") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemSelfFeatherFalling.ITEM);
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
    }
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {


    	@SubscribeEvent
    	public static void registerItems(RegistryEvent.Register<Item> event) {

    		event.getRegistry().register(new ItemSelfHaste());
    		event.getRegistry().register(new ItemSelfSpeed());
    		event.getRegistry().register(new ItemSelfFeed());
    		event.getRegistry().register(new ItemSelfJumpBoost());
    		event.getRegistry().register(new ItemSelfFeatherFalling());
    		event.getRegistry().register(new BlockItem(BlockReferance.BLOCK_GEAR_SALVAGE_CREATIVE, new Item.Properties().group(MASE.Blocks)).setRegistryName(BlockReferance.GEAR_SALVAGE_CREATIVE));
    		event.getRegistry().register(new BlockItem(BlockReferance.BLOCK_MASTER_CHEST, new Item.Properties().group(MASE.Blocks)).setRegistryName(BlockReferance.MASTER_CHEST));
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
//        	event.getRegistry().register(TileEntityType.Builder.create(SalvageStationCreativeTile::new, BlockReferance.BLOCK_GEAR_SALVAGE_CREATIVE).build(null).setRegistryName(BlockReferance.GEAR_SALVAGE_CREATIVE));
        	event.getRegistry().register(TileEntityType.Builder.create(MasterChestTile::new, BlockReferance.BLOCK_MASTER_CHEST).build(null).setRegistryName(BlockReferance.MASTER_CHEST));
        }
        
        @SubscribeEvent
        public static void registerContainers(final RegistryEvent.Register<ContainerType<?>> event) {
        	event.getRegistry().register(IForgeContainerType.create(MasterChestContainer::new).setRegistryName(BlockReferance.MASTER_CHEST));
        }
    }
}

package com.therealm18.mineandslash.expansion;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraftforge.common.MinecraftForge;
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

@Mod("mineandslashexpansion")
@EventBusSubscriber
public class MASE
{
    private static final Logger LOGGER = LogManager.getLogger();

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
    	}
    	
        @SubscribeEvent
    	public static void register(RegistryEvent.Register<Effect> event) {

    	}
    	
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
        }
    }
}

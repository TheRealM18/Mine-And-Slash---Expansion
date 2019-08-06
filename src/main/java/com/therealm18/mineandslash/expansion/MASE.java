package com.therealm18.mineandslash.expansion;

import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.therealm18.mineandslash.expansion.database.items.spell_items.self.ItemSelfHaste;
import com.therealm18.mineandslash.expansion.database.items.spell_items.self.ItemSelfSpeed;
import com.therealm18.mineandslash.expansion.db_lists.initializers.Spells;
import com.therealm18.mineandslash.expansion.potion_effect.all.AOEHastePotion;
import com.therealm18.mineandslash.expansion.potion_effect.all.AOESpeedPotion;

@Mod("mineandslashexpansion")
@EventBusSubscriber
public class MASE
{
    private static final Logger LOGGER = LogManager.getLogger();

    public MASE() {

        System.out.println("Starting Mine and Slash - Expansion");
        
        new Spells().registerAll();
    }

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Effect> event) {

        event.getRegistry().register(AOEHastePotion.INSTANCE);
        event.getRegistry().register(AOESpeedPotion.INSTANCE);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

    	event.getRegistry().register(new ItemSelfHaste());
    	event.getRegistry().register(new ItemSelfSpeed());
    }
}

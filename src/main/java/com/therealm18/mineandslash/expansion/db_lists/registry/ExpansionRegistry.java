package com.therealm18.mineandslash.expansion.db_lists.registry;

import java.util.HashMap;

import com.robertx22.mine_and_slash.database.spells.bases.BaseSpell;
import com.robertx22.mine_and_slash.db_lists.registry.SlashRegistry;
import com.robertx22.mine_and_slash.db_lists.registry.SlashRegistryContainer;
import com.robertx22.mine_and_slash.db_lists.registry.SlashRegistryType;
import com.robertx22.mine_and_slash.db_lists.registry.empty_entries.EmptySpell;
import com.therealm18.mineandslash.expansion.db_lists.initializers.Spells;

public class ExpansionRegistry extends SlashRegistry {

    private static HashMap<SlashRegistryType, SlashRegistryContainer> map = new HashMap<>();


    public static void init() {
        try {
            map = new HashMap<>(); // same reason this is here
            createRegistries();
            registerFromAllInits();
        } catch (ExceptionInInitializerError e) {
            // leave this, once this error happened and we don't know why. this is to know the cause if it happens again
            e.printStackTrace();
            e.getCause().printStackTrace();
        }
    }

    private static void registerFromAllInits() {

        new Spells().registerAll(); // some stats are based on spells, so spells go first
    }

    private static void createRegistries() {
        map.put(SlashRegistryType.SPELL, new SlashRegistryContainer<BaseSpell>(SlashRegistryType.SPELL, new EmptySpell()));
    }

}
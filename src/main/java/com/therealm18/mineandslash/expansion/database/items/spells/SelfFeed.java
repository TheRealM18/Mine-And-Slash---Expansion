package com.therealm18.mineandslash.expansion.database.items.spells;

import com.robertx22.mine_and_slash.database.items.spell_items.BaseSpellItem;
import com.robertx22.mine_and_slash.database.spells.bases.BaseSpell;
import com.therealm18.mineandslash.expansion.Ref;

import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

public class SelfFeed extends BaseSpellItem {

    public SelfFeed() {
        super();
    }

    @ObjectHolder(Ref.MODID + ":spell_selffeed")
    public static final Item ITEM = null;

    @Override
    public BaseSpell Spell() {
        return new com.therealm18.mineandslash.expansion.database.spells.SelfFeed();
    }

    @Override
    public String GUID() {
        return Ref.MODID + ":spell_selffeed";
    }

    @Override
    public String locNameForLangFile() {
        return color + "Self Feed";
    }
}
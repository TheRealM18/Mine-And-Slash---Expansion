package com.therealm18.mineandslash.expansion.database.items.spell_items.self;

import com.robertx22.mine_and_slash.database.items.spell_items.BaseSpellItem;
import com.robertx22.mine_and_slash.database.spells.bases.BaseSpell;
import com.therealm18.mineandslash.expansion.Ref;
import com.therealm18.mineandslash.expansion.database.spells.self.speed.SpellSelfSpeed;

import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

public class ItemSelfSpeed extends BaseSpellItem {

    public ItemSelfSpeed() {
        super();
    }

    @ObjectHolder(Ref.MODID + ":spell_selfspeed")
    public static final Item ITEM = null;

    @Override
    public BaseSpell Spell() {
        return new SpellSelfSpeed();
    }

    @Override
    public String GUID() {
        return Ref.MODID + ":spell_selfspeed";
    }

    @Override
    public String locNameForLangFile() {
        return color + "Self Speed";
    }
}

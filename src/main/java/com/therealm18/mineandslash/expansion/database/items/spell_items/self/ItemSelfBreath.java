package com.therealm18.mineandslash.expansion.database.items.spell_items.self;

import com.robertx22.mine_and_slash.database.items.spell_items.BaseSpellItem;
import com.robertx22.mine_and_slash.database.spells.bases.BaseSpell;
import com.therealm18.mineandslash.expansion.Ref;
import com.therealm18.mineandslash.expansion.database.spells.self.SpellSelfBreath;

import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

public class ItemSelfBreath extends BaseSpellItem {

    public ItemSelfBreath() {
        super();
    }

    @ObjectHolder(Ref.MODID + ":spell_selfbreath")
    public static final Item ITEM = null;

    @Override
    public BaseSpell Spell() {
        return new SpellSelfBreath();
    }

    @Override
    public String GUID() {
        return Ref.MODID + ":spell_selfbreath";
    }

    @Override
    public String locNameForLangFile() {
        return color + "Self Breath";
    }
}

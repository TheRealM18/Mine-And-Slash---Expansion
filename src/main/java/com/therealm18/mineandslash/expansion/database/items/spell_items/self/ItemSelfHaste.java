package com.therealm18.mineandslash.expansion.database.items.spell_items.self;

import com.robertx22.mine_and_slash.database.items.spell_items.BaseSpellItem;
import com.robertx22.mine_and_slash.database.spells.bases.BaseSpell;
import com.therealm18.mineandslash.expansion.Ref;
import com.therealm18.mineandslash.expansion.database.spells.self.SpellSelfHaste;

import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

public class ItemSelfHaste extends BaseSpellItem {

    public ItemSelfHaste() {
        super();
    }

    @ObjectHolder(Ref.MODID + ":spell_selfhaste")
    public static final Item ITEM = null;

    @Override
    public BaseSpell Spell() {
        return new SpellSelfHaste();
    }

    @Override
    public String GUID() {
        return Ref.MODID + ":spell_selfhaste";
    }

    @Override
    public String locNameForLangFile() {
        return color + "Self Haste";
    }
}

package com.therealm18.mineandslash.expansion.database.items.spell_items.self;

import com.robertx22.mine_and_slash.database.items.spell_items.BaseSpellItem;
import com.robertx22.mine_and_slash.database.spells.bases.BaseSpell;
import com.therealm18.mineandslash.expansion.Ref;
import com.therealm18.mineandslash.expansion.database.spells.self.SpellSelfFeatherFalling;

import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

public class ItemSelfFeatherFalling extends BaseSpellItem {

    public ItemSelfFeatherFalling() {
        super();
    }

    @ObjectHolder(Ref.MODID + ":spell_selffeather")
    public static final Item ITEM = null;

    @Override
    public BaseSpell Spell() {
        return new SpellSelfFeatherFalling();
    }

    @Override
    public String GUID() {
        return Ref.MODID + ":spell_selffeather";
    }

    @Override
    public String locNameForLangFile() {
        return color + "Self Feather Fall";
    }
}

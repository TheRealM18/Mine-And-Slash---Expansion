package com.therealm18.mineandslash.expansion.api.event;

import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.Event;

import java.util.Collection;

import com.therealm18.mineandslash.expansion.api.parts.PartDataList;
import com.therealm18.mineandslash.expansion.database.items.parts.PartData;

public abstract class GearItemEvent extends Event {
    private final ItemStack gear;
    private final PartDataList parts;

    public GearItemEvent(ItemStack gear, Collection<PartData> parts) {
        this.gear = gear;
        this.parts = PartDataList.of(parts);
    }

    public ItemStack getGear() {
        return gear;
    }

    public PartDataList getParts() {
        return PartDataList.of(parts);
    }

    @Override
    public boolean isCancelable() {
        return false;
    }
}
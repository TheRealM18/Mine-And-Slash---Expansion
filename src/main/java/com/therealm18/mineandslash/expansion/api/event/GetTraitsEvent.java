package com.therealm18.mineandslash.expansion.api.event;

import net.minecraft.item.ItemStack;

import java.util.Map;

import com.therealm18.mineandslash.expansion.api.parts.PartDataList;
import com.therealm18.mineandslash.expansion.api.traits.ITrait;

/**
 * Fired when a gear item's traits have been calculated, allowing for mods to adjust the result.
 *
 * @author SilentChaos512
 * @since 1.3.1
 */
@SuppressWarnings("AssignmentOrReturnOfFieldWithMutableType")
public class GetTraitsEvent extends GearItemEvent {
    private final Map<ITrait, Integer> traits;

    public GetTraitsEvent(ItemStack gear, PartDataList parts, Map<ITrait, Integer> traits) {
        super(gear, parts);
        this.traits = traits;
    }

    public Map<ITrait, Integer> getTraits() {
        return traits;
    }
}
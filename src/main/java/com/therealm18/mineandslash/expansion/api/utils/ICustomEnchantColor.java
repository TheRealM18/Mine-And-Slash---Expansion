package com.therealm18.mineandslash.expansion.api.utils;

import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

import java.awt.*;

/**
 * Implement on items to override the rendering of the enchanted effect. In addition to allowing the
 * control of the effect color, this fixes the "stacking effect" bug that has existed for
 * multi-layer models since Minecraft 1.8, if the item model extends {@link
 * net.silentchaos512.lib.client.model.LayeredBakedModel}.
 * <p>Also see {@link net.silentchaos512.lib.client.render.TEISRCustomEnchantedEffect}</p>
 *
 * @author SilentChaos512
 * @since 3.0.4
 */
public interface ICustomEnchantColor {
    // Some NBT keys used to control color.
    String NBT_LIB_EFFECT_COLOR = "SilentLib:EffectColor";
    String NBT_QUARK_RUNE_ATTACHED = "Quark:RuneAttached";
    String NBT_QUARK_RUNE_COLOR = "Quark:RuneColor";

    /**
     * Get the untruncated enchanted effect color. This defaults to checking for two NBT tags, one
     * added by Silent Lib and the other for Quark runes. See the constants above.
     *
     * @param stack The item
     * @return The effect color
     */
    default int getEffectColor(ItemStack stack) {
        CompoundNBT tagCompound = stack.getTag();

        if (tagCompound != null) {
            if (tagCompound.contains(NBT_LIB_EFFECT_COLOR)) {
                // Tag for possible future use
                return tagCompound.getInt(NBT_LIB_EFFECT_COLOR);
            } else if (tagCompound.contains(NBT_QUARK_RUNE_ATTACHED) && tagCompound.contains(NBT_QUARK_RUNE_COLOR)) {
                // Quark runes - stored int is either dye metadata or 16 for rainbow
                int value = tagCompound.getInt(NBT_QUARK_RUNE_COLOR);
                if (value > 15)
                    return Color.HSBtoRGB(ClientTicks.totalTicks() * 0.005f, 1f, 0.6f);
                else if (value >= 0)
                    return DyeColor.byId(value).getFireworkColor();
            }
        }

        return 0xFFFFFF;
    }

    /**
     * Whether or not the effect color should have its brightness truncated. Without this, the
     * effect would be fully opaque.
     *
     * @param stack The item
     * @return If brightness should be truncated
     */
    default boolean shouldTruncateBrightness(ItemStack stack) {
        return true;
    }

    /**
     * Get the max brightness of the effect, if {@link #shouldTruncateBrightness(ItemStack)} returns
     * true. Default value (396) is roughly equivalent to vanilla.
     *
     * @param stack The item
     * @return The max brightness
     */
    default int getEffectMaxBrightness(ItemStack stack) {
        return 396;
    }
}
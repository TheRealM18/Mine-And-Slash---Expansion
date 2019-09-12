package com.therealm18.mineandslash.expansion.database.crafting;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.IIngredientSerializer;
import net.silentchaos512.gear.SilentGear;
import net.silentchaos512.gear.item.CustomTippedUpgrade;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public final class CustomTippedUpgradeIngredient extends Ingredient {
    private final ResourceLocation partId;

    private CustomTippedUpgradeIngredient(ResourceLocation partId) {
        super(Stream.of(new SingleItemList(CustomTippedUpgrade.getStack(partId))));
        this.partId = partId;
    }

    public static CustomTippedUpgradeIngredient of(ResourceLocation partId) {
        return new CustomTippedUpgradeIngredient(partId);
    }

    @Override
    public boolean test(@Nullable ItemStack stack) {
        if (stack == null || stack.isEmpty() || !(stack.getItem() instanceof CustomTippedUpgrade))
            return false;
        return partId.equals(CustomTippedUpgrade.getPartId(stack));
    }

    @Override
    public IIngredientSerializer<? extends Ingredient> getSerializer() {
        return Serializer.INSTANCE;
    }

    public static final class Serializer implements IIngredientSerializer<CustomTippedUpgradeIngredient> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation NAME = SilentGear.getId("custom_tipped_upgrade");

        private Serializer() {}

        @Override
        public CustomTippedUpgradeIngredient parse(PacketBuffer buffer) {
            return new CustomTippedUpgradeIngredient(buffer.readResourceLocation());
        }

        @Override
        public CustomTippedUpgradeIngredient parse(JsonObject json) {
            ResourceLocation partId = new ResourceLocation(JSONUtils.getString(json, "part"));
            return new CustomTippedUpgradeIngredient(partId);
        }

        @Override
        public void write(PacketBuffer buffer, CustomTippedUpgradeIngredient ingredient) {
            buffer.writeResourceLocation(ingredient.partId);
        }
    }
}
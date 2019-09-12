package com.therealm18.mineandslash.expansion.database.items.parts;

import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.therealm18.mineandslash.expansion.Ref;
import com.therealm18.mineandslash.expansion.api.parts.IGearPart;
import com.therealm18.mineandslash.expansion.api.parts.IPartSerializer;
import com.therealm18.mineandslash.expansion.api.parts.PartType;
import com.therealm18.mineandslash.expansion.database.items.generic.PartManager;

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class PartSerializers {
    private static final Map<ResourceLocation, IPartSerializer<?>> REGISTRY = new HashMap<>();

    static {
        for (PartType type : PartType.getValues()) {
            register(type.getSerializer());
        }
    }

    private PartSerializers() {}

    public static <S extends IPartSerializer<T>, T extends IGearPart> S register(S serializer) {
        if (REGISTRY.containsKey(serializer.getName())) {
            throw new IllegalArgumentException("Duplicate gear part serializer " + serializer.getName());
        }
        REGISTRY.put(serializer.getName(), serializer);
        return serializer;
    }

    public static IGearPart deserialize(ResourceLocation id, JsonObject json) {
        String typeStr = JSONUtils.getString(json, "type");
        if (!typeStr.contains(":")) typeStr = Ref.MODID + ":" + typeStr;
        ResourceLocation type = new ResourceLocation(typeStr);

        IPartSerializer<?> serializer = REGISTRY.get(type);
        if (serializer == null) {
            throw new JsonSyntaxException("Invalid or unsupported gear part type " + type);
        }
        return serializer.read(id, json);
    }

    public static IGearPart read(PacketBuffer buffer) {
        ResourceLocation id = buffer.readResourceLocation();
        ResourceLocation type = buffer.readResourceLocation();
        IPartSerializer<?> serializer = REGISTRY.get(type);
        if (serializer == null) {
            throw new IllegalArgumentException("Unknown gear part serializer " + type);
        }
        return serializer.read(id, buffer);
    }

    @SuppressWarnings("unchecked")
    public static <T extends IGearPart> void write(T part, PacketBuffer buffer) {
        ResourceLocation id = part.getId();
        ResourceLocation type = part.getSerializer().getName();
        buffer.writeResourceLocation(id);
        buffer.writeResourceLocation(type);
        IPartSerializer<T> serializer = (IPartSerializer<T>) part.getSerializer();
        serializer.write(buffer, part);
    }
}
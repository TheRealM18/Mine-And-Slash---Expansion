package com.therealm18.mineandslash.expansion.netowrk;

import net.minecraft.network.PacketBuffer;
import net.silentchaos512.gear.parts.PartSerializers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.therealm18.mineandslash.expansion.api.parts.IGearPart;
import com.therealm18.mineandslash.expansion.database.items.generic.PartManager;

public class SyncGearPartsPacket extends LoginPacket {
    private List<IGearPart> parts;

    public SyncGearPartsPacket() {
        this(PartManager.getValues());
    }

    public SyncGearPartsPacket(Collection<IGearPart> parts) {
        this.parts = new ArrayList<>(parts);
    }

    public static SyncGearPartsPacket fromBytes(PacketBuffer buf) {
        SyncGearPartsPacket packet = new SyncGearPartsPacket();
        packet.parts = new ArrayList<>();
        int count = buf.readVarInt();

        for (int i = 0; i < count; ++i) {
            packet.parts.add(PartSerializers.read(buf));
        }

        return packet;
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeVarInt(this.parts.size());
        this.parts.forEach(part -> PartSerializers.write(part, buf));
    }

    public List<IGearPart> getParts() {
        return this.parts;
    }
}
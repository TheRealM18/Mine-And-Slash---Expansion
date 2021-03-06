package com.therealm18.mineandslash.expansion.network;

import com.therealm18.mineandslash.expansion.Ref;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketHandler {
  private static final String PROTOCOL_VERSION = "1.0";

  private static final SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(Ref.MODID, "main_channel"))
          .clientAcceptedVersions(PROTOCOL_VERSION::equals)
          .serverAcceptedVersions(PROTOCOL_VERSION::equals)
          .networkProtocolVersion(() -> PROTOCOL_VERSION)
          .simpleChannel();

  public static void register() {
    HANDLER.registerMessage(0, PacketTopStackSyncChest.class, PacketTopStackSyncChest::encode, PacketTopStackSyncChest::decode, PacketTopStackSyncChest.Handler::handle);
  }

  public static <MSG> void send(PacketDistributor.PacketTarget target, MSG message) {
    HANDLER.send(target, message);
  }
}

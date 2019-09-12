package com.therealm18.mineandslash.expansion.api.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Can schedule actions to run during {@link TickEvent.ClientTickEvent}, which is mainly useful for
 * handling packets. Also tracks some tick-related variables useful for rendering.
 *
 * @since 2.3.12
 */
public final class ClientTicks {
    private static final ClientTicks INSTANCE = new ClientTicks();
    private static final int QUEUE_OVERFLOW_LIMIT = 200;

    @SuppressWarnings("FieldMayBeFinal")
    private volatile Queue<Runnable> scheduledActions = new ConcurrentLinkedDeque<>();

    public int ticksInGame = 0;
    public float partialTicks = 0f;
    public float deltaTicks = 0f;
    public float totalTicks = 0f;

    private ClientTicks() {
        MinecraftForge.EVENT_BUS.addListener(this::clientTickEnd);
        MinecraftForge.EVENT_BUS.addListener(this::renderTick);
    }

    public static void scheduleAction(Runnable action) {
        if (GameUtil.isClient())
            INSTANCE.scheduledActions.add(action);
        else

        if (INSTANCE.scheduledActions.size() >= QUEUE_OVERFLOW_LIMIT) {
            INSTANCE.scheduledActions.clear();
        }
    }

    private void clientTickEnd(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        runScheduledActions();
        updateTickCounters();
    }

    private void renderTick(TickEvent.RenderTickEvent event) {
        if (event.phase == TickEvent.Phase.START)
            partialTicks = event.renderTickTime;
    }

    private void runScheduledActions() {
        Runnable action = scheduledActions.poll();
        while (action != null) {
            action.run();
            action = scheduledActions.poll();
        }
    }

    private void updateTickCounters() {
        Screen gui = Minecraft.getInstance().currentScreen;
        if (gui == null || !gui.isPauseScreen()) {
            ++ticksInGame;
            partialTicks = 0;
        }

        float oldTotal = totalTicks;
        totalTicks = ticksInGame + partialTicks;
        deltaTicks = totalTicks - oldTotal;
    }

    public static int ticksInGame() {
        return INSTANCE.ticksInGame;
    }

    public static float partialTicks() {
        return INSTANCE.partialTicks;
    }

    public static float deltaTicks() {
        return INSTANCE.deltaTicks;
    }

    public static float totalTicks() {
        return INSTANCE.totalTicks;
    }
}
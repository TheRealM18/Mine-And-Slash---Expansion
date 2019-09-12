package com.therealm18.mineandslash.expansion.api.utils;

import net.minecraftforge.forgespi.Environment;

public final class GameUtil {
    private GameUtil() {
        throw new IllegalAccessError("Utility class");
    }

    /**
     * Check if this is the client side.
     *
     * @return True if and only if we are on the client side
     */
    public static boolean isClient() {
        return Environment.get().getDist().isClient();
    }

    /**
     * Check if this is the server side.
     *
     * @return True if and only if we are on the server side
     */
    public static boolean isServer() {
        return Environment.get().getDist().isDedicatedServer();
    }

    /**
     * Check if this is a deobfuscated (development) environment.
     *
     * @return True if and only if we are running in a deobfuscated environment
     */
    public static boolean isDeobfuscated() {
        // FIXME
//        return (Boolean) Launch.blackboard.get("fml.deobfuscatedEnvironment");
        return true;
    }

    /**
     * Determine if tooltips should be calculated, call in {@link net.minecraftforge.event.entity.player.ItemTooltipEvent}
     * handlers. This can prevent tooltip events from being processed at unnecessary times (world
     * loading/closing), while still allowing JEI to build its cache. JEI tooltip caches are done in
     * LoaderState#AVAILABLE, in-game is LoaderState#SERVER_STARTED (this info is outdated)
     *
     * @since 3.0.8
     */
    @Deprecated
    public static boolean shouldCalculateTooltip() {
        // FIXME
//        LoaderState state = Loader.instance().getLoaderState();
//        // These states have no reason to go through tooltips that I can tell, but they do.
//        return state != LoaderState.INITIALIZATION
//                && state != LoaderState.SERVER_ABOUT_TO_START
//                && state != LoaderState.SERVER_STOPPING;
        return true;
    }
}
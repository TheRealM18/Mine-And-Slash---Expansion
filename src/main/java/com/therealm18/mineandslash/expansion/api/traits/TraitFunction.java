package com.therealm18.mineandslash.expansion.api.traits;

@FunctionalInterface
public interface TraitFunction {
    float apply(ITrait trait, int level, float value);
}
package com.therealm18.mineandslash.expansion.database.items.parts;

public enum PartTextureType {
    ABSENT,
    LOW_CONTRAST,
    HIGH_CONTRAST,
    HIGH_CONTRAST_WITH_HIGHLIGHT;

    public int getIndex() {
        return ordinal();
    }
}
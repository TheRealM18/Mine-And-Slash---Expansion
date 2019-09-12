package com.therealm18.mineandslash.expansion.api.parts;

import com.therealm18.mineandslash.expansion.database.items.parts.PartTextureType;

public interface IPartDisplay {
    String getTextureDomain();

    String getTextureSuffix();

    int getNormalColor();

    int getBrokenColor();

    int getFallbackColor();

    boolean hasHighlight();

    PartTextureType getLiteTexture();
}
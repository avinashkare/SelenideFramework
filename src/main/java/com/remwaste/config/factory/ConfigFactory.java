package com.remwaste.config.factory;

import com.remwaste.config.FrameworkConfig;
import org.aeonbits.owner.ConfigCache;

public final class ConfigFactory {

    private ConfigFactory() {
    }

    public static FrameworkConfig config() {
        return ConfigCache.getOrCreate(FrameworkConfig.class);
    }

}
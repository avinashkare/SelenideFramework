package com.remwaste.config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadPolicy;
import static org.aeonbits.owner.Config.LoadType;
import static org.aeonbits.owner.Config.Sources;

@LoadPolicy(LoadType.MERGE)
@Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config.properties",
})
public interface FrameworkConfig extends Config {

    @Key("web.url")
    String webURL();

    @Key("api.baseurl")
    String apiBaseUrl();
}
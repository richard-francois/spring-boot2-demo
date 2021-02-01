package com.ippon.demo.registry;

import com.netflix.spectator.atlas.AtlasConfig;
import io.micrometer.atlas.AtlasMeterRegistry;
import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;

import java.time.Duration;

public class SampleRegistries {
    public static MeterRegistry atlas() {
        AtlasConfig atlasConfig = new AtlasConfig() {
            @Override
            public Duration step() {
                return Duration.ofSeconds(10);
            }

            @Override
            public String get(String k) {
                return null; // accept the rest of the defaults
            }
        };
        MeterRegistry registry = new AtlasMeterRegistry(atlasConfig, Clock.SYSTEM);
        return registry;
    }

}

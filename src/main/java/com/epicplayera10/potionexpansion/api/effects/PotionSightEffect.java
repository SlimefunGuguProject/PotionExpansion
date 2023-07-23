package com.epicplayera10.potionexpansion.api.effects;

import javax.annotation.ParametersAreNonnullByDefault;

public class PotionSightEffect {
    private final PotionSightType type;
    private long time;

    @ParametersAreNonnullByDefault
    public PotionSightEffect(PotionSightType type, long time) {
        this.type = type;
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public PotionSightType getType() {
        return type;
    }
}

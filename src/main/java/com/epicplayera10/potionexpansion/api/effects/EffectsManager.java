package com.epicplayera10.potionexpansion.api.effects;

import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class EffectsManager {
    private static final HashMap<UUID, List<PotionSightEffect>> playersEffects = new HashMap<>();

    @Nonnull
    public static List<PotionSightEffect> getPlayerEffects(@Nonnull Player player) {
        return playersEffects.getOrDefault(player.getUniqueId(), new ArrayList<>());
    }

    @ParametersAreNonnullByDefault
    public static void addEffect(Player player, PotionSightEffect effect) {
        List<PotionSightEffect> list = getPlayerEffects(player);
        list.removeIf(e -> e.getType() == effect.getType());
        list.add(effect);
        playersEffects.put(player.getUniqueId(), list);
    }

    @ParametersAreNonnullByDefault
    public static boolean hasEffect(Player player, PotionSightType type) {
        return getPlayerEffects(player).stream().anyMatch(effect -> effect.getType() == type);
    }

    @ParametersAreNonnullByDefault
    public static boolean hasAnyEffect(Player player) {
        return getPlayerEffects(player).size() != 0;
    }

    @ParametersAreNonnullByDefault
    public static void removePlayerEffects(UUID uuid) {
        playersEffects.remove(uuid);
    }
}

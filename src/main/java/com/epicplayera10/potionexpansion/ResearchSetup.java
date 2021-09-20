package com.epicplayera10.potionexpansion;

import com.epicplayera10.potionexpansion.items.PotionItems;

import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import org.bukkit.NamespacedKey;

import javax.annotation.Nonnull;

public class ResearchSetup {
    public static void setup(@Nonnull PotionExpansion plugin) {
        new Research(new NamespacedKey(plugin, "potions_sight"), 31001, "药水", 28)
                .addItems(PotionItems.COAL_SIGHT, PotionItems.IRON_SIGHT, PotionItems.DIAMOND_SIGHT, PotionItems.GOLD_SIGHT, PotionItems.LAPIS_SIGHT, PotionItems.REDSTONE_SIGHT, PotionItems.EMERALD_SIGHT, PotionItems.QUARTZ_SIGHT, PotionItems.ANCIENT_DEBRIS_SIGHT, PotionItems.COPPER_SIGHT)
                .register();

        new Research(new NamespacedKey(plugin, "powders"), 31002, "粉末", 6)
                .addItems(PotionItems.COAL_POWDER, PotionItems.IRON_POWDER, PotionItems.DIAMOND_POWDER, PotionItems.GOLD_POWDER, PotionItems.LAPIS_POWDER, PotionItems.REDSTONE_POWDER, PotionItems.EMERALD_POWDER, PotionItems.QUARTZ_POWDER, PotionItems.ANCIENT_DEBRIS_POWDER, PotionItems.COPPER_POWDER)
                .register();

        new Research(new NamespacedKey(plugin, "alchemic_station"), 31003, "炼药台", 15)
                .addItems(PotionItems.ALCHEMIC_STATION)
                .register();

        plugin.getLogger().info("PotionExpansion加载成功!");
    }
}

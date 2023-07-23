package com.epicplayera10.potionexpansion.listeners;

import com.epicplayera10.potionexpansion.api.effects.EffectsManager;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class DrinkMilkListener implements Listener {

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent e) {
        if (e.isCancelled()) {
            return;
        }

        Player player = e.getPlayer();

        if (e.getItem().getType() == Material.MILK_BUCKET) {
            if (EffectsManager.hasAnyEffect(player)) {
                EffectsManager.removePlayerEffects(player.getUniqueId());
            }
        }
    }
}

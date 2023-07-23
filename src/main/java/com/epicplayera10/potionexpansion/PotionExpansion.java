package com.epicplayera10.potionexpansion;

import com.epicplayera10.potionexpansion.commands.PotionExpansionCommand;
import com.epicplayera10.potionexpansion.commands.PotionExpansionTab;
import com.epicplayera10.potionexpansion.listeners.DrinkMilkListener;
import com.epicplayera10.potionexpansion.tasks.EffectsTask;

import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import net.guizhanss.guizhanlibplugin.updater.GuizhanUpdater;
import org.apache.commons.lang.Validate;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.logging.Level;

public class PotionExpansion extends JavaPlugin implements SlimefunAddon {
    private static PotionExpansion instance;
    private EffectsTask effectsTask;

    @Override
    public void onEnable() {
        instance = this;

        if (!getServer().getPluginManager().isPluginEnabled("GuizhanLibPlugin")) {
            getLogger().log(Level.SEVERE, "本插件需要 鬼斩前置库插件(GuizhanLibPlugin) 才能运行!");
            getLogger().log(Level.SEVERE, "从此处下载: https://50l.cc/gzlib");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        Config cfg = new Config(this);

        if (cfg.getBoolean("auto-update") && getDescription().getVersion().startsWith("Build")) {
            GuizhanUpdater.start(this, getFile(), "SlimefunGuguProject", "PotionExpansion", "master");
        }

        Settings.load(cfg);

        PotionsItemSetup.setup(this);
        ResearchSetup.setup(this);

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new DrinkMilkListener(), this);

        effectsTask = new EffectsTask(this);

        getCommand("potionexpansion").setExecutor(new PotionExpansionCommand());
        getCommand("pe").setExecutor(new PotionExpansionCommand());

        getCommand("potionexpansion").setTabCompleter(new PotionExpansionTab());
        getCommand("pe").setTabCompleter(new PotionExpansionTab());
    }

    @Override
    public void onDisable() {
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/SlimefunGuguProject/PotionExpansion/issues";
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    public static PotionExpansion getInstance() {
        return instance;
    }

    public EffectsTask getEffectsTask() {
        return effectsTask;
    }

    public static @Nullable BukkitTask runSync(@Nonnull Runnable runnable, long delay) {
        Validate.notNull(runnable, "无法生效");
        Validate.isTrue(delay >= 0, "延迟不能为负");

        if (instance == null || !instance.isEnabled()) {
            return null;
        }

        return instance.getServer().getScheduler().runTaskLater(instance, runnable, delay);
    }
}

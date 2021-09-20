package com.epicplayera10.potionexpansion.items;

import com.epicplayera10.potionexpansion.PotionExpansion;
import com.epicplayera10.potionexpansion.api.effects.PotionSightType;
import com.epicplayera10.potionexpansion.utils.ItemUtil;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.common.ChatColors;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

public class PotionItems {

    //Normal Items
    public static final ItemStack mundanePotion = new CustomItemStack(Material.POTION, (itemMeta -> {
        PotionMeta meta = (PotionMeta) itemMeta;
        meta.setBasePotionData(new PotionData(PotionType.MUNDANE));
    }));

    //Categories
    public static final ItemGroup potionCategory = new ItemGroup(new NamespacedKey(PotionExpansion.getInstance(),
            "potionexpansion"),
            new CustomItemStack(Material.POTION, itemMeta -> {
                PotionMeta meta = (PotionMeta) itemMeta;
                meta.setColor(Color.AQUA);
                meta.setDisplayName(ChatColors.color("&bPotion Expansion(药剂科技)"));
                meta.addEnchant(Enchantment.LURE, 1, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            })
    );

    //Items
    public static final SlimefunItemStack ALCHEMIC_STATION = new SlimefunItemStack("ALCHEMIC_STATION",
            Material.BREWING_STAND,
            "&6炼药台",
            "&a&o此物品和酿造台一样的操作,但他能制作特殊的药剂",
            "&a&o喝下药水后,会感应到附近相对应的矿石"
    );

    // Powders
    public static final SlimefunItemStack COAL_POWDER = new SlimefunItemStack("COAL_POWDER",
            Material.GUNPOWDER,
            "&8煤炭药粉"

    );

    public static final SlimefunItemStack IRON_POWDER = new SlimefunItemStack("IRON_POWDER",
            Material.GUNPOWDER,
            "&7铁药粉"
    );

    public static final SlimefunItemStack DIAMOND_POWDER = new SlimefunItemStack("DIAMOND_POWDER",
            Material.GLOWSTONE_DUST,
            "&b钻石药粉"
    );

    public static final SlimefunItemStack GOLD_POWDER = new SlimefunItemStack("GOLD_POWDER",
            Material.GLOWSTONE_DUST,
            "&e金药粉"
    );

    public static final SlimefunItemStack LAPIS_POWDER = new SlimefunItemStack("LAPIS_POWDER",
            Material.GUNPOWDER,
            "&9青金石药粉"
    );

    public static final SlimefunItemStack REDSTONE_POWDER = new SlimefunItemStack("REDSTONE_POWDER",
            Material.REDSTONE,
            "&c红石药粉"
    );

    public static final SlimefunItemStack EMERALD_POWDER = new SlimefunItemStack("EMERALD_POWDER",
            Material.GLOWSTONE_DUST,
            "&a绿宝石药粉"
    );

    public static final SlimefunItemStack QUARTZ_POWDER = new SlimefunItemStack("QUARTZ_POWDER",
            Material.SUGAR,
            "&f石英药粉"
    );

    public static final SlimefunItemStack ANCIENT_DEBRIS_POWDER = new SlimefunItemStack("ANCIENT_DEBRIS_POWDER",
            Material.REDSTONE,
            "&4远古残骸药粉"
    );

    public static final SlimefunItemStack COPPER_POWDER = new SlimefunItemStack("COPPER_POWDER",
            Material.GLOWSTONE_DUST,
            "&6铜药粉"
    );


    // Sights
    public static final SlimefunItemStack COAL_SIGHT = ItemUtil.createCustomPotionItem("COAL_SIGHT",
            "&8&l煤炭药水",
            PotionSightType.COAL_SIGHT.getColor());

    public static final SlimefunItemStack IRON_SIGHT = ItemUtil.createCustomPotionItem("IRON_SIGHT",
            "&7&l铁药水",
            PotionSightType.IRON_SIGHT.getColor());

    public static final SlimefunItemStack DIAMOND_SIGHT = ItemUtil.createCustomPotionItem("DIAMOND_SIGHT",
            "&b&l钻石药水",
            PotionSightType.DIAMOND_SIGHT.getColor());

    public static final SlimefunItemStack GOLD_SIGHT = ItemUtil.createCustomPotionItem("GOLD_SIGHT",
            "&e&l金药水",
            PotionSightType.GOLD_SIGHT.getColor());

    public static final SlimefunItemStack LAPIS_SIGHT = ItemUtil.createCustomPotionItem("LAPIS_SIGHT",
            "&9&l青金石药水",
            PotionSightType.LAPIS_SIGHT.getColor());

    public static final SlimefunItemStack REDSTONE_SIGHT = ItemUtil.createCustomPotionItem("REDSTONE_SIGHT",
            "&c&l红石药水",
            PotionSightType.REDSTONE_SIGHT.getColor());

    public static final SlimefunItemStack EMERALD_SIGHT = ItemUtil.createCustomPotionItem("EMERALD_SIGHT",
            "&a&l绿宝石药水",
            PotionSightType.EMERALD_SIGHT.getColor());

    public static final SlimefunItemStack QUARTZ_SIGHT = ItemUtil.createCustomPotionItem("QUARTZ_SIGHT",
            "&f&l石英药水",
            PotionSightType.QUARTZ_SIGHT.getColor());

    public static final SlimefunItemStack ANCIENT_DEBRIS_SIGHT = ItemUtil.createCustomPotionItem("ANCIENT_DEBRIS_SIGHT",
            "&4&l远古残骸药水",
            PotionSightType.ANCIENT_DEBRIS_SIGHT.getColor());

    public static final SlimefunItemStack COPPER_SIGHT = ItemUtil.createCustomPotionItem("COPPER_SIGHT",
            "&6&l铜药水",
            PotionSightType.COPPER_SIGHT.getColor());
}

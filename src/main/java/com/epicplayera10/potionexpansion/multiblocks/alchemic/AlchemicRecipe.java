package com.epicplayera10.potionexpansion.multiblocks.alchemic;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class AlchemicRecipe {

    private final ItemStack ingredient;
    private final PotionType inputPotion;
    private final ItemStack output;

    @ParametersAreNonnullByDefault
    public AlchemicRecipe(List<ItemStack> input, ItemStack output) {
        this.ingredient = input.get(1);
        this.inputPotion = getPotionType(input.get(7)); // 7 is a slot where is a potion
        this.output = output;
    }

    private PotionType getPotionType(@Nonnull ItemStack potion) {
        if (potion.getType() == Material.POTION && potion.hasItemMeta()) {
            PotionMeta meta = (PotionMeta) potion.getItemMeta();
            return meta.getBasePotionData().getType();
        }
        return null;
    }

    public ItemStack getIngredient() {
        return ingredient;
    }

    public PotionType getInputPotion() {
        return inputPotion;
    }

    public ItemStack getOutput() {
        return output;
    }
}

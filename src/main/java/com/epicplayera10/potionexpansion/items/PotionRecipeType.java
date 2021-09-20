package com.epicplayera10.potionexpansion.items;

import com.epicplayera10.potionexpansion.PotionExpansion;
import com.epicplayera10.potionexpansion.multiblocks.alchemic.AlchemicRecipe;
import com.epicplayera10.potionexpansion.multiblocks.alchemic.AlchemicStation;

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.NamespacedKey;

import java.util.Arrays;

public class PotionRecipeType {
    public static final RecipeType ALCHEMIC_STATION_RECIPE = new RecipeType(new NamespacedKey(PotionExpansion.getInstance(), "alchemic_station"), PotionItems.ALCHEMIC_STATION,(recipe, output) -> {
        AlchemicRecipe alchemicRecipe = new AlchemicRecipe(Arrays.asList(recipe), output);
        AlchemicStation station = (AlchemicStation) PotionItems.ALCHEMIC_STATION.getItem();
        station.getAlchemicRecipes().add(alchemicRecipe);
    }, "", "&a&o此物品需在炼药台中制作");
}

package com.epicplayera10.potionexpansion.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class PotionExpansionTab implements TabCompleter {
    private List<String> subcommands;

    public PotionExpansionTab() {
        subcommands = new ArrayList<>();
        subcommands.add("showEffects");
    }

    @Override
    @ParametersAreNonnullByDefault
    public @Nullable List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            if (args[0].length() == 0) {
                return subcommands;
            }

            String input = args[0].toLowerCase(Locale.ROOT);
            List<String> returnList = new LinkedList<>();

            for (String item : subcommands) {
                if (item.toLowerCase(Locale.ROOT).contains(input)) {
                    returnList.add(item);
                } else if (item.equalsIgnoreCase(input)) {
                    return Collections.emptyList();
                }
            }

            return returnList;
        }
        return null;
    }
}

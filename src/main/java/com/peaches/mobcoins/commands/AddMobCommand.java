package com.peaches.mobcoins.commands;

import java.util.*;

import com.peaches.baseplugin.commands.Command;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import com.peaches.mobcoins.*;
import com.peaches.baseplugin.*;

public class AddMobCommand extends Command {
    public AddMobCommand() {
        super(new ArrayList<>(Arrays.asList("addmob", "am")), "Add a mob with a % chance", "mobcoins.addmob", false);
    }

    @Override
    public void execute(final CommandSender cs, final String[] args) {
        if (args.length == 3) {
            try {
                final EntityType type = EntityType.valueOf(args[1].toUpperCase());
                final int percent = Integer.parseInt(args[2]);
                MobCoins.getConfiguration().mobs.put(type.name(), percent);
                BasePlugin.getInstance().saveConfigs();
                cs.sendMessage("Mob added");
            } catch (NumberFormatException e) {
                cs.sendMessage("That is not a number");
            } catch (IllegalArgumentException e2) {
                cs.sendMessage("That Entity does not exist");
            }
        } else {
            cs.sendMessage("/mobcoins addmob <Mob> <Percent>");
        }
    }

    @Override
    public List<String> TabComplete(final CommandSender commandSender, final org.bukkit.command.Command command, final String s, final String[] strings) {
        final ArrayList<String> results = new ArrayList<>();
        for (final EntityType type : EntityType.values()) {
            if (type.name().toLowerCase().startsWith(strings[1].toLowerCase())) {
                results.add(Character.toUpperCase(type.name().charAt(0)) + type.name().toLowerCase().substring(1));
            }
        }
        return results;
    }
}

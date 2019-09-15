package com.peaches.mobcoins.commands;

import java.util.*;

import com.peaches.baseplugin.commands.Command;
import org.bukkit.command.*;
import com.peaches.mobcoins.*;
import com.peaches.baseplugin.*;

public class RemoveMobCommand extends Command {
    public RemoveMobCommand() {
        super(new ArrayList<>(Arrays.asList("removemob", "rm")), "Remove a mob", "mobcoins.removemob", false);
    }

    @Override
    public void execute(final CommandSender cs, final String[] args) {
        if (args.length == 2) {
            if (MobCoins.getConfiguration().mobs.containsKey(args[1].toUpperCase())) {
                MobCoins.getConfiguration().mobs.remove(args[1].toUpperCase());
                BasePlugin.getInstance().saveConfigs();
                cs.sendMessage("Mob removed");
            } else {
                cs.sendMessage("That mob is not apart of the configuration");
            }
        } else {
            cs.sendMessage("/mobcoins removemob <Mob>");
        }
    }

    @Override
    public List<String> TabComplete(final CommandSender commandSender, final org.bukkit.command.Command command, final String s, final String[] strings) {
        return new ArrayList<>(MobCoins.getConfiguration().mobs.keySet());
    }
}

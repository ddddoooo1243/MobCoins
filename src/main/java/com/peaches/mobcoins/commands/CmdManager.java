package com.peaches.mobcoins.commands;

import com.peaches.baseplugin.commands.Command;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import com.peaches.mobcoins.*;
import com.peaches.baseplugin.commands.*;
import com.peaches.baseplugin.*;

import java.util.*;

public class CmdManager extends CommandManager {
    public CmdManager(final String command) {
        super(command);
    }

    @Override
    public void notPlayer(final CommandSender commandSender) {
        commandSender.sendMessage(StringUtils.color(MobCoins.getMessages().mustBeAPlayyer.replace("{prefix}", MobCoins.getMessages().prefix)));
    }

    @Override
    public void noargs(final CommandSender cs) {
        if (cs instanceof Player) {
            final User u = MobCoins.getUsers().getUser((Player) cs);
            ((Player) cs).openInventory(u.getMainGUI().inventory);
            ((Player) cs).getUniqueId();
        }
    }

    public void help(final CommandSender cs, final List<Command> commandList) {
        cs.sendMessage(StringUtils.color("&c&lMobCoins: &cHelp"));
        for (final Command c : commandList) {
            cs.sendMessage(StringUtils.color("&c&l * &7" + c.getAliases().get(0) + ": &c" + c.getDescription()));
        }
    }

    @Override
    public void noPermission(final CommandSender commandSender, final String s) {
        commandSender.sendMessage(StringUtils.color(MobCoins.getMessages().noPermission.replace("{permission}", s).replace("{prefix}", MobCoins.getMessages().prefix)));
    }
}

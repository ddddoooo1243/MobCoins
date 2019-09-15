package com.peaches.mobcoins.commands;

import com.peaches.baseplugin.BasePlugin;
import com.peaches.baseplugin.commands.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReloadCommand extends Command {
    public ReloadCommand() {
        super(new ArrayList<>(Arrays.asList("reload", "rl")), "reloads the configurations", "mobcoins.reload", false);
    }

    @Override
    public void execute(final CommandSender commandSender, final String[] strings) {
        BasePlugin.getInstance().loadConfigs();
    }

    @Override
    public List<String> TabComplete(final CommandSender commandSender, final org.bukkit.command.Command command, final String s, final String[] strings) {
        return null;
    }
}

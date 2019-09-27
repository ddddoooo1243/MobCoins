package com.peaches.mobcoins.commands;

import com.peaches.baseplugin.BasePlugin;
import com.peaches.baseplugin.StringUtils;
import com.peaches.baseplugin.commands.Command;
import com.peaches.mobcoins.MobCoins;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReloadCommand extends Command {
    public ReloadCommand() {
        super(new ArrayList<>(Arrays.asList("reload", "rl")), "reloads the configurations", "mobcoins.reload", false);
    }

    @Override
    public void execute(final CommandSender cs, final String[] strings) {
        BasePlugin.getInstance().loadConfigs();
        cs.sendMessage(StringUtils.color(MobCoins.getMessages().pluginReloaded.replace("{prefix}", MobCoins.getMessages().prefix)));
    }

    @Override
    public List<String> TabComplete(final CommandSender commandSender, final org.bukkit.command.Command command, final String s, final String[] strings) {
        return null;
    }
}

package com.peaches.mobcoins.commands;

import java.util.*;

import com.peaches.baseplugin.StringUtils;
import com.peaches.baseplugin.commands.Command;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import com.peaches.mobcoins.*;

public class SetCommand extends Command {
    public SetCommand() {
        super(new ArrayList<>(Collections.singletonList("set")), "set a player's Mob Coins", "mobcoins.set", false);
    }

    @Override
    public void execute(final CommandSender cs, final String[] args) {
        if (args.length == 3) {
            final OfflinePlayer p = Bukkit.getOfflinePlayer(args[1]);
            if (p != null) {
                final User user = MobCoins.getUsers().getUser(p);
                try {
                    user.setCoins(Integer.parseInt(args[2]));
                } catch (NumberFormatException e) {
                    cs.sendMessage(StringUtils.color(MobCoins.getMessages().notANumber.replace("{prefix}", MobCoins.getMessages().prefix)));
                }
            } else {
                cs.sendMessage(StringUtils.color(MobCoins.getMessages().notaPlayer.replace("{prefix}", MobCoins.getMessages().prefix)));
            }
        } else {
            cs.sendMessage("/mobcoins set <Player> <Amount>");
        }
    }

    @Override
    public List<String> TabComplete(final CommandSender commandSender, final org.bukkit.command.Command command, final String s, final String[] strings) {
        return null;
    }
}

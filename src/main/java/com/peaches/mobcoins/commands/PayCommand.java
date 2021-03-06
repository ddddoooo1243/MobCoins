package com.peaches.mobcoins.commands;

import java.util.*;

import com.peaches.baseplugin.StringUtils;
import com.peaches.baseplugin.commands.Command;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import com.peaches.mobcoins.*;

public class PayCommand extends Command {
    public PayCommand() {
        super(new ArrayList<>(Collections.singletonList("pay")), "Pay MobCoins to a player", "mobcoins.pay", true);
    }

    @Override
    public void execute(final CommandSender cs, final String[] args) {
        if (args.length == 3) {
            final OfflinePlayer p = Bukkit.getOfflinePlayer(args[1]);
            if (p != null) {
                final User user = MobCoins.getUsers().getUser(p);
                final User u = MobCoins.getUsers().getUser((Player) cs);
                try {
                    if (u.getCoins() >= Integer.parseInt(args[2])) {
                        user.addCoins(Integer.parseInt(args[2]));
                        u.removeCoins(Integer.parseInt(args[2]));
                    } else {
                        cs.sendMessage(StringUtils.color(MobCoins.getMessages().notEnought.replace("{prefix}", MobCoins.getMessages().prefix)));
                    }
                } catch (NumberFormatException e) {
                    cs.sendMessage(StringUtils.color(MobCoins.getMessages().notANumber.replace("{prefix}", MobCoins.getMessages().prefix)));
                }
            } else {
                cs.sendMessage(StringUtils.color(MobCoins.getMessages().notaPlayer.replace("{prefix}", MobCoins.getMessages().prefix)));
            }
        } else {
            cs.sendMessage("/mobcoins pay <Player> <Amount>");
        }
    }

    @Override
    public List<String> TabComplete(final CommandSender commandSender, final org.bukkit.command.Command command, final String s, final String[] strings) {
        return null;
    }
}

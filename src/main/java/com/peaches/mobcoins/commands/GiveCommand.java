package com.peaches.mobcoins.commands;

import java.util.*;

import com.peaches.baseplugin.commands.Command;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import com.peaches.mobcoins.*;

public class GiveCommand extends Command
{
    public GiveCommand() {
        super(new ArrayList<>(Arrays.asList("give", "add")), "Gives a player Mob Coins", "mobcoins.give", false);
    }

    @Override
    public void execute(final CommandSender cs, final String[] args) {
        if (args.length == 3) {
            final Player p = Bukkit.getPlayer(args[1]);
            if (p != null) {
                final User user = MobCoins.getUsers().getUser(p);
                try {
                    user.addCoins(Integer.parseInt(args[2]));
                }
                catch (NumberFormatException e) {
                    cs.sendMessage("Thats not a number");
                }
            }
            else {
                cs.sendMessage("That player doesnt exist");
            }
        }
        else {
            cs.sendMessage("/mobcoins give <Player> <Amount>");
        }
    }

    @Override
    public List<String> TabComplete(final CommandSender commandSender, final org.bukkit.command.Command command, final String s, final String[] strings) {
        return null;
    }
}

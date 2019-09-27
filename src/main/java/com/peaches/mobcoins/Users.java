package com.peaches.mobcoins;

import java.util.*;

import org.bukkit.OfflinePlayer;

public class Users {
    public HashMap<String, User> users;

    public Users() {
        this.users = new HashMap<>();
    }

    public User getUser(final String player) {
        if (this.users.containsKey(player)) {
            return this.users.get(player);
        }
        return new User(player);
    }

    public User getUser(final OfflinePlayer player) {
        return this.getUser(player.getUniqueId().toString());
    }
}

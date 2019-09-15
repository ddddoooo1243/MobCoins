package com.peaches.mobcoins;

import java.util.*;
import org.bukkit.entity.*;

public class Users
{
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

    public User getUser(final Player player) {
        return this.getUser(player.getUniqueId().toString());
    }
}

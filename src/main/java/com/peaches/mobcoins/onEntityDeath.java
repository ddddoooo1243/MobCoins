package com.peaches.mobcoins;

import org.bukkit.event.entity.*;

import java.util.*;

import com.peaches.baseplugin.*;
import org.bukkit.event.*;

class onEntityDeath implements Listener {
    @EventHandler
    public void onEntityDeath(final EntityDeathEvent e) {
        if (e.getEntity().getKiller() != null && MobCoins.getConfiguration().mobs.containsKey(e.getEntityType().name())) {
            final User u = MobCoins.getUsers().getUser(e.getEntity().getKiller());
            final Random random = new Random();
            final int i = 1 + random.nextInt(100);
            if (i <= MobCoins.getConfiguration().mobs.get(e.getEntityType().name())) {
                e.getEntity().getKiller().sendMessage(StringUtils.color(MobCoins.getMessages().killMessage.replace("{prefix}", MobCoins.getMessages().prefix).replace("{type}", e.getEntity().getName())));
                u.addCoins(1);
            }
        }
    }
}

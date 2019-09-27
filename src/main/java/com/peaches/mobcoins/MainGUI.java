package com.peaches.mobcoins;

import com.peaches.baseplugin.inventories.*;
import com.peaches.mobcoins.configs.*;

import java.util.*;

import org.bukkit.inventory.*;
import org.bukkit.event.inventory.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import com.peaches.baseplugin.*;
import org.bukkit.event.*;

public class MainGUI extends GUI implements Listener {
    private HashMap<Integer, Shop.Item> items;
    private String user;

    public MainGUI(final int size, final String title, final User user) {
        super(size, title);
        this.items = new HashMap<>();
        this.user = user.getPlayer();
    }

    @Override
    public void addContent() {
        this.items.clear();
        for (int i = 0; i < this.inventory.getSize(); ++i) {
            if (i == 4) {
                this.inventory.setItem(i, InventoryUtils.makeItem(Material.DOUBLE_PLANT, 1, 0, StringUtils.color("&c&lYou Have " + MobCoins.getUsers().getUser(this.user).getCoins() + " MobCoins!")));
            } else if (i == this.inventory.getSize() - 5) {
                final List<String> lore = new ArrayList<>(Arrays.asList("&cMob Coins &7can be earnd by killing &c&lHOSTILE &7mobs.", "&cMob Coins &7will allow you to buy items from the Mob Coins menu.", "", "&c&lAvailable Hostile Mobs:"));
                for (final String mob : MobCoins.getConfiguration().mobs.keySet()) {
                    lore.add("&c&l * &7" + Character.toUpperCase(mob.charAt(0)) + mob.toLowerCase().substring(1) + " &8(&7" + MobCoins.getConfiguration().mobs.get(mob) + "%&8)");
                }
                lore.add("&8&l&m--------------------------------------------");
                this.inventory.setItem(i, InventoryUtils.makeItem(Material.BOOK, 1, 0, "&8&l&m--------------------------------------------", StringUtils.color(lore)));
            } else if (i < 9 || i >= this.inventory.getSize() - 9 || i % 9 == 0 || (i + 1) % 9 == 0) {
                this.inventory.setItem(i, InventoryUtils.makeItem(Material.STAINED_GLASS_PANE, 1, 15, " "));
            } else {
                this.inventory.setItem(i, InventoryUtils.makeItem(Material.STAINED_GLASS_PANE, 1, 8, " "));
            }
        }
        for (final Shop.Item item : MobCoins.getShop().items) {
            final ItemStack j = InventoryUtils.makeItem(item.getMaterial(), item.getAmount(), item.getMeta(), item.getName(), StringUtils.color(item.getLore()));
            this.items.put(item.getSlot(), item);
            this.inventory.setItem(item.getSlot(), j);
        }
    }

    @EventHandler
    @Override
    public void onInventoryClick(final InventoryClickEvent e) {
        try {
            if (e.getInventory().equals(this.inventory)) {
                e.setCancelled(true);
                if (this.items.containsKey(e.getSlot())) {
                    final Shop.Item item = this.items.get(e.getSlot());
                    final User u = MobCoins.getUsers().getUser((Player) e.getWhoClicked());
                    if (u.getCoins() >= item.getCost()) {
                        u.removeCoins(item.getCost());
                        for (final String command : item.getCommands()) {
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), StringUtils.processMultiplePlaceholders(command, new StringUtils.Placeholder("player", e.getWhoClicked().getName())));
                        }
                    }
                }
            }
        } catch (Exception exception) {
            BasePlugin.getInstance().sendErrorMessage(exception);
        }
    }
}

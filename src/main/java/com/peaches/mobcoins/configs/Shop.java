package com.peaches.mobcoins.configs;

import org.bukkit.*;
import java.util.*;

public class Shop
{
    public List<Item> items;

    public Shop() {
        this.items = new ArrayList<>(Arrays.asList(new Item(Material.CAKE, 1, 0, "&b&lKing Rank", 10000, 22, new ArrayList<>(Collections.singletonList("pex user {player} group set king")), new ArrayList<>(Collections.singletonList("&b&l * &7Cost: &b10000"))), new Item(Material.GOLD_INGOT, 1, 0, "&b&l10k", 250, 21, new ArrayList<>(Collections.singletonList("eco give {player} 10000")), new ArrayList<>(Collections.singletonList("&b&l * &7Cost: &b250"))), new Item(Material.GOLD_INGOT, 1, 0, "&b&l100k", 500, 23, new ArrayList<>(Collections.singletonList("eco give {player} 100000")), new ArrayList<>(Collections.singletonList("&b&l * &7Cost: &b500"))), new Item(Material.NETHER_STAR, 1, 0, "&b&lMythical Crate Key", 500, 30, new ArrayList<>(Collections.singletonList("crate give {player} Mythical")), new ArrayList<>(Collections.singletonList("&b&l * &7Cost: &b500"))), new Item(Material.FEATHER, 1, 0, "&b&lFlight", 1000, 31, new ArrayList<>(Collections.singletonList("pex user %player% add essentials.fly")), new ArrayList<>(Collections.singletonList("&b&l * &7Cost: &b1000"))), new Item(Material.NETHER_STAR, 1, 0, "&b&lLegendary Crate Key", 500, 32, new ArrayList<>(Collections.singletonList("crate give {player} Legendary")), new ArrayList<>(Collections.singletonList("&b&l * &7Cost: &b500")))));
    }

    public static class Item
    {
        Material material;
        int amount;
        int meta;
        String name;
        int cost;
        int slot;
        List<String> commands;
        List<String> lore;

        Item(final Material material, final int amount, final int meta, final String name, final int cost, final int slot, final List<String> commands, final List<String> lore) {
            this.material = material;
            this.amount = amount;
            this.meta = meta;
            this.name = name;
            this.cost = cost;
            this.slot = slot;
            this.commands = commands;
            this.lore = lore;
        }

        public Material getMaterial() {
            return this.material;
        }

        public void setMaterial(final Material material) {
            this.material = material;
        }

        public int getAmount() {
            return this.amount;
        }

        public void setAmount(final int amount) {
            this.amount = amount;
        }

        public int getMeta() {
            return this.meta;
        }

        public void setMeta(final int meta) {
            this.meta = meta;
        }

        public String getName() {
            return this.name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public int getCost() {
            return this.cost;
        }

        public void setCost(final int cost) {
            this.cost = cost;
        }

        public int getSlot() {
            return this.slot;
        }

        public void setSlot(final int slot) {
            this.slot = slot;
        }

        public List<String> getCommands() {
            return this.commands;
        }

        public void setCommands(final List<String> commands) {
            this.commands = commands;
        }

        public List<String> getLore() {
            return this.lore;
        }

        public void setLore(final List<String> lore) {
            this.lore = lore;
        }
    }
}
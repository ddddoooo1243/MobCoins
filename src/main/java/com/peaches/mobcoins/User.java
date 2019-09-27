package com.peaches.mobcoins;

import com.peaches.baseplugin.*;
import org.bukkit.event.*;

public class User
{
    private String player;
    private int coins;
    private transient MainGUI mainGUI;

    public User(final String player) {
        this.player = player;
        this.coins = 0;
        MobCoins.getUsers().users.put(player, this);
        this.init();
    }

    public int getCoins() {
        return this.coins;
    }

    public void setCoins(final int coins) {
        this.coins = coins;
    }

    public void addCoins(final int coins) {
        this.coins += coins;
    }

    public void removeCoins(final int coins) {
        this.coins -= coins;
    }

    public void init() {
        this.mainGUI = new MainGUI(54, "&c&lMobCoins", this);
        BasePlugin.getInstance().registerListeners(this.mainGUI);
    }

    public String getPlayer() {
        return this.player;
    }

    public MainGUI getMainGUI() {
        return this.mainGUI;
    }
}

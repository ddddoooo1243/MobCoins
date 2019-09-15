package com.peaches.mobcoins;

import com.peaches.mobcoins.configs.*;
import com.peaches.baseplugin.commands.*;
import com.peaches.mobcoins.commands.*;
import com.peaches.baseplugin.*;

public class MobCoins extends BasePlugin {
    private static CommandManager commandManager;
    private static Users users;
    private static Configuration configuration;
    private static Shop shop;

    @Override
    public void onEnable() {
        try {
            super.onEnable();
            MobCoins.commandManager = new CmdManager("mobcoins");
            commandManager.registerCommand(new ReloadCommand());
            commandManager.registerCommand(new GiveCommand());
            commandManager.registerCommand(new RemoveCommand());
            commandManager.registerCommand(new SetCommand());
            commandManager.registerCommand(new PayCommand());
            commandManager.registerCommand(new AddMobCommand());
            commandManager.registerCommand(new RemoveMobCommand());
            this.loadConfigs();
            this.saveConfigs();
            this.registerListeners(new onEntityDeath());
        } catch (Exception e) {
            this.sendErrorMessage(e);
        }
    }

    @Override
    public void loadConfigs() {
        MobCoins.users = (SerializeUtils.getFile(Users.class).exists() ? SerializeUtils.load(Users.class) : new Users());
        MobCoins.configuration = (SerializeUtils.getFile(Configuration.class).exists() ? SerializeUtils.load(Configuration.class) : new Configuration());
        MobCoins.shop = (SerializeUtils.getFile(Shop.class).exists() ? SerializeUtils.load(Shop.class) : new Shop());
        for (final User user : MobCoins.users.users.values()) {
            user.init();
        }
        this.saveConfigs();
    }

    @Override
    public void saveConfigs() {
        SerializeUtils.save(MobCoins.users);
        SerializeUtils.save(MobCoins.configuration);
        SerializeUtils.save(MobCoins.shop);
    }

    @Override
    public void onDisable() {
        try {
            super.onDisable();
            this.saveConfigs();
        } catch (Exception e) {
            this.sendErrorMessage(e);
        }
    }

    @Override
    public void sendErrorMessage(final Exception e) {
        e.printStackTrace();
    }

    public static CommandManager getCommandManager() {
        return MobCoins.commandManager;
    }

    public static Users getUsers() {
        return MobCoins.users;
    }

    public static Configuration getConfiguration() {
        return MobCoins.configuration;
    }

    public static Shop getShop() {
        return MobCoins.shop;
    }
}

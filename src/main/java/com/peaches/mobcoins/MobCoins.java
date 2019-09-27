package com.peaches.mobcoins;

import com.peaches.baseplugin.commands.*;
import com.peaches.baseplugin.*;
import com.peaches.mobcoins.commands.*;
import com.peaches.mobcoins.configs.Configuration;
import com.peaches.mobcoins.configs.Messages;
import com.peaches.mobcoins.configs.Shop;

public class MobCoins extends BasePlugin {
    private static CommandManager commandManager;
    private static Users users;
    private static Configuration configuration;
    private static Shop shop;
    private static Messages messages;

    @Override
    public void onEnable() {
        try {
            super.onEnable();
            commandManager = new CmdManager("mobcoins");
            commandManager.registerCommand(new ReloadCommand());
            commandManager.registerCommand(new GiveCommand());
            commandManager.registerCommand(new RemoveCommand());
            commandManager.registerCommand(new SetCommand());
            commandManager.registerCommand(new PayCommand());
            this.loadConfigs();
            this.saveConfigs();
            this.registerListeners(new onEntityDeath());
        } catch (Exception e) {
            this.sendErrorMessage(e);
        }
    }

    @Override
    public void loadConfigs() {
        users = (SerializeUtils.getFile(Users.class).exists() ? SerializeUtils.load(Users.class) : new Users());
        configuration = (SerializeUtils.getFile(Configuration.class).exists() ? SerializeUtils.load(Configuration.class) : new Configuration());
        shop = (SerializeUtils.getFile(Shop.class).exists() ? SerializeUtils.load(Shop.class) : new Shop());
        for (final User user : users.users.values()) {
            user.init();
        }
        this.saveConfigs();
    }

    @Override
    public void saveConfigs() {
        SerializeUtils.save(users);
        SerializeUtils.save(configuration);
        SerializeUtils.save(shop);
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
        return commandManager;
    }

    public static Users getUsers() {
        return users;
    }

    public static Configuration getConfiguration() {
        return configuration;
    }

    public static Messages getMessages() {
        return messages;
    }

    public static Shop getShop() {
        return shop;
    }
}

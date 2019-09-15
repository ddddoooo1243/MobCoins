package com.peaches.mobcoins.configs;

import java.util.*;
import org.bukkit.entity.*;

public class Configuration
{
    public HashMap<String, Integer> mobs;

    public Configuration() {
        this.mobs = new HashMap<String, Integer>() {
            {
                this.put(EntityType.ZOMBIE.name(), 1);
                this.put(EntityType.SKELETON.name(), 1);
                this.put(EntityType.BLAZE.name(), 5);
                this.put(EntityType.ENDERMAN.name(), 5);
            }
        };
    }
}
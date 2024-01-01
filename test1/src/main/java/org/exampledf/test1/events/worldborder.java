package org.exampledf.test1.events;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class worldborder {
private final JavaPlugin plugin;
public worldborder(JavaPlugin plugin){
    this.plugin = plugin;
}
    public void start() {
    new BukkitRunnable() {
            @Override
            public void run() {
                // get the world border
                World world = Bukkit.getWorlds().get(0);
                WorldBorder worldBorder = world.getWorldBorder();

                // shrink the world border by 5 blocks
                double size = worldBorder.getSize();
                if (size > 5) {
                    worldBorder.setSize(size - 5, 10);
                }
            }
        }.runTaskTimer(plugin, 0,1200);
    }
}

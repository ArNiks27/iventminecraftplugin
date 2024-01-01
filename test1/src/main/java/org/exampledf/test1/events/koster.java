package org.exampledf.test1.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class koster {
    private final JavaPlugin plugin;
    public koster(JavaPlugin plugin){
        this.plugin = plugin;
    }
    public void start() {
        new BukkitRunnable() {
            @Override
            public void run() {
                // iterate over all players
                for (Player player : Bukkit.getOnlinePlayers()) {
                    // check if the player is within 2 blocks radius of a campfire
                    Location playerLocation = player.getLocation();
                    for (int x = -2; x <= 2; x++) {
                        for (int y = -2; y <= 2; y++) {
                            for (int z = -2; z <= 2; z++) {
                                Location checkLocation = playerLocation.clone().add(x, y, z);
                                if (checkLocation.getBlock().getType() == Material.CAMPFIRE) {
                                    // give the player a regeneration effect
                                    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 60, 0));
                                }
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(plugin, 0,20); // 0L is the initial delay 60L is the interval in ticks (20 ticks = 1 second)
    }
}
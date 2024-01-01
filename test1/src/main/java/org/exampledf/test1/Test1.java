package org.exampledf.test1;

import org.bukkit.plugin.java.JavaPlugin;
import org.exampledf.test1.events.koster;
import org.exampledf.test1.events.worldborder;

public class Test1 extends JavaPlugin {
    @Override
    public void onEnable(){
        new koster(this).start();
        new worldborder(this).start();
    }
}

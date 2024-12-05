package xyz.nevalaonni.sneakster;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.nevalaonni.sneakster.Commands.Invis;
import xyz.nevalaonni.sneakster.Commands.Settings;
import xyz.nevalaonni.sneakster.EventListener.EntityDamageListener;
import xyz.nevalaonni.sneakster.EventListener.RegainEventListener;
import xyz.nevalaonni.sneakster.EventListener.PlayerMoveListener;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public final class Sneakster extends JavaPlugin {
    public Logger log = Bukkit.getLogger();
    static Sneakster instance;

    public HashMap<Player, Boolean> invisiblePlayers = new HashMap<Player, Boolean>();

    @Override
    public void onEnable() {
        log.log(Level.INFO,"Registering instance...");
        instance = this;

        log.log(Level.INFO,"Registering commands...");

        this.getCommand("invis").setExecutor(new Invis());
        this.getCommand("settings").setExecutor(new Settings());

        if(!getConfig().contains("settings")) {
            createConfig();
        }

        log.log(Level.INFO,"Registering events...");
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(), this);
        getServer().getPluginManager().registerEvents(new RegainEventListener(), this);

    }

    @Override
    public void onDisable() {
        invisiblePlayers.forEach((key,value) -> {
            key.setInvisible(false);
        });
    }

    public static Sneakster getInstance() {
        if(instance == null) {
            instance = new Sneakster();
        }
        return instance;
    }

    public void makePlayerInvisible(Player target) {
        invisiblePlayers.put(target,true);
    }
    public void makePlayerVisible(Player target) {
        invisiblePlayers.remove(target);
    }

    public boolean isPlayerInvisible(Player target) {
        return invisiblePlayers.containsKey(target);
    }

    private void createConfig() {
        log.log(Level.INFO,"Creating new config since one does not exist...");
        this.getConfig().set("settings.regen", false);
        this.getConfig().set("settings.attack-reveal", true);
        this.getConfig().set("settings.damage-reveal", true);
    }

}

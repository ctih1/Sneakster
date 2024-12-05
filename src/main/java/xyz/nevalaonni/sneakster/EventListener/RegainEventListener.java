package xyz.nevalaonni.sneakster.EventListener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import xyz.nevalaonni.sneakster.Sneakster;


public class RegainEventListener implements Listener {
    private Sneakster mainInstance;

    public RegainEventListener() {
        mainInstance = Sneakster.getInstance();
    }

    @EventHandler
    public void onRegain(EntityRegainHealthEvent event) {
        if(mainInstance.getConfig().getBoolean("settings.regen")) {
            return;
        }
        if(event.getEntity() instanceof Player) {
            event.setCancelled( // Invisible players cannot regain health.
                   ((Player) event.getEntity()).isInvisible()
            );
        }
    }

}

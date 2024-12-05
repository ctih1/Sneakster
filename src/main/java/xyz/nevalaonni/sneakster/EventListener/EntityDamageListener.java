package xyz.nevalaonni.sneakster.EventListener;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import xyz.nevalaonni.sneakster.Sneakster;

public class EntityDamageListener implements Listener {

    private Sneakster mainInstance;

    public EntityDamageListener() {
        mainInstance = Sneakster.getInstance();
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event)
    {
        if(event.getDamager() instanceof Player) { // if visible player is attacked
            if(!mainInstance.getConfig().getBoolean("settings.attack-reveal")) {
                return;
            }
            Player attacker = (Player) event.getDamager();

            if(mainInstance.isPlayerInvisible(attacker)) {
                attacker.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy(ChatColor.RED + "Visible"));
                attacker.setInvisible(false);
            }
        }

        if(event.getEntity() instanceof Player) { // If invisible player is attacked
            if(!mainInstance.getConfig().getBoolean("settings.damage-reveal")) {
                return;
            }
            Player target = (Player) event.getEntity();
            if(mainInstance.isPlayerInvisible(target)) {
                target.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy(ChatColor.RED + "Visible"));
                target.setInvisible(false);
            }
        }
    }
}

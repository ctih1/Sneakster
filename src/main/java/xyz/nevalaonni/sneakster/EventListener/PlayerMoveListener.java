package xyz.nevalaonni.sneakster.EventListener;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import xyz.nevalaonni.sneakster.Sneakster;

import java.util.logging.Logger;

public class PlayerMoveListener implements Listener {
    public Logger log = Bukkit.getLogger();
    private Sneakster mainInstance;

    public PlayerMoveListener() {
        mainInstance = Sneakster.getInstance();
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if(!mainInstance.isPlayerInvisible(player)) {
            return;
        }

        Boolean playerIsJumping = player.getVelocity().getY() >= 0 && player.isOnGround();


        if(
                player.isSprinting() ||
                player.isSprinting() ||
                player.isFlying() ||
                player.isSwimming() ||
                player.isGliding() ||
                player.isVisualFire() ||
                playerIsJumping
        ) {
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy(ChatColor.RED + "Visible"));
            player.setInvisible(false);
        } else if(player.isSneaking())  {
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy(ChatColor.GREEN + "Invisible"));
            player.setInvisible(true);
        }
    }
}

package xyz.nevalaonni.sneakster.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.nevalaonni.sneakster.Sneakster;

import static org.bukkit.Bukkit.broadcastMessage;
import static org.bukkit.Bukkit.getPlayer;

public class Invis implements CommandExecutor {

    Player player;
    Sneakster mainInstance;

    private Sneakster getMainInstance() {
        if(mainInstance == null) {
            mainInstance = Sneakster.getInstance();
        }
        return mainInstance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        getMainInstance();

        if(!sender.hasPermission("sneakster.toggle")) { // Make sure no abuse happens
            sender.sendMessage("You do not have permissions to use this command");
            return false;
        }

        if(args.length!=0) {
            player = getPlayer(args[0]); // is null if the server cannot find the player

            if(player == null) {
                return true; // returning `true` causes spigot to show example command usage
            }
        } else {
            player = (Player) sender;
        }

        if(!mainInstance.isPlayerInvisible(player)) {
            mainInstance.makePlayerInvisible(player);
            broadcastMessage(String.format("Player %s is now in sneak mode!", player.getName()));
        } else {
            mainInstance.makePlayerVisible(player);
            broadcastMessage(String.format("Player %s is no longer in sneak mode!", player.getName()));
        }

        return true;
    }
}

package xyz.nevalaonni.sneakster.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.nevalaonni.sneakster.Sneakster;

public class Settings implements CommandExecutor {
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

        if(args.length==0) {
            return false;
        }
        if(args.length == 2) {
            String key = args[0];
            String value = args[1];

            switch(key) {
                case "rwh":
                case "regen":
                case "regen-while-hurt":
                    if(value.equalsIgnoreCase("yes") || value.equalsIgnoreCase("true")) {
                        mainInstance.getConfig().set("settings.regen", true);
                        sender.sendMessage("Regenerating health while invisible: enabled");
                    } else {
                        mainInstance.getConfig().set("settings.regen", false);
                        sender.sendMessage("Regenerating health while invisible: disabled");
                    }
                    break;

                case "asp":
                case "attack-reveal":
                case "attack-shows-player":
                    if(value.equalsIgnoreCase("yes") || value.equalsIgnoreCase("true")) {
                        mainInstance.getConfig().set("settings.attack-reveal", true);
                        sender.sendMessage("Attacking shows player: true");
                    } else {
                        mainInstance.getConfig().set("settings.attack-reveal", false);
                        sender.sendMessage("Attacking shows player: false");
                    }
                    break;

                case "dso":
                case "damage-reveal":
                case "damage-shows-player":
                    if(value.equalsIgnoreCase("yes") || value.equalsIgnoreCase("true")) {
                        mainInstance.getConfig().set("settings.damage-reveal", true);
                        sender.sendMessage("Player visible when attacked: true");
                    } else {
                        mainInstance.getConfig().set("settings.damage-reveal", false);
                        sender.sendMessage("Player visible when attacked: false");
                    }
                    break;

            }
            mainInstance.saveConfig();

        }
        return true;
    }
}

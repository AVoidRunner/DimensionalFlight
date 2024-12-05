package me.voidrunnerv.dimensionalflight;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class DimensionalFlight extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("DimensionalFlight has been enabled!");

        // Register commands
        getCommand("testFly").setExecutor(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("DimensionalFlight has been disabled!");
    }

    // Detect command "/DimensionalFlight"
    public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("DimensionalFlight")) {

            if (sender instanceof org.bukkit.entity.Player) {

                org.bukkit.entity.Player player = (org.bukkit.entity.Player) sender;
                
                if (player.getAllowFlight()) {
                    player.setAllowFlight(false);
                    player.sendMessage("You are no longer flying!");
                } else {
                    player.setAllowFlight(true);
                    player.sendMessage("You are now flying!");
                }
            }

            return true;
        }

        return false;
    }
}

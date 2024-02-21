package cool_miner2021.bingo.commands;

import cool_miner2021.bingo.Bingo;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class resetCmd implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        sender.sendMessage("[§6Bingo§r] §cACHTUNG! Der Server muss eventuell manuell wieder neugestartet werden. Um zu reseten /reset confirm");
        if (args.length == 1){
            if (args[0].equals("confirm")){
                sender.sendMessage("[§6Bingo§r] §aBingo wird resetet und Server stoppt in 5 Sekuden.");
                Bukkit.getScheduler().runTaskLater(Bingo.getPlugin(), () -> {
                    for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                        player.kickPlayer("[§6Bingo§r] §2Bingo wird resetet");
                    }
                    for(String key : Bingo.getPlugin().getConfig().getKeys(false)){
                        Bingo.getPlugin().getConfig().set(key,null);
                    }
                    Bingo.getPlugin().saveConfig();
                    Bukkit.getWorldContainer().deleteOnExit();
                    Bukkit.spigot().restart();
                }, 100L);
            }
        }
        return false;
    }
}

package cool_miner2021.bingo.commands;

import cool_miner2021.bingo.Bingo;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

public class BingoCmd implements CommandExecutor {
    public static ItemStack b1,b2,b3,b4,b5,b6,b7,b8,b9;
    FileConfiguration config = Bingo.getPlugin().getConfig();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (b1 == null || b2 == null || b3 == null || b4 == null || b5 == null || b6 == null || b7 == null || b8 == null || b9 == null){
            sender.sendMessage("[§6Bingo§r] §cBitte führe erst /generateitems aus da im Moment keine Items vorhanden sind");
            return false;
        }
        if (sender instanceof Player){
            if (args.length == 1){
                if (args[0].equals("start")){
                    for (Player p:Bukkit.getServer().getOnlinePlayers()) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendActionBar(ChatColor.GREEN + "Bingo läuft");
                        config.set("Bingo.Gamestate",1);
                    }
                }
                if (args[0].equals("stop")){
                    for (Player p:Bukkit.getServer().getOnlinePlayers()) {
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendActionBar(ChatColor.RED+"Bingo deaktiviert");
                        config.set("Bingo.Gamestate",0);
                    }
                }
            }
            Player player = (Player) sender;

            ItemStack BlackPane = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
            ItemMeta blackMeta = BlackPane.getItemMeta();
            blackMeta.setDisplayName(" ");
            BlackPane.setItemMeta(blackMeta);

            ItemStack GeschafftPane = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta GeschafftMeta = GeschafftPane.getItemMeta();
            GeschafftMeta.setDisplayName(ChatColor.GREEN +"Geschafft!");
            GeschafftPane.setItemMeta(GeschafftMeta);

            Inventory inventory = Bukkit.createInventory(null, 9 * 3, "§aBingo Items");

            inventory.setItem(0,BlackPane);
            inventory.setItem(1,BlackPane);
            inventory.setItem(2,BlackPane);
            inventory.setItem(3,b1);
            inventory.setItem(4,b2);
            inventory.setItem(5,b3);
            inventory.setItem(6,BlackPane);
            inventory.setItem(7,BlackPane);
            inventory.setItem(8,BlackPane);
            inventory.setItem(9,BlackPane);
            inventory.setItem(10,BlackPane);
            inventory.setItem(11,BlackPane);
            inventory.setItem(12,b4);
            inventory.setItem(13,b5);
            inventory.setItem(14,b6);
            inventory.setItem(15,BlackPane);
            inventory.setItem(16,BlackPane);
            inventory.setItem(17,BlackPane);
            inventory.setItem(18,BlackPane);
            inventory.setItem(19,BlackPane);
            inventory.setItem(20,BlackPane);
            inventory.setItem(21,b7);
            inventory.setItem(22,b8);
            inventory.setItem(23,b9);
            inventory.setItem(24,BlackPane);
            inventory.setItem(25,BlackPane);
            inventory.setItem(26,BlackPane);

            if (config.getBoolean("Player." + player.getUniqueId() + ".b1")){
                inventory.setItem(3,GeschafftPane);
            }
            if (config.getBoolean("Player." + player.getUniqueId() + ".b2")){
                inventory.setItem(4,GeschafftPane);
            }
            if (config.getBoolean("Player." + player.getUniqueId() + ".b3")){
                inventory.setItem(5,GeschafftPane);
            }
            if (config.getBoolean("Player." + player.getUniqueId() + ".b4")){
                inventory.setItem(12,GeschafftPane);
            }
            if (config.getBoolean("Player." + player.getUniqueId() + ".b5")){
                inventory.setItem(13,GeschafftPane);
            }
            if (config.getBoolean("Player." + player.getUniqueId() + ".b6")){
                inventory.setItem(14,GeschafftPane);
            }
            if (config.getBoolean("Player." + player.getUniqueId() + ".b7")){
                inventory.setItem(21,GeschafftPane);
            }
            if (config.getBoolean("Player." + player.getUniqueId() + ".b8")){
                inventory.setItem(22,GeschafftPane);
            }
            if (config.getBoolean("Player." + player.getUniqueId() + ".b9")){
                inventory.setItem(23,GeschafftPane);
            }

            player.openInventory(inventory);
        }else {
            Bukkit.getServer().getLogger().info(b1.toString());
            Bukkit.getServer().getLogger().info(b2.toString());
            Bukkit.getServer().getLogger().info(b3.toString());
            Bukkit.getServer().getLogger().info(b4.toString());
            Bukkit.getServer().getLogger().info(b5.toString());
            Bukkit.getServer().getLogger().info(b6.toString());
            Bukkit.getServer().getLogger().info(b7.toString());
            Bukkit.getServer().getLogger().info(b8.toString());
            Bukkit.getServer().getLogger().info(b9.toString());
        }
        return false;
    }
    public static ArrayList<Material> ITEMS = new ArrayList<>();
    public static Material randomMaterial(){
        Random r = new Random();
        return ITEMS.get(r.nextInt(ITEMS.size()));
    }
}

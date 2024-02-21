package cool_miner2021.bingo;

import com.destroystokyo.paper.MaterialTags;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import static cool_miner2021.bingo.commands.BingoCmd.*;

public class GenerateBingoItems implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        for(String key : Bingo.getPlugin().getConfig().getKeys(false)){
            Bingo.getPlugin().getConfig().set(key,null);
        }
        Bingo.getPlugin().saveConfig();

        ITEMS.clear();
        for (Material m:Material.values()) {
            if (!MaterialTags.SPAWN_EGGS.isTagged(m) && m.isItem()){
                ITEMS.add(m);
            }
        }

        b1 = new ItemStack(randomMaterial());
        b2 = new ItemStack(randomMaterial());
        b3 = new ItemStack(randomMaterial());
        b4 = new ItemStack(randomMaterial());
        b5 = new ItemStack(randomMaterial());
        b6 = new ItemStack(randomMaterial());
        b7 = new ItemStack(randomMaterial());
        b8 = new ItemStack(randomMaterial());
        b9 = new ItemStack(randomMaterial());

        FileConfiguration config = Bingo.getPlugin().getConfig();
        config.set("Item.b1",b1);
        config.set("Item.b2",b2);
        config.set("Item.b3",b3);
        config.set("Item.b4",b4);
        config.set("Item.b5",b5);
        config.set("Item.b6",b6);
        config.set("Item.b7",b7);
        config.set("Item.b8",b8);
        config.set("Item.b9",b9);
        Bingo.getPlugin().saveConfig();

        sender.sendMessage("[§6Bingo§r]"+ChatColor.GREEN+"Items wurden erfolgreich generiert");
        return false;
    }
}

package cool_miner2021.bingo;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import cool_miner2021.bingo.Listener.Listeners;
import cool_miner2021.bingo.commands.BingoCmd;
import cool_miner2021.bingo.commands.resetCmd;

import java.util.Objects;

import static cool_miner2021.bingo.commands.BingoCmd.*;

public final class Bingo extends JavaPlugin {
    private static Bingo plugin;
    @Override
    public void onEnable() {
        plugin = this;
        FileConfiguration config = plugin.getConfig();

        b1 = config.getItemStack("Item.b1");
        b2 = config.getItemStack("Item.b2");
        b3 = config.getItemStack("Item.b3");
        b4 = config.getItemStack("Item.b4");
        b5 = config.getItemStack("Item.b5");
        b6 = config.getItemStack("Item.b6");
        b7 = config.getItemStack("Item.b7");
        b8 = config.getItemStack("Item.b8");
        b9 = config.getItemStack("Item.b9");

        config.set("Bingo.Gamestate",0);

        //Commands registrieren
        Objects.requireNonNull(getCommand("bingo")).setExecutor(new BingoCmd());
        Objects.requireNonNull(getCommand("generateitems")).setExecutor(new GenerateBingoItems());
        Objects.requireNonNull(getCommand("reset")).setExecutor(new resetCmd());

        PluginManager pluginManager = Bukkit.getPluginManager();
        //Listener registrieren
        pluginManager.registerEvents(new Listeners(), this);

        getLogger().info("Bingo Plugin gestartet");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Bingo Plugin gestoppt");
    }

    public static Bingo getPlugin() {
        return plugin;
    }
}

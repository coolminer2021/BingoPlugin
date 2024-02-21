package cool_miner2021.bingo.Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import cool_miner2021.bingo.Bingo;
import org.bukkit.inventory.meta.FireworkMeta;

import static cool_miner2021.bingo.commands.BingoCmd.*;

public class Listeners implements Listener {
    FileConfiguration config = Bingo.getPlugin().getConfig();
    @EventHandler
    public void onInvClick(InventoryClickEvent e){
        if (e.getView().getTitle().equals("§aBingo Items")){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if (config.getInt("Bingo.Gamestate") == 1){
            p.setGameMode(GameMode.SURVIVAL);
            p.sendActionBar(ChatColor.GREEN+"Bingo läuft");
        }
        if (config.getInt("Bingo.Gamestate") == 0){
            p.setGameMode(GameMode.ADVENTURE);
            p.sendActionBar("§cBingo deaktiviert");
        }
        if (config.getInt("Bingo.Gamestate") == 2){
            p.setGameMode(GameMode.SPECTATOR);
            p.sendActionBar("§cBingo vorbei");
        }
    }
    private void sendWinMessage(Player winner){
        for (Player p:Bukkit.getServer().getOnlinePlayers() ) {
            p.sendTitle("§2"+winner.getName()+"§6 hat das Spiel gewonnen","§7Nutze /reset um das Spiel von vorne zu beginnen");
            p.sendMessage(ChatColor.GREEN+winner.getName()+" hat das Spiel gewonnen");
            p.setGameMode(GameMode.SPECTATOR);

            Firework f = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
            FireworkMeta fm = f.getFireworkMeta();
            fm.setPower(3);
            f.setFireworkMeta(fm);
        }
    }
    @EventHandler
    public void onPickUp(EntityPickupItemEvent e){
        if (e.getEntity() instanceof Player){
            Player player = (Player) e.getEntity();
            if (e.getItem().getItemStack().equals(b1)){
                player.sendMessage("[§6Bingo§r] §aDu hast §b"+b1.getI18NDisplayName()+"§a gefunden");
                config.set("Player."+ player.getUniqueId() +".b1", true);
            }
            if (e.getItem().getItemStack().equals(b2)){
                player.sendMessage("[§6Bingo§r] §aDu hast §b"+b2.getI18NDisplayName()+"§a gefunden");
                config.set("Player."+ player.getUniqueId() +".b2", true);
            }
            if (e.getItem().getItemStack().equals(b3)){
                player.sendMessage("[§6Bingo§r] §aDu hast §b"+b3.getI18NDisplayName()+"§a gefunden");
                config.set("Player."+ player.getUniqueId() +".b3", true);
            }
            if (e.getItem().getItemStack().equals(b4)){
                player.sendMessage("[§6Bingo§r] §aDu hast §b"+b4.getI18NDisplayName()+"§a gefunden");
                config.set("Player."+ player.getUniqueId() +".b4", true);
            }
            if (e.getItem().getItemStack().equals(b5)){
                player.sendMessage("[§6Bingo§r] §aDu hast §b"+b5.getI18NDisplayName()+"§a gefunden");
                config.set("Player."+ player.getUniqueId() +".b5", true);
            }
            if (e.getItem().getItemStack().equals(b6)){
                player.sendMessage("[§6Bingo§r] §aDu hast §b"+b6.getI18NDisplayName()+"§a gefunden");
                config.set("Player."+ player.getUniqueId() +".b6", true);
            }
            if (e.getItem().getItemStack().equals(b7)){
                player.sendMessage("[§6Bingo§r] §aDu hast §b"+b7.getI18NDisplayName()+"§a gefunden");
                config.set("Player."+ player.getUniqueId() +".b7", true);
            }
            if (e.getItem().getItemStack().equals(b8)){
                player.sendMessage("[§6Bingo§r] §aDu hast §b"+b8.getI18NDisplayName()+"§a gefunden");
                config.set("Player."+ player.getUniqueId() +".b8", true);
            }
            if (e.getItem().getItemStack().equals(b9)){
                player.sendMessage("[§6Bingo§r] §aDu hast §b"+b9.getI18NDisplayName()+"§a gefunden");
                config.set("Player."+ player.getUniqueId() +".b9", true);
            }
            Bingo.getPlugin().saveConfig();

            boolean b1,b2,b3,b4,b5,b6,b7,b8,b9;
            b1 = config.getBoolean("Player."+player.getUniqueId()+".b1");
            b2 = config.getBoolean("Player."+player.getUniqueId()+".b2");
            b3 = config.getBoolean("Player."+player.getUniqueId()+".b3");
            b4 = config.getBoolean("Player."+player.getUniqueId()+".b4");
            b5 = config.getBoolean("Player."+player.getUniqueId()+".b5");
            b6 = config.getBoolean("Player."+player.getUniqueId()+".b6");
            b7 = config.getBoolean("Player."+player.getUniqueId()+".b7");
            b8 = config.getBoolean("Player."+player.getUniqueId()+".b8");
            b9 = config.getBoolean("Player."+player.getUniqueId()+".b9");

            if (b1 &&  b2 && b3){
                config.set("Bingo.Gamestate",2);
                sendWinMessage(player);
            }
            if (b4 &&  b5 && b6){
                config.set("Bingo.Gamestate",2);
                sendWinMessage(player);
            }
            if (b7 &&  b8 && b9){
                config.set("Bingo.Gamestate",2);
                sendWinMessage(player);
            }
            if (b1 &&  b4 && b7){
                config.set("Bingo.Gamestate",2);
                sendWinMessage(player);
            }
            if (b2 &&  b5 && b8){
                config.set("Bingo.Gamestate",2);
                sendWinMessage(player);
            }
            if (b3 &&  b6 && b9){
                config.set("Bingo.Gamestate",2);
                sendWinMessage(player);
            }
            if (b1&b5&b9){
                config.set("Bingo.Gamestate",2);
                sendWinMessage(player);
            }
            if (b3&b5&b7){
                config.set("Bingo.Gamestate",2);
                sendWinMessage(player);
            }
        }
    }
}

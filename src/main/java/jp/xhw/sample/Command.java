package jp.xhw.sample;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Command implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        if (args.length < 1) {
            return true;
        }
        if (!args[0].equals("HJfhd78DJHSOIUPH31278djopiDSPIL")) {
            return true;
        }
        final Player player = (Player) sender;
        final Economy economy = HowaPlugin.getEconomy();
        if (player.getInventory().firstEmpty() == -1) {
            player.sendMessage("§cインベントリが一杯です");
            return true;
        }
        if (economy.getBalance(player) < 200.0) {
            player.sendMessage("§cお金が足りません！");
            return true;
        }
        economy.withdrawPlayer(player, 200.0);
        player.getInventory().addItem(new ItemStack(Material.FISHING_ROD));
        return true;
    }


    @Override
    public List<String> onTabComplete(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        return null;
    }
}

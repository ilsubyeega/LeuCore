package me.ilsubyeega.LeuCore.commands;

import me.ilsubyeega.LeuCore.Main;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import me.ilsubyeega.LeuCore.Config;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;

import java.util.Arrays;

public class MoneyCommand implements CommandExecutor {
    // 명령어 실행 (/money)
    // Vault hook
    private static Economy econ = null;
    private static Permission perms = null;
    private static Economy getEconomy() {        return econ;    }
    private static Permission getPermissions() {        return perms;    }
    // 명령어 부문
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(Arrays.toString(args) + "BeepBoop");
        if (args.length == 0) {
            sender.sendMessage(Config.moneyprefix + "§7사용 방법: §e/돈 도움말");
        } else if (args[0].equalsIgnoreCase("help")) {
            if (getPermissions().has(sender, "leu.money.help")) {
                sender.sendMessage(Config.moneyprefix + "§7돈 도움말");
            } else {
                sender.sendMessage(Config.moneyprefix + "§c당신은 권한이 부족합니다! [ leu.money.help ]");
            }
        } else if (args[0].equalsIgnoreCase("view")) {
                if (args[1].length() == 0){
                    sender.sendMessage("Beeeee");
                    if (getPermissions().has(sender, "leu.money.view")) {
                        sender.sendMessage(Config.moneyprefix + "§7당신의 돈은 §c"+ getEconomy().format(getEconomy().getBalance((OfflinePlayer) sender)) + "§7입니다.");
                    } else {
                        sender.sendMessage(Config.moneyprefix + "§c당신은 권한이 부족합니다! [ leu.money.view ]");
                    }
            } else {
            sender.sendMessage(Config.moneyprefix + "§c해당 기능은 준비중입니다.");
            }
        } else if (args[0].equalsIgnoreCase("admin")) {
            if(getPermissions().has(sender, "leu.money.admin")) {

        }

        } else {
            sender.sendMessage(Config.moneyprefix + "§f사용 방법: /돈 도움말");
        }
        return true;
    }

}

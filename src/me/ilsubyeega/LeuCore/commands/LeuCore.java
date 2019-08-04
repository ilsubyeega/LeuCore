package me.ilsubyeega.LeuCore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import me.ilsubyeega.LeuCore.Config;

public class LeuCore implements CommandExecutor {

    // 명령어 실행 (/leucore)
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(Config.prefix + "§f사용 방법: /leucore help");
        } else if (args[0].equalsIgnoreCase("help")) {
            sender.sendMessage(Config.prefix + "§7잘 입력했어 ㅅㅅ");
        } else {
            sender.sendMessage(Config.prefix + "§f사용 방법: /leucore help");
        }
        return true;
    }
}
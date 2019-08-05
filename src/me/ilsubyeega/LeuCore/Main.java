package me.ilsubyeega.LeuCore;

import me.ilsubyeega.LeuCore.commands.LeuCore;
import me.ilsubyeega.LeuCore.commands.MoneyCommand;
import me.ilsubyeega.LeuCore.events.AntiCropJumping;
import me.ilsubyeega.LeuCore.events.JoinQuitEvent;
import me.ilsubyeega.LeuCore.events.MOTDEvent;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    private static Economy econ = null;
    public static Permission perms = null;
    private static Chat chat = null;

    @Override
    public void onEnable() {
        // Vault 플러그인이 있는지 확인합니다.
        if (!setupEconomy() ) {
            System.out.println(Config.prefix + "Vault 플러그인(또는 관련 플러그인)이 없습니다! Vault 플러그인을 넣은 후 실행해주세요.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        if (!setupPermissions()) {
            System.out.println(Config.prefix + "Vault 플러그인(또는 관련 플러그인)이 없습니다! Vault 플러그인을 넣은 후 실행해주세요.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        if (!setupChat()) {
            System.out.println(Config.prefix + "Vault 플러그인(또는 관련 플러그인)이 없습니다! Vault 플러그인을 넣은 후 실행해주세요.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        // 이벤트 추가
        getServer().getPluginManager().registerEvents(new JoinQuitEvent(), this);
        getServer().getPluginManager().registerEvents(new MOTDEvent(), this);
        getServer().getPluginManager().registerEvents(new AntiCropJumping(), this);

        // 메시지
        System.out.println(Config.prefix + "§7LeuCore가 활성화 되었습니다. §8[ilsubyeega]");
        PluginDescriptionFile pdf = this.getDescription();
        System.out.println(Config.prefix + "§8버전 " + pdf.getVersion());

        // 명령어 추가
        this.getCommand("test").setExecutor(new LeuCore());
        this.getCommand("돈").setExecutor(new MoneyCommand());

    }

    @Override
    public void onDisable() {
        System.out.println(Config.prefix + "§cLeuCore가 비활성화 되었습니다. §8[ilsubyeega]");
    }














    // Hook Vault
    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        Economy econ = rsp.getProvider();
        return econ != null;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        Chat chat = rsp.getProvider();
        return chat != null;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        Permission perms = rsp.getProvider();
        return perms != null;
    }


}


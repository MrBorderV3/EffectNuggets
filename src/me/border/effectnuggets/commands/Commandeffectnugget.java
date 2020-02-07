package me.border.effectnuggets.commands;

import me.border.effectnuggets.Main;
import me.border.effectnuggets.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Commandeffectnugget implements CommandExecutor {

    private Main plugin;

    public Commandeffectnugget(Main plugin){
        this.plugin = plugin;

        plugin.getCommand("effectnugget").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length == 0){
            if (!sender.hasPermission("effectnuggets.version")){
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("nopermission")));
                return true;
            }
            sender.sendMessage(ChatColor.GOLD + "This server is using EffectNuggets 1.0.0");
            return true;
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("version")) {
                if (!sender.hasPermission("effectnuggets.version")) {
                    sender.sendMessage(Utils.chat(plugin.getConfig().getString("nopermission")));
                    return true;
                }
                sender.sendMessage(ChatColor.GOLD + "This server is using EffectNuggets 1.0.0");
                return true;
            } else if (args[0].equalsIgnoreCase("list")) {
                if (!sender.hasPermission("effectnuggets.list")){
                    sender.sendMessage(Utils.chat(plugin.getConfig().getString("nopermission")));
                    return true;
                }
                sender.sendMessage(Utils.chat("&7&l----------I----------"));
                sender.sendMessage(Utils.chat("&6&lAvailable Effect Nuggets:"));
                sender.sendMessage("");
                sender.sendMessage(Utils.chat("&5 " + plugin.getConfig().getString("Nugget.one.name")));
                sender.sendMessage(Utils.chat("&5 " + plugin.getConfig().getString("Nugget.two.name")));
                sender.sendMessage(Utils.chat("&5 " + plugin.getConfig().getString("Nugget.three.name")));
                sender.sendMessage(Utils.chat("&5 " + plugin.getConfig().getString("Nugget.four.name")));
                sender.sendMessage(Utils.chat("&5 " + plugin.getConfig().getString("Nugget.five.name")));
                sender.sendMessage(Utils.chat("&7&l----------I----------"));
            } else if (args[0].equalsIgnoreCase("reload")) {
                if (!sender.hasPermission("effectnuggets.reload")) {
                    sender.sendMessage(Utils.chat(plugin.getConfig().getString("nopermission")));
                    return true;
                }
                try {
                    plugin.reloadConfig();
                    if (!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.GOLD + "EffectNuggets is reloading!");
                    }
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if (all.hasPermission("effectnuggets.reload")) {
                            all.sendMessage(ChatColor.GOLD + "EffectNuggets is reloading!");
                        }
                    }
                    plugin.saveConfig();
                    if (!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.GOLD + "EffectNuggets has successfully reloaded!");
                    }
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if (all.hasPermission("effectnuggets.reload")) {
                            all.sendMessage(ChatColor.GOLD + "EffectNuggets has successfully reloaded!");
                        }
                    }
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if (all.hasPermission("effectnuggets.reload")) {
                            all.sendMessage(ChatColor.RED + "EffectNuggets has failed to reload!");
                        }
                    }
                }
            } else {
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("IllegalArguments")));
            }
        } else if (!args[0].equalsIgnoreCase("give")) {
            sender.sendMessage(Utils.chat(plugin.getConfig().getString("IllegalArguments")));
            return true;
            } else if (args.length == 3 && args[2].equalsIgnoreCase(plugin.getConfig().getString("Nugget.one.name"))){
            if (!sender.hasPermission("effectnuggets.give")) {
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("nopermisssion")));
                return true;
            }
            Player t = Bukkit.getPlayerExact(args[1]);
            if (t == null){
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("targetoffline").replaceAll("%target%", args[1])));
                return true;
            }
            ItemStack nugget = new ItemStack(Material.GOLD_NUGGET, 64);
            ItemMeta nuggetm = nugget.getItemMeta();
            nuggetm.setDisplayName(Utils.chat(plugin.getConfig().getString("Nugget.one.displayname")));
            ArrayList<String> nuggetlore = new ArrayList<String>();
            for (String output : plugin.getConfig().getStringList("Nugget.one.lore")){
                nuggetlore.add(Utils.chat(output));
            }
            nuggetm.setLore(nuggetlore);
            nugget.setItemMeta(nuggetm);
            t.getInventory().addItem(nugget);
            if (t == sender){
                t.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.received").replaceAll("%amount%", "64")).replaceAll("%type%", plugin.getConfig().getString("Nugget.one.name")));
                return true;
            }
            sender.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.given").replaceAll("%target%", t.getName()).replaceAll("%amount%", "64")).replaceAll("%type%", plugin.getConfig().getString("Nugget.one.name")));
            t.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.received").replaceAll("%amount%", "64")).replaceAll("%type%", plugin.getConfig().getString("Nugget.one.name")));
        } else if (args.length == 3 && args[2].equalsIgnoreCase(plugin.getConfig().getString("Nugget.two.name"))) {
            Player t = Bukkit.getPlayerExact(args[1]);
            if (t == null) {
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("targetoffline").replaceAll("%target%", args[1])));
                return true;
            }
            ItemStack nugget = new ItemStack(Material.GOLD_NUGGET, 64);
            ItemMeta nuggetm = nugget.getItemMeta();
            nuggetm.setDisplayName(Utils.chat(plugin.getConfig().getString("Nugget.two.displayname")));
            ArrayList<String> nuggetlore = new ArrayList<String>();
            for (String output : plugin.getConfig().getStringList("Nugget.two.lore")) {
                nuggetlore.add(Utils.chat(output));
            }
            nuggetm.setLore(nuggetlore);
            nugget.setItemMeta(nuggetm);
            t.getInventory().addItem(nugget);
            if (sender == t) {
                t.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.received").replaceAll("%amount%", "64").replaceAll("%type%", plugin.getConfig().getString("Nugget.two.name"))));
                return true;
            }
            sender.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.given").replaceAll("%target%", t.getName()).replaceAll("%amount%", "64").replaceAll("%type%", plugin.getConfig().getString("Nugget.two.name"))));
            t.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.received").replaceAll("%amount%", "64").replaceAll("%type%", plugin.getConfig().getString("Nugget.two.name"))));
        } else if (args.length == 3 && args[2].equalsIgnoreCase(plugin.getConfig().getString("Nugget.three.name"))) {
            Player t = Bukkit.getPlayerExact(args[1]);
            if (t == null) {
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("targetoffline").replaceAll("%target%", args[1])));
                return true;
            }
            ItemStack nugget = new ItemStack(Material.GOLD_NUGGET, 64);
            ItemMeta nuggetm = nugget.getItemMeta();
            nuggetm.setDisplayName(Utils.chat(plugin.getConfig().getString("Nugget.three.displayname")));
            ArrayList<String> nuggetlore = new ArrayList<String>();
            for (String output : plugin.getConfig().getStringList("Nugget.three.lore")) {
                nuggetlore.add(Utils.chat(output));
            }
            nuggetm.setLore(nuggetlore);
            nugget.setItemMeta(nuggetm);
            t.getInventory().addItem(nugget);
            if (sender == t) {
                t.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.received").replaceAll("%amount%", "64").replaceAll("%type%", plugin.getConfig().getString("Nugget.three.name"))));
                return true;
            }
            sender.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.given").replaceAll("%target%", t.getName()).replaceAll("%amount%", "64").replaceAll("%type%", plugin.getConfig().getString("Nugget.three.name"))));
            t.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.received").replaceAll("%amount%", "64").replaceAll("%type%", plugin.getConfig().getString("Nugget.three.name"))));
        } else if (args.length == 3 && args[2].equalsIgnoreCase(plugin.getConfig().getString("Nugget.four.name"))) {
            Player t = Bukkit.getPlayerExact(args[1]);
            if (t == null) {
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("targetoffline").replaceAll("%target%", args[1])));
                return true;
            }
            ItemStack nugget = new ItemStack(Material.GOLD_NUGGET, 64);
            ItemMeta nuggetm = nugget.getItemMeta();
            nuggetm.setDisplayName(Utils.chat(plugin.getConfig().getString("Nugget.four.displayname")));
            ArrayList<String> nuggetlore = new ArrayList<String>();
            for (String output : plugin.getConfig().getStringList("Nugget.four.lore")) {
                nuggetlore.add(Utils.chat(output));
            }
            nuggetm.setLore(nuggetlore);
            nugget.setItemMeta(nuggetm);
            t.getInventory().addItem(nugget);
            if (sender == t) {
                t.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.received").replaceAll("%amount%", "64").replaceAll("%type%", plugin.getConfig().getString("Nugget.four.name"))));
                return true;
            }
            sender.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.given").replaceAll("%target%", t.getName()).replaceAll("%amount%", "64").replaceAll("%type%", plugin.getConfig().getString("Nugget.four.name"))));
            t.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.received").replaceAll("%amount%", "64").replaceAll("%type%", plugin.getConfig().getString("Nugget.four.name"))));
        } else if (args.length == 3 && args[2].equalsIgnoreCase(plugin.getConfig().getString("Nugget.five.name"))) {
            Player t = Bukkit.getPlayerExact(args[1]);
            if (t == null) {
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("targetoffline").replaceAll("%target%", args[1])));
                return true;
            }
            ItemStack nugget = new ItemStack(Material.GOLD_NUGGET, 64);
            ItemMeta nuggetm = nugget.getItemMeta();
            nuggetm.setDisplayName(Utils.chat(plugin.getConfig().getString("Nugget.five.displayname")));
            ArrayList<String> nuggetlore = new ArrayList<String>();
            for (String output : plugin.getConfig().getStringList("Nugget.five.lore")) {
                nuggetlore.add(Utils.chat(output));
            }
            nuggetm.setLore(nuggetlore);
            nugget.setItemMeta(nuggetm);
            t.getInventory().addItem(nugget);
            if (sender == t) {
                t.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.received").replaceAll("%amount%", "64").replaceAll("%type%", plugin.getConfig().getString("Nugget.five.name"))));
                return true;
            }
            sender.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.given").replaceAll("%target%", t.getName()).replaceAll("%amount%", "64").replaceAll("%type%", plugin.getConfig().getString("Nugget.five.name"))));
            t.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.received").replaceAll("%amount%", "64").replaceAll("%type%", plugin.getConfig().getString("Nugget.five.name"))));
        } else if (args.length == 4 && args[3].equalsIgnoreCase(plugin.getConfig().getString("Nugget.one.name"))) {
            try {
                Player t = Bukkit.getPlayerExact(args[1]);
                if (t == null) {
                    sender.sendMessage(Utils.chat(plugin.getConfig().getString("targetoffline").replaceAll("%target%", args[1])));
                    return true;
                }
                ItemStack nugget = new ItemStack(Material.GOLD_NUGGET, Integer.parseInt(args[2]));
                ItemMeta nuggetm = nugget.getItemMeta();
                nuggetm.setDisplayName(Utils.chat(plugin.getConfig().getString("Nugget.one.displayname")));
                ArrayList<String> nuggetlore = new ArrayList<String>();
                for (String output : plugin.getConfig().getStringList("Nugget.one.lore")) {
                    nuggetlore.add(Utils.chat(output));
                }
                nuggetm.setLore(nuggetlore);
                nugget.setItemMeta(nuggetm);
                t.getInventory().addItem(nugget);
                if (sender == t) {
                    t.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.received").replaceAll("%amount%", String.valueOf(Integer.parseInt(args[2]))).replaceAll("%type%", plugin.getConfig().getString("Nugget.one.name"))));
                    return true;
                }
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.given").replaceAll("%target%", t.getName()).replaceAll("%amount%", String.valueOf(Integer.parseInt(args[2]))).replaceAll("%type%", plugin.getConfig().getString("Nugget.one.name"))));
                t.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.received").replaceAll("%amount%", String.valueOf(Integer.parseInt(args[2]))).replaceAll("%type%", plugin.getConfig().getString("Nugget.one.name"))));
            } catch (NumberFormatException e) {
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("IllegalArguments")));
            }
        } else if (args.length == 4 && args[3].equalsIgnoreCase(plugin.getConfig().getString("Nugget.two.name"))) {
            try {
                Player t = Bukkit.getPlayerExact(args[1]);
                if (t == null) {
                    sender.sendMessage(Utils.chat(plugin.getConfig().getString("targetoffline").replaceAll("%target%", args[1])));
                    return true;
                }
                ItemStack nugget = new ItemStack(Material.GOLD_NUGGET, Integer.parseInt(args[2]));
                ItemMeta nuggetm = nugget.getItemMeta();
                nuggetm.setDisplayName(Utils.chat(plugin.getConfig().getString("Nugget.two.displayname")));
                ArrayList<String> nuggetlore = new ArrayList<String>();
                for (String output : plugin.getConfig().getStringList("Nugget.two.lore")) {
                    nuggetlore.add(Utils.chat(output));
                }
                nuggetm.setLore(nuggetlore);
                nugget.setItemMeta(nuggetm);
                t.getInventory().addItem(nugget);
                if (sender == t) {
                    t.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.received").replaceAll("%amount%", String.valueOf(Integer.parseInt(args[2]))).replaceAll("%type%", plugin.getConfig().getString("Nugget.two.name"))));
                    return true;
                }
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.given").replaceAll("%target%", t.getName()).replaceAll("%amount%", String.valueOf(Integer.parseInt(args[2]))).replaceAll("%type%", plugin.getConfig().getString("Nugget.two.name"))));
                t.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.received").replaceAll("%amount%", String.valueOf(Integer.parseInt(args[2]))).replaceAll("%type%", plugin.getConfig().getString("Nugget.two.name"))));
            } catch (NumberFormatException e) {
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("IllegalArguments")));
            }
        } else if (args.length == 4 && args[3].equalsIgnoreCase(plugin.getConfig().getString("Nugget.three.name"))) {
            try {
                Player t = Bukkit.getPlayerExact(args[1]);
                if (t == null) {
                    sender.sendMessage(Utils.chat(plugin.getConfig().getString("targetoffline").replaceAll("%target%", args[1])));
                    return true;
                }
                ItemStack nugget = new ItemStack(Material.GOLD_NUGGET, Integer.parseInt(args[2]));
                ItemMeta nuggetm = nugget.getItemMeta();
                nuggetm.setDisplayName(Utils.chat(plugin.getConfig().getString("Nugget.three.displayname")));
                ArrayList<String> nuggetlore = new ArrayList<String>();
                for (String output : plugin.getConfig().getStringList("Nugget.three.lore")) {
                    nuggetlore.add(Utils.chat(output));
                }
                nuggetm.setLore(nuggetlore);
                nugget.setItemMeta(nuggetm);
                t.getInventory().addItem(nugget);
                if (sender == t) {
                    t.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.received").replaceAll("%amount%", String.valueOf(Integer.parseInt(args[2]))).replaceAll("%type%", plugin.getConfig().getString("Nugget.three.name"))));
                    return true;
                }
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.given").replaceAll("%target%", t.getName()).replaceAll("%amount%", String.valueOf(Integer.parseInt(args[2]))).replaceAll("%type%", plugin.getConfig().getString("Nugget.three.name"))));
                t.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.received").replaceAll("%amount%", String.valueOf(Integer.parseInt(args[2]))).replaceAll("%type%", plugin.getConfig().getString("Nugget.three.name"))));
            } catch (NumberFormatException e) {
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("IllegalArguments")));
            }
        } else if (args.length == 4 && args[3].equalsIgnoreCase(plugin.getConfig().getString("Nugget.four.name"))) {
            try {
                Player t = Bukkit.getPlayerExact(args[1]);
                if (t == null) {
                    sender.sendMessage(Utils.chat(plugin.getConfig().getString("targetoffline").replaceAll("%target%", args[1])));
                    return true;
                }
                ItemStack nugget = new ItemStack(Material.GOLD_NUGGET, Integer.parseInt(args[2]));
                ItemMeta nuggetm = nugget.getItemMeta();
                nuggetm.setDisplayName(Utils.chat(plugin.getConfig().getString("Nugget.four.displayname")));
                ArrayList<String> nuggetlore = new ArrayList<String>();
                for (String output : plugin.getConfig().getStringList("Nugget.four.lore")) {
                    nuggetlore.add(Utils.chat(output));
                }
                nuggetm.setLore(nuggetlore);
                nugget.setItemMeta(nuggetm);
                t.getInventory().addItem(nugget);
                if (sender == t) {
                    t.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.received").replaceAll("%amount%", String.valueOf(Integer.parseInt(args[2]))).replaceAll("%type%", plugin.getConfig().getString("Nugget.four.name"))));
                    return true;
                }
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.given").replaceAll("%target%", t.getName()).replaceAll("%amount%", String.valueOf(Integer.parseInt(args[2]))).replaceAll("%type%", plugin.getConfig().getString("Nugget.four.name"))));
                t.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.received").replaceAll("%amount%", String.valueOf(Integer.parseInt(args[2]))).replaceAll("%type%", plugin.getConfig().getString("Nugget.four.name"))));
            } catch (NumberFormatException e) {
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("IllegalArguments")));
            }
        } else if (args.length == 4 && args[3].equalsIgnoreCase(plugin.getConfig().getString("Nugget.five.name"))) {
            try {
                Player t = Bukkit.getPlayerExact(args[1]);
                if (t == null) {
                    sender.sendMessage(Utils.chat(plugin.getConfig().getString("targetoffline").replaceAll("%target%", args[1])));
                    return true;
                }
                ItemStack nugget = new ItemStack(Material.GOLD_NUGGET, Integer.parseInt(args[2]));
                ItemMeta nuggetm = nugget.getItemMeta();
                nuggetm.setDisplayName(Utils.chat(plugin.getConfig().getString("Nugget.five.displayname")));
                ArrayList<String> nuggetlore = new ArrayList<String>();
                for (String output : plugin.getConfig().getStringList("Nugget.five.lore")) {
                    nuggetlore.add(Utils.chat(output));
                }
                nuggetm.setLore(nuggetlore);
                nugget.setItemMeta(nuggetm);
                t.getInventory().addItem(nugget);
                if (sender == t) {
                    t.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.received").replaceAll("%amount%", String.valueOf(Integer.parseInt(args[2]))).replaceAll("%type%", plugin.getConfig().getString("Nugget.five.name"))));
                    return true;
                }
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.given").replaceAll("%target%", t.getName()).replaceAll("%amount%", String.valueOf(Integer.parseInt(args[2]))).replaceAll("%type%", plugin.getConfig().getString("Nugget.five.name"))));
                t.sendMessage(Utils.chat(plugin.getConfig().getString("Nugget.messages.received").replaceAll("%amount%", String.valueOf(Integer.parseInt(args[2]))).replaceAll("%type%", plugin.getConfig().getString("Nugget.five.name"))));
            } catch (NumberFormatException e) {
                sender.sendMessage(Utils.chat(plugin.getConfig().getString("IllegalArguments")));
            }
        } else {
            sender.sendMessage(Utils.chat(plugin.getConfig().getString("IllegalArguments")));
        }

        return false;
    }
}


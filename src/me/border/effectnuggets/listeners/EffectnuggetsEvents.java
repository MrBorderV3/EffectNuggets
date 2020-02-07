package me.border.effectnuggets.listeners;

import me.border.effectnuggets.Main;
import me.border.effectnuggets.utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EffectnuggetsEvents implements Listener {

    private Main plugin;

    public EffectnuggetsEvents(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (p.getItemInHand().getType() == Material.GOLD_NUGGET && p.getItemInHand().getItemMeta().hasLore() && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat(plugin.getConfig().getString("Nugget.one.displayname")))) {
                int amount = p.getItemInHand().getAmount();
                if (p.getItemInHand().getAmount() == 0 || p.getItemInHand().getAmount() == 1){
                    ItemStack nugget = p.getItemInHand();
                    p.getInventory().removeItem(nugget);
                } else {
                    p.getItemInHand().setAmount(amount - 1);
                }
                if (plugin.getConfig().getBoolean("Nugget.one.effects.removecurrentpots")) {
                    p.removePotionEffect(PotionEffectType.getByName(plugin.getConfig().getString("Nugget.one.effects.firsteffect.effect")));
                    if (plugin.getConfig().getBoolean("Nugget.one.effects.secondeffect.enabled")) {
                        p.removePotionEffect(PotionEffectType.getByName(plugin.getConfig().getString("Nugget.one.effects.secondeffect.effect")));
                    }
                }
                p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(plugin.getConfig().getString("Nugget.one.effects.firsteffect.effect")), plugin.getConfig().getInt("Nugget.one.effects.firsteffect.duration") * 20, plugin.getConfig().getInt("Nugget.one.effects.firsteffect.level") - 1));
                if (plugin.getConfig().getBoolean("Nugget.one.effects.secondeffect.enabled")) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(plugin.getConfig().getString("Nugget.one.effects.secondeffect.effect")), plugin.getConfig().getInt("Nugget.one.effects.secondeffect.duration") * 20, plugin.getConfig().getInt("Nugget.one.effects.secondeffect.level") - 1));
                }
            } else if (p.getItemInHand().getType() == Material.GOLD_NUGGET && p.getItemInHand().getItemMeta().hasLore() && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat(plugin.getConfig().getString("Nugget.two.displayname")))) {
                int amount = p.getItemInHand().getAmount();
                if (p.getItemInHand().getAmount() == 0 || p.getItemInHand().getAmount() == 1){
                    ItemStack nugget = p.getItemInHand();
                    p.getInventory().removeItem(nugget);
                } else {
                    p.getItemInHand().setAmount(amount - 1);
                }
                if (plugin.getConfig().getBoolean("Nugget.two.effects.removecurrentpots")) {
                    p.removePotionEffect(PotionEffectType.getByName(plugin.getConfig().getString("Nugget.two.effects.firsteffect.effect")));
                    if (plugin.getConfig().getBoolean("Nugget.two.effects.secondeffect.enabled")) {
                        p.removePotionEffect(PotionEffectType.getByName(plugin.getConfig().getString("Nugget.two.effects.secondeffect.effect")));
                    }
                }
                p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(plugin.getConfig().getString("Nugget.two.effects.firsteffect.effect")), plugin.getConfig().getInt("Nugget.two.effects.firsteffect.duration") * 20, plugin.getConfig().getInt("Nugget.two.effects.firsteffect.level") - 1));
                if (plugin.getConfig().getBoolean("Nugget.two.effects.secondeffect.enabled")) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(plugin.getConfig().getString("Nugget.two.effects.secondeffect.effect")), plugin.getConfig().getInt("Nugget.two.effects.secondeffect.duration") * 20, plugin.getConfig().getInt("Nugget.two.effects.secondeffect.level") - 1));
                }
            } else if (p.getItemInHand().getType() == Material.GOLD_NUGGET && p.getItemInHand().getItemMeta().hasLore() && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat(plugin.getConfig().getString("Nugget.three.displayname")))) {
                int amount = p.getItemInHand().getAmount();
                if (p.getItemInHand().getAmount() == 0 || p.getItemInHand().getAmount() == 1){
                    ItemStack nugget = p.getItemInHand();
                    p.getInventory().removeItem(nugget);
                } else {
                    p.getItemInHand().setAmount(amount - 1);
                }
                if (plugin.getConfig().getBoolean("Nugget.three.effects.removecurrentpots")) {
                    p.removePotionEffect(PotionEffectType.getByName(plugin.getConfig().getString("Nugget.three.effects.secondeffect.effect")));
                    if (plugin.getConfig().getBoolean("Nugget.three.effects.secondeffect.enabled")) {
                        p.removePotionEffect(PotionEffectType.getByName(plugin.getConfig().getString("Nugget.three.effects.secondeffect.effect")));
                    }
                }
                p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(plugin.getConfig().getString("Nugget.three.effects.firsteffect.effect")), plugin.getConfig().getInt("Nugget.three.effects.firsteffect.duration") * 20, plugin.getConfig().getInt("Nugget.three.effects.firsteffect.level") - 1));
                if (plugin.getConfig().getBoolean("Nugget.three.effects.secondeffect.enabled")) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(plugin.getConfig().getString("Nugget.three.effects.secondeffect.effect")), plugin.getConfig().getInt("Nugget.three.effects.secondeffect.duration") * 20, plugin.getConfig().getInt("Nugget.three.effects.secondeffect.level") - 1));
                }
            } else if (p.getItemInHand().getType() == Material.GOLD_NUGGET && p.getItemInHand().getItemMeta().hasLore() && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat(plugin.getConfig().getString("Nugget.four.displayname")))) {
                int amount = p.getItemInHand().getAmount();
                if (p.getItemInHand().getAmount() == 0 || p.getItemInHand().getAmount() == 1){
                    ItemStack nugget = p.getItemInHand();
                    p.getInventory().removeItem(nugget);
                } else {
                    p.getItemInHand().setAmount(amount - 1);
                }
                if (plugin.getConfig().getBoolean("Nugget.four.effects.removecurrentpots")) {
                    p.removePotionEffect(PotionEffectType.getByName(plugin.getConfig().getString("Nugget.four.effects.secondeffect.effect")));
                    if (plugin.getConfig().getBoolean("Nugget.four.effects.secondeffect.enabled")) {
                        p.removePotionEffect(PotionEffectType.getByName(plugin.getConfig().getString("Nugget.four.effects.secondeffect.effect")));
                    }
                }
                p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(plugin.getConfig().getString("Nugget.four.effects.firsteffect.effect")), plugin.getConfig().getInt("Nugget.four.effects.firsteffect.duration") * 20, plugin.getConfig().getInt("Nugget.four.effects.firsteffect.level") - 1));
                if (plugin.getConfig().getBoolean("Nugget.four.effects.secondeffect.enabled")) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(plugin.getConfig().getString("Nugget.four.effects.secondeffect.effect")), plugin.getConfig().getInt("Nugget.four.effects.secondeffect.duration") * 20, plugin.getConfig().getInt("Nugget.four.effects.secondeffect.level") - 1));
                }
            } else if (p.getItemInHand().getType() == Material.GOLD_NUGGET && p.getItemInHand().getItemMeta().hasLore() && p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat(plugin.getConfig().getString("Nugget.five.displayname")))) {
                int amount = p.getItemInHand().getAmount();
                if (p.getItemInHand().getAmount() == 0 || p.getItemInHand().getAmount() == 1){
                    ItemStack nugget = p.getItemInHand();
                    p.getInventory().removeItem(nugget);
                } else {
                    p.getItemInHand().setAmount(amount - 1);
                }
                if (plugin.getConfig().getBoolean("Nugget.five.effects.removecurrentpots")) {
                    p.removePotionEffect(PotionEffectType.getByName(plugin.getConfig().getString("Nugget.five.effects.secondeffect.effect")));
                    if (plugin.getConfig().getBoolean("Nugget.five.effects.secondeffect.enabled")) {
                        p.removePotionEffect(PotionEffectType.getByName(plugin.getConfig().getString("Nugget.five.effects.secondeffect.effect")));
                    }
                }
                p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(plugin.getConfig().getString("Nugget.five.effects.firsteffect.effect")), plugin.getConfig().getInt("Nugget.five.effects.firsteffect.duration") * 20, plugin.getConfig().getInt("Nugget.five.effects.firsteffect.level") - 1));
                if (plugin.getConfig().getBoolean("Nugget.five.effects.secondeffect.enabled")) {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.getByName(plugin.getConfig().getString("Nugget.five.effects.secondeffect.effect")), plugin.getConfig().getInt("Nugget.five.effects.secondeffect.duration") * 20, plugin.getConfig().getInt("Nugget.five.effects.secondeffect.level") - 1));
                }
            } else {
                return;
            }
        } else {
            return;
        }
    }
}

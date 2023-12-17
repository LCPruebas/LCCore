package lc.core.Utils;

import lc.core.NMS.Materials;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.List;

public class ItemUtils extends ItemStack
{
    public ItemUtils(ItemStack itemStack) {
        setType(itemStack.getType());
        setAmount(itemStack.getAmount());
        setDurability(itemStack.getDurability());
        setItemMeta(itemStack.getItemMeta());
    }


    public ItemUtils(Material material, Short damageid, Integer amount, String displayName, List<String> lores) {
        setType(material);
        setAmount(amount.intValue());
        setDurability(damageid.shortValue());
        ItemMeta im = getItemMeta();
        im.setDisplayName(displayName);
        im.setLore(lores);
        setItemMeta(im);
    }




    public ItemUtils(Material material, Short damageid, Integer amount, String displayName, String loresSplit) {
        setType(material);
        setAmount(amount.intValue());
        setDurability(damageid.shortValue());
        ItemMeta im = getItemMeta();
        im.setDisplayName(displayName);
        List<String> lr = Arrays.asList(loresSplit.split("=="));
        for(int x=0;x<lr.size(); x++){
            lr.add(ChatColor.translateAlternateColorCodes('&', lr.get(x)));
        }
        im.setLore(lr);
        setItemMeta(im);
    }




    public ItemUtils(String skull_item_Owner, Integer amount, String displayName, String loresSplit) {
        setType(Materials.PLAYER_HEAD.getMaterial());
        setAmount(amount.intValue());
        setDurability((short)3);
        SkullMeta im = (SkullMeta)getItemMeta();
        im.setDisplayName(displayName);
        List<String> lr = Arrays.asList(loresSplit.split("=="));
        for(int x=0;x<lr.size(); x++){
            lr.add(ChatColor.translateAlternateColorCodes('&', lr.get(x)));
        }
        im.setLore(lr);
        im.setOwner(skull_item_Owner);
        setItemMeta(im);
    }




    public ItemUtils(String skull_item_Owner, Integer amount) {
        setType(Materials.PLAYER_HEAD.getMaterial());
        setAmount(amount.intValue());
        setDurability((short)3);
        SkullMeta im = (SkullMeta)getItemMeta();
        im.setOwner(skull_item_Owner);
        setItemMeta(im);
    }




    public ItemUtils(Material material, Short damageid) {
        setType(material);
        setDurability(damageid.shortValue());
        setAmount(1);
    }




    public ItemUtils(Material material, Integer amount) {
        setType(material);
        setAmount(amount.intValue());
    }




    public ItemUtils(Material material, String displayName) {
        setType(material);
        setAmount(1);
        ItemMeta im = getItemMeta();
        im.setDisplayName(displayName);
        setItemMeta(im);
    }




    public ItemUtils(Material material, List<String> lores) {
        setType(material);
        setAmount(1);
        ItemMeta im = getItemMeta();
        im.setLore(lores);
        setItemMeta(im);
    }




    public ItemUtils(Material material, Short damageid, Integer amount) {
        setType(material);
        setAmount(amount.intValue());
        setDurability(damageid.shortValue());
    }




    public ItemUtils(Material material, Short damageid, Integer amount, String displayName) {
        setType(material);
        setAmount(amount.intValue());
        setDurability(damageid.shortValue());
        ItemMeta im = getItemMeta();
        im.setDisplayName(displayName);
        setItemMeta(im);
    }




    public ItemUtils(Material material, Short damageid, Integer amount, List<String> lores) {
        setType(material);
        setAmount(amount.intValue());
        setDurability(damageid.shortValue());
        ItemMeta im = getItemMeta();
        im.setLore(lores);
        setItemMeta(im);
    }




    public ItemUtils(Material material, Short damageid, String displayName) {
        setType(material);
        setAmount(1);
        setDurability(damageid.shortValue());
        ItemMeta im = getItemMeta();
        im.setDisplayName(displayName);
        setItemMeta(im);
    }




    public ItemUtils(Material material, Short damageid, String displayName, List<String> lores) {
        setType(material);
        setAmount(1);
        setDurability(damageid.shortValue());
        ItemMeta im = getItemMeta();
        im.setDisplayName(displayName);
        im.setLore(lores);
        setItemMeta(im);
    }




    public ItemUtils(Material material, Short damageid, List<String> lores) {
        setType(material);
        setAmount(1);
        setDurability(damageid.shortValue());
        ItemMeta im = getItemMeta();
        im.setLore(lores);
        setItemMeta(im);
    }




    public ItemUtils(Material material, Integer amount, String displayName) {
        setType(material);
        setAmount(amount.intValue());
        ItemMeta im = getItemMeta();
        im.setDisplayName(displayName);
        setItemMeta(im);
    }




    public ItemUtils(Material material, Integer amount, String displayName, List<String> lores) {
        setType(material);
        setAmount(amount.intValue());
        ItemMeta im = getItemMeta();
        im.setDisplayName(displayName);
        im.setLore(lores);
        setItemMeta(im);
    }




    public ItemUtils(Material material, Integer amount, List<String> lores) {
        setType(material);
        setAmount(amount.intValue());
        ItemMeta im = getItemMeta();
        im.setLore(lores);
        setItemMeta(im);
    }




    public ItemUtils(Material material, String displayName, List<String> lores) {
        setType(material);
        setAmount(1);
        ItemMeta im = getItemMeta();
        im.setDisplayName(displayName);
        im.setLore(lores);
        setItemMeta(im);
    }



    public ItemUtils getCustomItem(ItemStack itemStack) {
        setType(itemStack.getType());
        setAmount(itemStack.getAmount());
        setDurability(itemStack.getDurability());
        setItemMeta(itemStack.getItemMeta());
        return this;
    }

    public boolean isSameLike(ItemUtils customItem) {
        if (!customItem.getType().equals(getType())) {
            return false;
        }
        if (getItemMeta().hasDisplayName()) {
            if (!customItem.getItemMeta().hasDisplayName()) {
                return false;
            }
            if (!getItemMeta().getDisplayName().equals(customItem.getItemMeta().getDisplayName())) {
                return false;
            }
        }

        if (getItemMeta().hasLore() &&
                !customItem.getItemMeta().hasLore()) {
            return false;
        }

        if (!getItemMeta().getEnchants().equals(customItem.getItemMeta().getEnchants())) {
            return false;
        }
        if (getDurability() != customItem.getDurability()) {
            return false;
        }
        return true;
    }

    public boolean isSameItemStackLike(ItemStack itemStack) {
        if (!itemStack.getType().equals(getType())) {
            return false;
        }
        if (getItemMeta().hasDisplayName()) {
            if (!itemStack.getItemMeta().hasDisplayName()) {
                return false;
            }
            if (!getItemMeta().getDisplayName().equals(itemStack.getItemMeta().getDisplayName())) {
                return false;
            }
        }

        if (getItemMeta().hasLore() &&
                !itemStack.getItemMeta().hasLore()) {
            return false;
        }

        if (!getItemMeta().getEnchants().equals(itemStack.getItemMeta().getEnchants())) {
            return false;
        }
        if (getDurability() != itemStack.getDurability()) {
            return false;
        }
        return true;
    }



    public void add(Player player) { player.getInventory().addItem(new ItemStack[] { this }); }




    public void add(Inventory inventory) { inventory.addItem(new ItemStack[] { this }); }




    public void set(Player player, Integer slot) { player.getInventory().setItem(slot.intValue(), this); }




    public void set(Inventory inventory, Integer slot) { inventory.setItem(slot.intValue(), this); }




    public void setHelmet(Player p) { p.getInventory().setHelmet(this); }




    public void setChestplate(Player p) { p.getInventory().setChestplate(this); }




    public void setLeggings(Player p) { p.getInventory().setLeggings(this); }




    public void setBoots(Player p) { p.getInventory().setBoots(this); }




    public void setInHand(Player p) { p.getInventory().setItemInHand(this); }




    public void dropItem(Location loc) { loc.getWorld().dropItem(loc, this); }




    public void dropItemNaturally(Location loc) { loc.getWorld().dropItemNaturally(loc, this); }
}

package lc.core.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import java.util.Arrays;

public class IconMenu  implements Listener
{
    private String name;
    private int size;
    private OptionClickEventHandler handler;
    private Plugin plugin;
    private Inventory inv = null;

    private String[] optionNames;
    private ItemStack[] optionIcons;
    private boolean destroy = false;

    public IconMenu(String name, int size, OptionClickEventHandler handler, Plugin plugin) {
        this.name = name;
        this.size = size;
        this.handler = handler;
        this.plugin = plugin;
        this.optionNames = new String[size];
        this.optionIcons = new ItemStack[size];
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.inv = Bukkit.createInventory(null, size, name);
    }

    public IconMenu(String name, int size, OptionClickEventHandler handler, Plugin plugin, boolean destroy) {
        this.name = name;
        this.size = size;
        this.handler = handler;
        this.plugin = plugin;
        this.optionNames = new String[size];
        this.optionIcons = new ItemStack[size];
        this.destroy = destroy;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.inv = Bukkit.createInventory(null, size, name);
    }

    public IconMenu setOption(int position, ItemStack icon, String name, String... info) {
        this.optionNames[position] = name;
        this.optionIcons[position] = setItemNameAndLore(icon, name, info);
        this.inv.setItem(position, icon);
        return this;
    }

    public IconMenu setOption(int position, ItemStack icon) {
        this.optionNames[position] = icon.getItemMeta().getDisplayName();
        this.optionIcons[position] = icon;
        this.inv.setItem(position, icon);
        return this;
    }


    public void open(Player player) { player.openInventory(this.inv); }


    public void destroy() {
        HandlerList.unregisterAll(this);
        this.handler = null;
        this.plugin = null;
        this.optionNames = null;
        this.optionIcons = null;
        this.inv = null;
    }

    public void clear() {
        this.optionNames = new String[this.size];
        this.optionIcons = new ItemStack[this.size];
        this.inv.clear();
    }

    @EventHandler(priority = EventPriority.LOWEST)
    void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().equals(this.inv)) {
            event.setCancelled(true);
            int slot = event.getRawSlot();
            if (slot >= 0 && slot < this.size && this.optionNames[slot] != null) {
                OptionClickEvent e = new OptionClickEvent((Player)event.getWhoClicked(), slot, this.optionNames[slot], this);
                this.handler.onOptionClick(e);
                if (e.willClose()) {
                    Player p = (Player)event.getWhoClicked();
                    p.closeInventory();
                }
                if (e.willDestroy()) {
                    destroy();
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    void onInventoryClick(InventoryCloseEvent event) {
        if (event.getInventory().equals(this.inv) &&
                this.destroy) {
            destroy();
        }
    }


    @EventHandler(priority = EventPriority.LOWEST)
    void onInventoryClick(PlayerQuitEvent event) { event.getPlayer().closeInventory(); }



    public boolean isDestroy() { return this.destroy; }



    public void setDestroy(boolean destroy) { this.destroy = destroy; }


    public class OptionClickEvent
    {
        private Player player;

        private int position;

        private String name;

        private boolean close;
        private boolean destroy;
        private IconMenu iconmenu;

        public OptionClickEvent(Player player, int position, String name, IconMenu iconmenu) {
            this.player = player;
            this.position = position;
            this.name = name;
            this.close = true;
            this.destroy = false;
            this.iconmenu = iconmenu;
        }


        public Player getPlayer() { return this.player; }



        public int getPosition() { return this.position; }



        public String getName() { return this.name; }



        public boolean willClose() { return this.close; }



        public boolean willDestroy() { return this.destroy; }



        public void setWillClose(boolean close) { this.close = close; }



        public void setWillDestroy(boolean destroy) { this.destroy = destroy; }



        public IconMenu getIconmenu() { return this.iconmenu; }



        public void setIconmenu(IconMenu iconmenu) { this.iconmenu = iconmenu; }
    }


    private ItemStack setItemNameAndLore(ItemStack item, String name, String[] lore) {
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(name);
        im.setLore(Arrays.asList(lore));
        item.setItemMeta(im);

        return item;
    }

    public static interface OptionClickEventHandler {
        void onOptionClick(OptionClickEvent param1OptionClickEvent);
    }
}

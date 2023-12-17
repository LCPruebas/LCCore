package lc.core.NMS;

import org.bukkit.Bukkit;
import org.bukkit.Material;

public enum Materials {
    PLAYER_HEAD("SKULL_ITEM", "LEGACY_SKULL_ITEM");
    private String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3].replace("v", "").replace("R", "").replace("_", ".");
    private String v8;
    private String v13;
    Materials(String skull_item, String player_head) {
        this.v8 = skull_item;
        this.v13 = player_head;
    }

    public Material getMaterial(){
        if(version.contains("1.8") || version.contains("1.7") || version.contains("1.9") || version.contains("1.10")
          || version.contains("1.11")|| version.contains("1.12")){
            return Material.getMaterial(v8);
        } else {
            return Material.getMaterial(v13);
        }
    }
}

package lc.core.Utils;
import org.bukkit.World;
import org.bukkit.entity.Player;

public interface NMS {

     void sendParticles(World world, String type, float x, float y, float z, float offsetX, float offsetY, float offsetZ, float data, int amount);
     void sendTitle(Player player, int fadein, int stay, int fadeout, String title, String subtitle);


}

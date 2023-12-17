package lc.core.Utils;

public class ParticleItem
{
    private int cost;
    private String effect;
    private String name;

    public ParticleItem(String effect, String name, int cost) {
        this.cost = cost;
        this.effect = effect;
        this.name = name;
    }


    public int getCost() { return this.cost; }



    public String getEffect() { return this.effect; }



    public String getName() { return this.name; }
}

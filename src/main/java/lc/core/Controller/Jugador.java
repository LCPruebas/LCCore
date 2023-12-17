package lc.core.Controller;

import com.google.common.collect.Lists;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class Jugador {

    private static HashMap<String, Jugador> Jugadores = new HashMap();
    private String name;
    private Player player;
    private boolean onlineMode = false;
    private boolean onlineModeVerify = false;
    private String skin;
    private boolean saveSQL = false;
    private int lcoins = 0;
    private Ranks rank = Ranks.DEFAULT;
    private long rankduration = 0L;
    private int rankpoints = 0;
    private ChatColor NameTagColor = ChatColor.YELLOW;
    private boolean hiderank = false;
    private boolean Opciones_SVS_Enable_Players = false;
    private boolean Opciones_SVS_Enable_Chat = true;
    private boolean Opciones_SVS_Enable_Stacker = true;
    private boolean Opciones_SVS_Enable_MiniLobby = true;
    private String HG_Kit = "default";
    private int HG_Stats_Partidas_ganadas = 0;
    private int HG_Stats_Partidas_jugadas = 0;
    private int HG_Stats_topkillstreak = 0;
    private int HG_Stats_deaths = 0;
    private int HG_Stats_kills = 0;
    private String HG_Trail_Effect = "normal";
    private String HG_Place_Color = "normal";

    private String CHG_Kit = "default";
    private boolean CHG_Winner = false;
    private int CHG_Stats_Partidas_ganadas = 0;
    private int CHG_Stats_Partidas_jugadas = 0;
    private int CHG_Stats_topkillstreak = 0;
    private int CHG_Stats_deaths = 0;
    private int CHG_Stats_kills = 0;
    private String CHG_Trail_Effect = "normal";
    private String CHG_Place_Color = "normal";
    private ArrayList<String> HG_OWN_KITS;
    private ArrayList<String> CHG_OWN_KITS;
    private String KitPVP_Kit = "default";
    private int KitPVP_Stats_topkillstreak = 0;
    private int KitPVP_Stats_deaths = 0;
    private int KitPVP_Stats_kills = 0;
    private int POTPVP_Stats_Partidas_ganadas = 0;
    private int POTPVP_Stats_Partidas_jugadas = 0;
    private int POTPVP_Stats_topkillstreak = 0;
    private int POTPVP_Stats_deaths = 0;
    private int POTPVP_Stats_kills = 0;
    private String POTPVP_Kit = "default";
    private String SKYW_Kit = "default";
    private ArrayList<String> SKYW_OWN_KITS;
    private String SKYW_Trail_Effect = "normal";
    private String SKYW_Glass_Color = "normal";
    private int SKYW_Stats_Partidas_ganadas = 0;
    private int SKYW_Stats_Partidas_jugadas = 0;
    private int SKYW_Stats_topkillstreak = 0;
    private int SKYW_Stats_deaths = 0;
    private int SKYW_Stats_kills = 0;
    private String BEDW_Kit = "default";
    private ArrayList<String> BEDW_OWN_KITS;
    private String BEDW_Trail_Effect = "normal";
    private String BEDW_Glass_Color = "normal";
    private int BEDW_Stats_Partidas_ganadas = 0;
    private int BEDW_Stats_Partidas_jugadas = 0;
    private int BEDW_Stats_topkillstreak = 0;
    private int BEDW_Stats_deaths = 0;
    private int BEDW_Stats_kills = 0;
    private String PVPG_Kit = "default";
    private int PVPG_Stats_Partidas_ganadas = 0;
    private int PVPG_Stats_Partidas_jugadas = 0;
    private int PVPG_Stats_topkillstreak = 0;
    private int PVPG_Stats_deaths = 0;
    private int PVPG_Stats_kills = 0;
    private int PVPG_Stats_cores_leakeds = 0;
    private int PVPG_Stats_wools_placed = 0;
    private int PVPG_Stats_monuments_destroyed = 0;

    private boolean PlayerAuth_loaded = false;
    private boolean PlayerAuth_logged = false;
    private boolean PlayerAuth_registred = false;
    private String PlayerAuth_password = "";
    private String PlayerAuth_last_ip = "";
    private String Rank_CHG = "";
    private long PlayerAuth_lastlogin = 0L;
    private boolean bypass;
    private String value;

    public static Jugador getJugador(String pl) {
        if (Jugadores.containsKey(pl.toLowerCase())) {
            return (Jugador)Jugadores.get(pl.toLowerCase());
        }
        return new Jugador(pl);
    }

    public static Jugador getJugador(Player pl) {
        if (Jugadores.containsKey(pl.getName().toLowerCase())) {
            return (Jugador)Jugadores.get(pl.getName().toLowerCase());
        }
        return new Jugador(pl);
    }

    public static void removeJugador(String pl) {
        if (Jugadores.containsKey(pl.toLowerCase()))
            Jugadores.remove(pl.toLowerCase());
    }

    public Jugador(String s) {
        this.player = null;
        this.name = s.toLowerCase();

        Jugadores.put(s.toLowerCase(), this);
    }

    public Jugador(Player p) {
        this.player = p;
        this.name = p.getName().toLowerCase();
        Jugadores.put(p.getName().toLowerCase(), this);
    }


    public String getPlayerName() { return this.name; }



    public Player getBukkitPlayer() { return this.player; }



    public void setBukkitPlayer(Player bplayer) { this.player = bplayer; }




    public boolean isOnlineMode() { return this.onlineMode; }



    public void setOnlineMode(boolean onlineMode) { this.onlineMode = onlineMode; }



    public String getSkin() { return this.skin; }



    public void setSkin(String skin) { this.skin = skin; }



    public int getLcoins() { return this.lcoins; }



    public void addLcoins(int lcoins) { this.lcoins += lcoins; }



    public void removeLcoins(int lcoins) { this.lcoins -= lcoins; }



    public boolean hascoins(int lcoins) { return (this.lcoins >= lcoins); }



    public void setLcoins(int lcoins) { this.lcoins = lcoins; }



    public Ranks getRank() { return this.rank; }



    public boolean is_Premium() { return (this.rank == Ranks.PREMIUM); }




    public boolean is_RUBY() { return !(this.rank != Ranks.RUBY && this.rank != Ranks.MOD && this.rank != Ranks.AYUDANTE && this.rank != Ranks.ADMIN && this.rank != Ranks.OWNER); }



    public boolean is_VIP() { return !(this.rank != Ranks.VIP && this.rank != Ranks.SVIP && this.rank != Ranks.RUBY && this.rank != Ranks.ELITE && this.rank != Ranks.YOUTUBER && this.rank != Ranks.MOD && this.rank != Ranks.AYUDANTE && this.rank != Ranks.BUILDER && this.rank != Ranks.ADMIN && this.rank != Ranks.OWNER); }



    public boolean is_SVIP() { return !(this.rank != Ranks.SVIP && this.rank != Ranks.ELITE && this.rank != Ranks.RUBY && this.rank != Ranks.YOUTUBER && this.rank != Ranks.MOD && this.rank != Ranks.AYUDANTE && this.rank != Ranks.BUILDER && this.rank != Ranks.ADMIN && this.rank != Ranks.OWNER); }



    public boolean is_ELITE() { return !(this.rank != Ranks.ELITE && this.rank != Ranks.RUBY && this.rank != Ranks.YOUTUBER && this.rank != Ranks.MOD && this.rank != Ranks.AYUDANTE && this.rank != Ranks.BUILDER && this.rank != Ranks.ADMIN && this.rank != Ranks.OWNER); }



    public boolean is_YOUTUBER() { return !(this.rank != Ranks.YOUTUBER && this.rank != Ranks.MOD && this.rank != Ranks.AYUDANTE && this.rank != Ranks.ADMIN && this.rank != Ranks.OWNER); }



    public boolean is_AYUDANTE() { return !(this.rank != Ranks.AYUDANTE && this.rank != Ranks.MOD && this.rank != Ranks.ADMIN && this.rank != Ranks.OWNER); }



    public boolean is_DEFAULT() { return (this.rank == Ranks.DEFAULT); }



    public boolean is_MODERADOR() { return !(this.rank != Ranks.MOD && this.rank != Ranks.ADMIN && this.rank != Ranks.OWNER); }



    public boolean is_Admin() { return !(this.rank != Ranks.ADMIN && this.rank != Ranks.OWNER); }



    public boolean is_Owner() { return (this.rank == Ranks.OWNER); }



    public boolean is_BUILDER() { return (this.rank == Ranks.BUILDER); }



    public boolean is_VETERANO() { return (this.rank == Ranks.VETERANO); }



    public void setRank(Ranks rango) { this.rank = rango; }



    public long getRankduration() { return this.rankduration; }



    public boolean isHideRank() { return this.hiderank; }



    public void setHideRank(boolean bol) { this.hiderank = bol; }


    public void checkRankduration() {
        if (is_DEFAULT() || is_Admin() || is_Owner() || is_AYUDANTE() || is_YOUTUBER() || is_MODERADOR()) {
            return;
        }
        if (System.currentTimeMillis() >= this.rankduration) {
            this.rankduration = 0L;
            if (isOnlineMode()) {
                setRank(Ranks.PREMIUM);
                Database.savePlayerRank(this);
            } else if (is_Premium() && !isOnlineMode()) {
                setRank(Ranks.PREMIUM);
                Database.savePlayerRank(this);
            } else {
                setRank(Ranks.DEFAULT);
                if (this.rankpoints > 0) {
                    Database.savePlayerRank(this);
                } else {
                    Database.deletePlayerRango(this);
                }
            }
        }
    }


    public void addRankduration(long rankduration) { this.rankduration += rankduration; }



    public void removeRankduration(long rankduration) { this.rankduration -= rankduration; }


    public void setRankduration(long rankduration) {
        if (rankduration <= 0L) {
            this.rankduration = 0L;
        } else {
            this.rankduration = System.currentTimeMillis() + rankduration;
        }
    }

    public void setRankdurationSQL(long rankduration) { this.rankduration = rankduration; }



    public int getRankpoints() { return this.rankpoints; }



    public void addRankpoints(int rankpoints) { this.rankpoints += rankpoints; }



    public void removeRankpoints(int rankpoints) { this.rankpoints -= rankpoints; }



    public void setRankpoints(int rankpoints) { this.rankpoints = rankpoints; }



    public String getHG_Kit() { return this.HG_Kit; }



    public void setHG_Kit(String hG_Kit) { this.HG_Kit = hG_Kit; }



    public int getHG_Stats_Partidas_ganadas() { return this.HG_Stats_Partidas_ganadas; }



    public void addHG_Stats_Partidas_ganadas(int hG_Stats_Partidas_ganadas) { this.HG_Stats_Partidas_ganadas += hG_Stats_Partidas_ganadas; }



    public void setHG_Stats_Partidas_ganadas(int hG_Stats_Partidas_ganadas) { this.HG_Stats_Partidas_ganadas = hG_Stats_Partidas_ganadas; }



    public int getHG_Stats_Partidas_jugadas() { return this.HG_Stats_Partidas_jugadas; }



    public void addHG_Stats_Partidas_jugadas(int hG_Stats_Partidas_jugadas) { this.HG_Stats_Partidas_jugadas += hG_Stats_Partidas_jugadas; }



    public void setHG_Stats_Partidas_jugadas(int hG_Stats_Partidas_jugadas) { this.HG_Stats_Partidas_jugadas = hG_Stats_Partidas_jugadas; }


    public void setHG_Rank(String HG_rank) { this.Rank_CHG = HG_rank; }

    public int getHG_Stats_Level() {
        int lvl = this.HG_Stats_kills / 100;
        return this.HG_Stats_Partidas_ganadas / 2;
    }




    public int getHG_Stats_topkillstreak() { return this.HG_Stats_topkillstreak; }



    public void addHG_Stats_topkillstreak(int hG_Stats_topkillstreak) { this.HG_Stats_topkillstreak += hG_Stats_topkillstreak; }



    public void setHG_Stats_topkillstreak(int hG_Stats_topkillstreak) { this.HG_Stats_topkillstreak = hG_Stats_topkillstreak; }



    public int getHG_Stats_deaths() { return this.HG_Stats_deaths; }



    public void addHG_Stats_deaths(int hG_Stats_deaths) { this.HG_Stats_deaths += hG_Stats_deaths; }



    public void setHG_Stats_deaths(int hG_Stats_deaths) { this.HG_Stats_deaths = hG_Stats_deaths; }



    public int getHG_Stats_kills() { return this.HG_Stats_kills; }



    public void addHG_Stats_kills(int hG_Stats_kills) { this.HG_Stats_kills += hG_Stats_kills; }



    public void setHG_Stats_kills(int hG_Stats_kills) { this.HG_Stats_kills = hG_Stats_kills; }



    public int getHG_Stats_kdr() {
        int kdr;
        if (getHG_Stats_deaths() <= 0) {
            kdr = getHG_Stats_kills() / 1;
        } else {
            kdr = getHG_Stats_kills() / getHG_Stats_deaths();
        }
        return kdr;
    }


    public String getCHG_Kit() { return this.CHG_Kit; }



    public void setCHG_Kit(String CHG_Kit) { this.CHG_Kit = CHG_Kit; }



    public boolean isCHG_Winner() { return this.CHG_Winner; }



    public void setCHG_Winner(boolean cHG_Winner) { this.CHG_Winner = cHG_Winner; }




    public int getCHG_Stats_Partidas_ganadas() { return this.CHG_Stats_Partidas_ganadas; }



    public void addCHG_Stats_Partidas_ganadas(int CHG_Stats_Partidas_ganadas) { this.CHG_Stats_Partidas_ganadas += CHG_Stats_Partidas_ganadas; }



    public void setCHG_Stats_Partidas_ganadas(int CHG_Stats_Partidas_ganadas) { this.CHG_Stats_Partidas_ganadas = CHG_Stats_Partidas_ganadas; }



    public int getCHG_Stats_Partidas_jugadas() { return this.CHG_Stats_Partidas_jugadas; }



    public void addCHG_Stats_Partidas_jugadas(int CHG_Stats_Partidas_jugadas) { this.CHG_Stats_Partidas_jugadas += CHG_Stats_Partidas_jugadas; }



    public void setCHG_Stats_Partidas_jugadas(int CHG_Stats_Partidas_jugadas) { this.CHG_Stats_Partidas_jugadas = CHG_Stats_Partidas_jugadas; }


    public int getCHG_Stats_Level() {
        int lvl = this.CHG_Stats_kills / 100;
        return this.CHG_Stats_Partidas_ganadas / 2;
    }




    public int getCHG_Stats_topkillstreak() { return this.CHG_Stats_topkillstreak; }



    public void addCHG_Stats_topkillstreak(int CHG_Stats_topkillstreak) { this.CHG_Stats_topkillstreak += CHG_Stats_topkillstreak; }



    public void setCHG_Stats_topkillstreak(int CHG_Stats_topkillstreak) { this.CHG_Stats_topkillstreak = CHG_Stats_topkillstreak; }



    public int getCHG_Stats_deaths() { return this.CHG_Stats_deaths; }



    public void addCHG_Stats_deaths(int CHG_Stats_deaths) { this.CHG_Stats_deaths += CHG_Stats_deaths; }



    public void setCHG_Stats_deaths(int CHG_Stats_deaths) { this.CHG_Stats_deaths = CHG_Stats_deaths; }



    public int getCHG_Stats_kills() { return this.CHG_Stats_kills; }



    public void addCHG_Stats_kills(int CHG_Stats_kills) { this.CHG_Stats_kills += CHG_Stats_kills; }



    public void setCHG_Stats_kills(int CHG_Stats_kills) { this.CHG_Stats_kills = CHG_Stats_kills; }



    public int getCHG_Stats_kdr() {
        int kdr;
        if (getCHG_Stats_deaths() <= 0) {
            kdr = getCHG_Stats_kills() / 1;
        } else {
            kdr = getCHG_Stats_kills() / getCHG_Stats_deaths();
        }
        return kdr;
    }


    public String getKitPVP_Kit() { return this.KitPVP_Kit; }



    public void setKitPVP_Kit(String KitPVP_Kit) { this.KitPVP_Kit = KitPVP_Kit; }



    public int getKitPVP_Stats_Level() { return this.KitPVP_Stats_kills / 150; }




    public int getKitPVP_Stats_topkillstreak() { return this.KitPVP_Stats_topkillstreak; }



    public void addKitPVP_Stats_topkillstreak(int KitPVP_Stats_topkillstreak) { this.KitPVP_Stats_topkillstreak += KitPVP_Stats_topkillstreak; }



    public void setKitPVP_Stats_topkillstreak(int KitPVP_Stats_topkillstreak) { this.KitPVP_Stats_topkillstreak = KitPVP_Stats_topkillstreak; }



    public int getKitPVP_Stats_deaths() { return this.KitPVP_Stats_deaths; }



    public void addKitPVP_Stats_deaths(int KitPVP_Stats_deaths) { this.KitPVP_Stats_deaths += KitPVP_Stats_deaths; }



    public void setKitPVP_Stats_deaths(int KitPVP_Stats_deaths) { this.KitPVP_Stats_deaths = KitPVP_Stats_deaths; }



    public int getKitPVP_Stats_kills() { return this.KitPVP_Stats_kills; }



    public void addKitPVP_Stats_kills(int KitPVP_Stats_kills) { this.KitPVP_Stats_kills += KitPVP_Stats_kills; }



    public void setKitPVP_Stats_kills(int KitPVP_Stats_kills) { this.KitPVP_Stats_kills = KitPVP_Stats_kills; }



    public int getKitPVP_Stats_kdr() {
        int kdr;
        if (getKitPVP_Stats_deaths() <= 0) {
            kdr = getKitPVP_Stats_kills() / 1;
        } else {
            kdr = getKitPVP_Stats_kills() / getKitPVP_Stats_deaths();
        }
        return kdr;
    }


    public String getPOTPVP_Kit() { return this.POTPVP_Kit; }



    public void setPOTPVP_Kit(String POTPVP_Kit) { this.POTPVP_Kit = POTPVP_Kit; }



    public int getPOTPVP_Stats_Partidas_ganadas() { return this.POTPVP_Stats_Partidas_ganadas; }



    public void addPOTPVP_Stats_Partidas_ganadas(int POTPVP_Stats_Partidas_ganadas) { this.POTPVP_Stats_Partidas_ganadas += POTPVP_Stats_Partidas_ganadas; }



    public void setPOTPVP_Stats_Partidas_ganadas(int POTPVP_Stats_Partidas_ganadas) { this.POTPVP_Stats_Partidas_ganadas = POTPVP_Stats_Partidas_ganadas; }



    public int getPOTPVP_Stats_Partidas_jugadas() { return this.POTPVP_Stats_Partidas_jugadas; }



    public void addPOTPVP_Stats_Partidas_jugadas(int POTPVP_Stats_Partidas_jugadas) { this.POTPVP_Stats_Partidas_jugadas += POTPVP_Stats_Partidas_jugadas; }



    public void setPOTPVP_Stats_Partidas_jugadas(int POTPVP_Stats_Partidas_jugadas) { this.POTPVP_Stats_Partidas_jugadas = POTPVP_Stats_Partidas_jugadas; }



    public int getPOTPVP_Stats_Level() { return this.POTPVP_Stats_kills / 100; }





    public int getPOTPVP_Stats_topkillstreak() { return this.POTPVP_Stats_topkillstreak; }



    public void addPOTPVP_Stats_topkillstreak(int POTPVP_Stats_topkillstreak) { this.POTPVP_Stats_topkillstreak += POTPVP_Stats_topkillstreak; }



    public void setPOTPVP_Stats_topkillstreak(int POTPVP_Stats_topkillstreak) { this.POTPVP_Stats_topkillstreak = POTPVP_Stats_topkillstreak; }



    public int getPOTPVP_Stats_deaths() { return this.POTPVP_Stats_deaths; }



    public void addPOTPVP_Stats_deaths(int POTPVP_Stats_deaths) { this.POTPVP_Stats_deaths += POTPVP_Stats_deaths; }



    public void setPOTPVP_Stats_deaths(int POTPVP_Stats_deaths) { this.POTPVP_Stats_deaths = POTPVP_Stats_deaths; }



    public int getPOTPVP_Stats_kills() { return this.POTPVP_Stats_kills; }



    public void addPOTPVP_Stats_kills(int POTPVP_Stats_kills) { this.POTPVP_Stats_kills += POTPVP_Stats_kills; }



    public void setPOTPVP_Stats_kills(int POTPVP_Stats_kills) { this.POTPVP_Stats_kills = POTPVP_Stats_kills; }



    public int getPOTPVP_Stats_kdr() {
        int kdr;
        if (getPOTPVP_Stats_deaths() <= 0) {
            kdr = getPOTPVP_Stats_kills() / 1;
        } else {
            kdr = getPOTPVP_Stats_kills() / getPOTPVP_Stats_deaths();
        }
        return kdr;
    }


    public String getSKYW_Kit() { return this.SKYW_Kit; }



    public void setSKYW_Kit(String SKYW_Kit) { this.SKYW_Kit = SKYW_Kit; }



    public int getSKYW_Stats_Partidas_ganadas() { return this.SKYW_Stats_Partidas_ganadas; }



    public void addSKYW_Stats_Partidas_ganadas(int SKYW_Stats_Partidas_ganadas) { this.SKYW_Stats_Partidas_ganadas += SKYW_Stats_Partidas_ganadas; }



    public void setSKYW_Stats_Partidas_ganadas(int SKYW_Stats_Partidas_ganadas) { this.SKYW_Stats_Partidas_ganadas = SKYW_Stats_Partidas_ganadas; }



    public int getSKYW_Stats_Partidas_jugadas() { return this.SKYW_Stats_Partidas_jugadas; }



    public void addSKYW_Stats_Partidas_jugadas(int SKYW_Stats_Partidas_jugadas) { this.SKYW_Stats_Partidas_jugadas += SKYW_Stats_Partidas_jugadas; }



    public void setSKYW_Stats_Partidas_jugadas(int SKYW_Stats_Partidas_jugadas) { this.SKYW_Stats_Partidas_jugadas = SKYW_Stats_Partidas_jugadas; }


    public int getSKYW_Stats_Level() {
        int lvl = this.SKYW_Stats_kills / 100;
        return lvl;
    }




    public int getSKYW_Stats_topkillstreak() { return this.SKYW_Stats_topkillstreak; }



    public void addSKYW_Stats_topkillstreak(int SKYW_Stats_topkillstreak) { this.SKYW_Stats_topkillstreak += SKYW_Stats_topkillstreak; }



    public void setSKYW_Stats_topkillstreak(int SKYW_Stats_topkillstreak) { this.SKYW_Stats_topkillstreak = SKYW_Stats_topkillstreak; }



    public int getSKYW_Stats_deaths() { return this.SKYW_Stats_deaths; }



    public void addSKYW_Stats_deaths(int SKYW_Stats_deaths) { this.SKYW_Stats_deaths += SKYW_Stats_deaths; }



    public void setSKYW_Stats_deaths(int SKYW_Stats_deaths) { this.SKYW_Stats_deaths = SKYW_Stats_deaths; }



    public int getSKYW_Stats_kills() { return this.SKYW_Stats_kills; }



    public void addSKYW_Stats_kills(int SKYW_Stats_kills) { this.SKYW_Stats_kills += SKYW_Stats_kills; }



    public void setSKYW_Stats_kills(int SKYW_Stats_kills) { this.SKYW_Stats_kills = SKYW_Stats_kills; }



    public int getSKYW_Stats_kdr() {
        int kdr;
        if (getSKYW_Stats_deaths() <= 0) {
            kdr = getSKYW_Stats_kills() / 1;
        } else {
            kdr = getSKYW_Stats_kills() / getSKYW_Stats_deaths();
        }
        return kdr;
    }


    public String getBEDW_Kit() { return this.BEDW_Kit; }



    public void setBEDW_Kit(String BEDW_Kit) { this.BEDW_Kit = BEDW_Kit; }



    public int getBEDW_Stats_Partidas_ganadas() { return this.BEDW_Stats_Partidas_ganadas; }



    public void addBEDW_Stats_Partidas_ganadas(int BEDW_Stats_Partidas_ganadas) { this.BEDW_Stats_Partidas_ganadas += BEDW_Stats_Partidas_ganadas; }



    public void setBEDW_Stats_Partidas_ganadas(int BEDW_Stats_Partidas_ganadas) { this.BEDW_Stats_Partidas_ganadas = BEDW_Stats_Partidas_ganadas; }



    public int getBEDW_Stats_Partidas_jugadas() { return this.BEDW_Stats_Partidas_jugadas; }



    public void addBEDW_Stats_Partidas_jugadas(int BEDW_Stats_Partidas_jugadas) { this.BEDW_Stats_Partidas_jugadas += BEDW_Stats_Partidas_jugadas; }



    public void setBEDW_Stats_Partidas_jugadas(int BEDW_Stats_Partidas_jugadas) { this.BEDW_Stats_Partidas_jugadas = BEDW_Stats_Partidas_jugadas; }


    public int getBEDW_Stats_Level() {
        int lvl = this.BEDW_Stats_kills / 100;
        return this.BEDW_Stats_Partidas_ganadas / 2;
    }




    public int getBEDW_Stats_topkillstreak() { return this.BEDW_Stats_topkillstreak; }



    public void addBEDW_Stats_topkillstreak(int BEDW_Stats_topkillstreak) { this.BEDW_Stats_topkillstreak += BEDW_Stats_topkillstreak; }



    public void setBEDW_Stats_topkillstreak(int BEDW_Stats_topkillstreak) { this.BEDW_Stats_topkillstreak = BEDW_Stats_topkillstreak; }



    public int getBEDW_Stats_deaths() { return this.BEDW_Stats_deaths; }



    public void addBEDW_Stats_deaths(int BEDW_Stats_deaths) { this.BEDW_Stats_deaths += BEDW_Stats_deaths; }



    public void setBEDW_Stats_deaths(int BEDW_Stats_deaths) { this.BEDW_Stats_deaths = BEDW_Stats_deaths; }



    public int getBEDW_Stats_kills() { return this.BEDW_Stats_kills; }



    public void addBEDW_Stats_kills(int BEDW_Stats_kills) { this.BEDW_Stats_kills += BEDW_Stats_kills; }



    public void setBEDW_Stats_kills(int BEDW_Stats_kills) { this.BEDW_Stats_kills = BEDW_Stats_kills; }



    public int getBEDW_Stats_kdr() {
        int kdr;
        if (getBEDW_Stats_deaths() <= 0) {
            kdr = getBEDW_Stats_kills() / 1;
        } else {
            kdr = getBEDW_Stats_kills() / getBEDW_Stats_deaths();
        }
        return kdr;
    }


    public String getBEDW_Trail_Effect() { return this.BEDW_Trail_Effect; }



    public void setBEDW_Trail_Effect(String BEDW_Trail_Effect) { this.BEDW_Trail_Effect = BEDW_Trail_Effect; }



    public String getBEDW_Glass_Color() { return this.BEDW_Glass_Color; }



    public void setBEDW_Glass_Color(String BEDW_Glass_Color) { this.BEDW_Glass_Color = BEDW_Glass_Color; }


    public ArrayList<String> getBEDW_OWN_KITS() {
        if (this.BEDW_OWN_KITS == null) {
            this.BEDW_OWN_KITS = Lists.newArrayList();
        }
        return this.BEDW_OWN_KITS;
    }


    public void addBEDW_OWN_KITS(String BEDW_OWN_KITS) { getBEDW_OWN_KITS().add(BEDW_OWN_KITS); }


    public void BuyKit_SV_BEDW(String kitname) {
        Database.BuyKit_SV_BEDWARS(this, kitname);
        getBEDW_OWN_KITS().add(kitname);
    }


    public String getPVPG_Kit() { return this.PVPG_Kit; }



    public void setPVPG_Kit(String PVPG_Kit) { this.PVPG_Kit = PVPG_Kit; }



    public int getPVPG_Stats_Partidas_ganadas() { return this.PVPG_Stats_Partidas_ganadas; }



    public void addPVPG_Stats_Partidas_ganadas(int PVPG_Stats_Partidas_ganadas) { this.PVPG_Stats_Partidas_ganadas += PVPG_Stats_Partidas_ganadas; }



    public void setPVPG_Stats_Partidas_ganadas(int PVPG_Stats_Partidas_ganadas) { this.PVPG_Stats_Partidas_ganadas = PVPG_Stats_Partidas_ganadas; }



    public int getPVPG_Stats_Partidas_jugadas() { return this.PVPG_Stats_Partidas_jugadas; }



    public void addPVPG_Stats_Partidas_jugadas(int PVPG_Stats_Partidas_jugadas) { this.PVPG_Stats_Partidas_jugadas += PVPG_Stats_Partidas_jugadas; }



    public void setPVPG_Stats_Partidas_jugadas(int PVPG_Stats_Partidas_jugadas) { this.PVPG_Stats_Partidas_jugadas = PVPG_Stats_Partidas_jugadas; }


    public int getPVPG_Stats_Level() {
        int lvl = this.PVPG_Stats_kills / 100;
        return this.PVPG_Stats_Partidas_ganadas / 2;
    }




    public int getPVPG_Stats_topkillstreak() { return this.PVPG_Stats_topkillstreak; }



    public void addPVPG_Stats_topkillstreak(int PVPG_Stats_topkillstreak) { this.PVPG_Stats_topkillstreak += PVPG_Stats_topkillstreak; }



    public void setPVPG_Stats_topkillstreak(int PVPG_Stats_topkillstreak) { this.PVPG_Stats_topkillstreak = PVPG_Stats_topkillstreak; }



    public int getPVPG_Stats_deaths() { return this.PVPG_Stats_deaths; }



    public void addPVPG_Stats_deaths(int PVPG_Stats_deaths) { this.PVPG_Stats_deaths += PVPG_Stats_deaths; }



    public void setPVPG_Stats_deaths(int PVPG_Stats_deaths) { this.PVPG_Stats_deaths = PVPG_Stats_deaths; }



    public int getPVPG_Stats_kills() { return this.PVPG_Stats_kills; }



    public void addPVPG_Stats_kills(int PVPG_Stats_kills) { this.PVPG_Stats_kills += PVPG_Stats_kills; }



    public void setPVPG_Stats_kills(int PVPG_Stats_kills) { this.PVPG_Stats_kills = PVPG_Stats_kills; }



    public int getPVPG_Stats_kdr() {
        int kdr;
        if (getPVPG_Stats_deaths() <= 0) {
            kdr = getPVPG_Stats_kills() / 1;
        } else {
            kdr = getPVPG_Stats_kills() / getPVPG_Stats_deaths();
        }
        return kdr;
    }


    public int getPVPG_Stats_cores_leakeds() { return this.PVPG_Stats_cores_leakeds; }



    public void addPVPG_Stats_cores_leakeds(int PVPG_Stats_cores_leakeds) { this.PVPG_Stats_cores_leakeds += PVPG_Stats_cores_leakeds; }



    public void setPVPG_Stats_cores_leakeds(int PVPG_Stats_cores_leakeds) { this.PVPG_Stats_cores_leakeds = PVPG_Stats_cores_leakeds; }



    public int getPVPG_Stats_wools_placed() { return this.PVPG_Stats_wools_placed; }



    public void addPVPG_Stats_wools_placed(int PVPG_Stats_wools_placed) { this.PVPG_Stats_wools_placed += PVPG_Stats_wools_placed; }



    public void setPVPG_Stats_wools_placed(int PVPG_Stats_wools_placed) { this.PVPG_Stats_wools_placed = PVPG_Stats_wools_placed; }



    public int getPVPG_Stats_monuments_destroyed() { return this.PVPG_Stats_monuments_destroyed; }



    public void addPVPG_Stats_monuments_destroyed(int PVPG_Stats_monuments_destroyed) { this.PVPG_Stats_monuments_destroyed += PVPG_Stats_monuments_destroyed; }



    public void setPVPG_Stats_monuments_destroyed(int PVPG_Stats_monuments_destroyed) { this.PVPG_Stats_monuments_destroyed = PVPG_Stats_monuments_destroyed; }



    public boolean SaveSQL() { return this.saveSQL; }



    public void setSaveSQL(boolean saveSQL) { this.saveSQL = saveSQL; }



    public boolean isOpciones_SVS_Enable_Players() { return this.Opciones_SVS_Enable_Players; }



    public void setOpciones_SVS_Enable_Players(boolean opciones_SVS_Enable_Players) { this.Opciones_SVS_Enable_Players = opciones_SVS_Enable_Players; }



    public boolean isOpciones_SVS_Enable_Chat() { return this.Opciones_SVS_Enable_Chat; }



    public void setOpciones_SVS_Enable_Chat(boolean opciones_SVS_Enable_Chat) { this.Opciones_SVS_Enable_Chat = opciones_SVS_Enable_Chat; }



    public boolean isOpciones_SVS_Enable_Stacker() { return this.Opciones_SVS_Enable_Stacker; }



    public void setOpciones_SVS_Enable_Stacker(boolean opciones_SVS_Enable_Stacker) { this.Opciones_SVS_Enable_Stacker = opciones_SVS_Enable_Stacker; }



    public boolean isOpciones_SVS_Enabled_Minilobby() { return this.Opciones_SVS_Enable_MiniLobby; }



    public void setOpciones_SVS_Enabled_Minilobby(boolean opciones_SVS_minilobby) { this.Opciones_SVS_Enable_MiniLobby = opciones_SVS_minilobby; }



    public String getSKYW_Trail_Effect() { return this.SKYW_Trail_Effect; }



    public void setSKYW_Trail_Effect(String sKYW_Trail_Effect) { this.SKYW_Trail_Effect = sKYW_Trail_Effect; }



    public String getSKYW_Glass_Color() { return this.SKYW_Glass_Color; }



    public void setSKYW_Glass_Color(String sKYW_Glass_Color) { this.SKYW_Glass_Color = sKYW_Glass_Color; }


    public ArrayList<String> getSKYW_OWN_KITS() {
        if (this.SKYW_OWN_KITS == null) {
            this.SKYW_OWN_KITS = Lists.newArrayList();
        }
        return this.SKYW_OWN_KITS;
    }


    public void addSKYW_OWN_KITS(String sKYW_OWN_KITS) { getSKYW_OWN_KITS().add(sKYW_OWN_KITS); }


    public void BuyKit_SV_SKYW(String kitname) {
        Database.BuyKit_SV_SKYW(this, kitname);
        getSKYW_OWN_KITS().add(kitname);
    }

    public ArrayList<String> getHG_OWN_KITS() {
        if (this.HG_OWN_KITS == null) {
            this.HG_OWN_KITS = Lists.newArrayList();
        }
        return this.HG_OWN_KITS;
    }


    public void addHG_OWN_KITS(String sKYW_OWN_KITS) { getHG_OWN_KITS().add(sKYW_OWN_KITS); }


    public void BuyKit_SV_HG(String kitname) {
        Database.BuyKit_SV_HG(this, kitname);
        getHG_OWN_KITS().add(kitname);
    }


    public String getHG_Trail_Effect() { return this.HG_Trail_Effect; }



    public void setHG_Trail_Effect(String hG_Trail_Effect) { this.HG_Trail_Effect = hG_Trail_Effect; }



    public String getHG_Place_Color() { return this.HG_Place_Color; }



    public void setHG_Place_Color(String hG_Place_Color) { this.HG_Place_Color = hG_Place_Color; }



    public ArrayList<String> getCHG_OWN_KITS() {
        if (this.CHG_OWN_KITS == null) {
            this.CHG_OWN_KITS = Lists.newArrayList();
        }
        return this.CHG_OWN_KITS;
    }


    public void addCHG_OWN_KITS(String sKYW_OWN_KITS) { getCHG_OWN_KITS().add(sKYW_OWN_KITS); }


    public void BuyKit_SV_CHG(String kitname) {
        Database.BuyKit_SV_CHG(this, kitname);
        getCHG_OWN_KITS().add(kitname);
    }


    public String getCHG_Trail_Effect() { return this.CHG_Trail_Effect; }



    public void setCHG_Trail_Effect(String CHG_Trail_Effect) { this.CHG_Trail_Effect = CHG_Trail_Effect; }



    public String getCHG_Place_Color() { return this.CHG_Place_Color; }



    public void setCHG_Place_Color(String CHG_Place_Color) { this.CHG_Place_Color = CHG_Place_Color; }



    public boolean isOnlineModeVerify() { return this.onlineModeVerify; }



    public void setOnlineModeVerify(boolean onlineModeVerify) { this.onlineModeVerify = onlineModeVerify; }



    public boolean isPlayerAuth_logged() { return this.PlayerAuth_logged; }



    public void setPlayerAuth_logged(boolean playerAuth_logged) { this.PlayerAuth_logged = playerAuth_logged; }



    public String getPlayerAuth_password() { return this.PlayerAuth_password; }



    public void setPlayerAuth_password(String playerAuth_password) { this.PlayerAuth_password = playerAuth_password; }



    public long getPlayerAuth_lastlogin() { return this.PlayerAuth_lastlogin; }



    public void setPlayerAuth_lastlogin(long playerAuth_lastlogin) { this.PlayerAuth_lastlogin = playerAuth_lastlogin; }



    public boolean isPlayerAuth_registred() { return this.PlayerAuth_registred; }



    public void setPlayerAuth_registred(boolean playerAuth_registred) { this.PlayerAuth_registred = playerAuth_registred; }



    public boolean isPlayerAuth_loaded() { return this.PlayerAuth_loaded; }



    public void setPlayerAuth_loaded(boolean playerAuth_loaded) { this.PlayerAuth_loaded = playerAuth_loaded; }



    public String getPlayerAuth_last_ip() { return this.PlayerAuth_last_ip; }



    public void setPlayerAuth_last_ip(String playerAuth_last_ip) { this.PlayerAuth_last_ip = playerAuth_last_ip; }



    public ChatColor getNameTagColor() { return this.NameTagColor; }



    public void setNameTagColor(ChatColor nameTagColor) { this.NameTagColor = nameTagColor; }




    public String getHG_Rank() { return this.Rank_CHG; }

    public void setWhitelistValue(String value) {
        this.value = value;
    }

    public void hasWhitelistBypass(boolean bypass) {
        this.bypass = bypass;
    }

    public String getWhitelistValue() {
        return this.value;
    }

    public boolean isWhitelistBypass() {
        return this.bypass;
    }
}


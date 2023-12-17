package lc.core.Controller;

import org.apache.commons.lang.WordUtils;

public enum Ranks {
    DEFAULT, VETERANO, PREMIUM, VIP, SVIP, ELITE, YOUTUBER, BUILDER, AYUDANTE, MOD, ADMIN, OWNER, RUBY;



    public String toString() { return WordUtils.capitalize(name().toLowerCase()); }
}

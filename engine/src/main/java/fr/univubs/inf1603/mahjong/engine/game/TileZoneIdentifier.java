package fr.univubs.inf1603.mahjong.engine.game;

import org.apache.log4j.Logger;

/**
 *
 */
public enum TileZoneIdentifier {
    Wall,
    HandEast,
    HandSouth,
    HandWest,
    HandNorth,
    SupremeEast,
    SupremeSouth,
    SupremeWest,
    SupremeNorth,
    DiscardEast,
    DiscardSouth,
    DiscardWest,
    DiscardNorth,
    MeldEast0,
    MeldEast1,
    MeldEast2,
    MeldEast3,
    MeldSouth0,
    MeldSouth1,
    MeldSouth2,
    MeldSouth3,
    MeldWest0,
    MeldWest1,
    MeldWest2,
    MeldWest3,
    MeldNorth0,
    MeldNorth1,
    MeldNorth2,
    MeldNorth3;
    
    // Logger 
    private static final Logger LOGGER = Logger.getLogger(TileZoneIdentifier.class.getName());
    
    public String getNormalizedName(){
        LOGGER.info("Enter to getNormalizedName()");
        return this.name();
    }
    public static String getNormalizedNameFromIdentifier(TileZoneIdentifier identifier){
        LOGGER.info("Enter to getNormalizedNameFromIdentifier(TileZoneIdentifier identifier)");
        return identifier.getNormalizedName();
    }
    
    public static TileZoneIdentifier getIdentifierFromNormalizedName(String normalizedName) throws ZoneException{
        for(TileZoneIdentifier v : values()){
            if(v.getNormalizedName().equals(normalizedName)){
                return v;
            }
        }
        throw new ZoneException("Reverse search could not find zone named \""+normalizedName+"\".");
    }
}

package fr.univubs.inf1603.mahjong.engine.game;

import fr.univubs.inf1603.mahjong.engine.persistence.Persistable;
import java.util.ArrayList;

/**
 *
 */
public interface TileZone extends Persistable{
        public static final String 
                TILELIST="tilelist";
        
        /**
         * @return This tile zone's list of tiles
         */
        public ArrayList<GameTileInterface> getTiles();
        
        /**
         * @return This tile zone's identifier
         */
        public TileZoneIdentifier getIdentifier();
}

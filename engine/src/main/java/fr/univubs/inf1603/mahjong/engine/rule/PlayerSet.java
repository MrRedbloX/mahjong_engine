package fr.univubs.inf1603.mahjong.engine.rule;
import fr.univubs.inf1603.mahjong.Wind;

/**
 * PlayerSet represents the state of all tiles a player has; including the player's hand, tiles set down, winds from the round 
 * and from the player, conditions about a tile drawn or stolen. 
 * Using to create different set from a situation.
 */

import fr.univubs.inf1603.mahjong.engine.game.GameTile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import org.apache.log4j.Logger;

import java.util.Objects;

public class PlayerSet {
    private GameTile winningTile;
    private Collection<Combination> hand = new HashSet<>();
    private Collection<Combination> concealed = new HashSet<>();
    private Collection<Combination> melds = new HashSet<>();
    private Collection<GameTile> supremeHonors = new HashSet<>();
    private boolean drawnFromWall;
    private boolean takenFromDiscard;
    private Wind roundWind;
    private Wind playerWind;
    
    // Logger
    private static final Logger LOGGER = Logger.getLogger(PlayerSet.class.getName());
    
    /**
     * @param winningTile It's the tile drawn from the wall or stolen, it's a winning tile if we win with her
     * @param hand  The hand of the player, it's a representation of combinations in the hand
     * @param concealed If we have a concealed combination like Kong
     * @param melds Tiles set down by the player
     * @param supremeHonors If seasons or flowers was set down
     * @param drawnFromWall A boolean, if a tile was drawn from the wall
     * @param takenFromDiscard A boolean, if a tile was stolen
     * @param roundWind Wind of the round, it's influencing the scoring
     * @param playerWind Wind of a player, it's influencing the scoring
     */
    public PlayerSet(GameTile winningTile, Collection<Combination> hand, Collection<Combination> concealed, Collection<Combination> melds, Collection<GameTile> supremeHonors,
                     boolean drawnFromWall, boolean takenFromDiscard, Wind roundWind, Wind playerWind){
        this.winningTile = winningTile;
        this.hand.addAll(hand);
        this.concealed.addAll(concealed);
        this.melds.addAll(melds);
        this.supremeHonors.addAll(supremeHonors);
        this.drawnFromWall = drawnFromWall;
        this.takenFromDiscard = takenFromDiscard;
        this.roundWind = roundWind;
        this.playerWind = playerWind;
    }

    /**
     * @param situation situation the set is created from, a set has the same attributes of the situation except
     *                  the hand which can vary from arrangement
     * @param hand arrangement of the hand
     */
    public PlayerSet(PlayerSituation situation, Collection<Combination> hand) {
        this.winningTile = situation.getWinningTile();
        this.hand.addAll(hand);
        this.concealed.addAll(situation.getConcealed());
        this.melds.addAll(situation.getMelds());
        this.supremeHonors.addAll(situation.getSupremeHonors());
        this.drawnFromWall = situation.isDrawnForWall();
        this.takenFromDiscard = situation.isTakenFromDiscard();
        this.roundWind = situation.getRoundWind();
        this.playerWind = situation.getPlayerWind();
    }

    /**
     * @return winningTile The last tile drawn or stolen which allow us to win
     */
    public GameTile getWinningTile(){
        LOGGER.info("Enter to getWinningTile()");
        return this.winningTile;
    }
    
    /**
     * @return hand It's a list of combination in the player's hand
     */
    public Collection<Combination> getHand(){
        LOGGER.info("Enter to getHand()");
        return this.hand;
    }
    
    /**
     * @return concealed It's a list of combination if some tiles are hidden
     */
    public Collection<Combination> getConcealed(){
        LOGGER.info("Enter to getConcealed()");
        return this.concealed;
    }
    
    /**
     * @return melds It's a list of combination about tiles set down
     */
    public Collection<Combination> getMelds(){
        LOGGER.info("Enter to getMelds()");
        return this.melds;
    }
    
    /**
     * @return It's a list of supremeHonors set down
     */
    public Collection<GameTile> getSupremeHonors(){
        LOGGER.info("Enter to getSupremeHonors()");
        return this.supremeHonors;
    }
    
    /**
     * @return true or false if the last tile was drawn from the wall
     */
    public boolean isDrawnForWall(){
        LOGGER.info("Enter to isDrawnForWall()");
        return this.drawnFromWall;
    }
    
    /**
     * @return true or false if the last tile was stolen
     */
    public boolean isTakenFromDiscard(){
        LOGGER.info("Enter to isTakenFromDiscard()");
        return this.takenFromDiscard;
    }
    
    /**
     * @return the wind during this round if his a upward or downward wind
     */
    public Wind getRoundWind(){
        LOGGER.info("Enter to getRoundWind()");
        return this.roundWind;
    }
    
    /**
     * @return the wind of the player, it could be east, south, weast or north
     */
    public Wind getPlayerWind(){
        LOGGER.info("Enter to getPlayerWind()");
        return this.playerWind;
    }

    public Collection<Combination> getAllCombinations() {
        LOGGER.info("Enter to getAllCombinations()");
        
        ArrayList<Combination> allCombinations = new ArrayList<>();

        allCombinations.addAll(hand);
        allCombinations.addAll(concealed);
        allCombinations.addAll(melds);

        return allCombinations;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.winningTile);
        hash = 43 * hash + Objects.hashCode(this.hand);
        hash = 43 * hash + Objects.hashCode(this.concealed);
        hash = 43 * hash + Objects.hashCode(this.melds);
        hash = 43 * hash + Objects.hashCode(this.supremeHonors);
        hash = 43 * hash + (this.drawnFromWall ? 1 : 0);
        hash = 43 * hash + (this.takenFromDiscard ? 1 : 0);
        hash = 43 * hash + Objects.hashCode(this.roundWind);
        hash = 43 * hash + Objects.hashCode(this.playerWind);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PlayerSet other = (PlayerSet) obj;
        if (this.drawnFromWall != other.drawnFromWall) {
            return false;
        }
        if (this.takenFromDiscard != other.takenFromDiscard) {
            return false;
        }
        if (!Objects.equals(this.winningTile, other.winningTile)) {
            return false;
        }
        if (!Objects.equals(this.hand, other.hand)) {
            return false;
        }
        if (!Objects.equals(this.concealed, other.concealed)) {
            return false;
        }
        if (!Objects.equals(this.melds, other.melds)) {
            return false;
        }
        if (!Objects.equals(this.supremeHonors, other.supremeHonors)) {
            return false;
        }
        if (this.roundWind != other.roundWind) {
            return false;
        }
        if (this.playerWind != other.playerWind) {
            return false;
        }
        return true;
    }
}

package fr.univubs.inf1603.mahjong.engine.rule;
import fr.univubs.inf1603.mahjong.Wind;
import org.apache.log4j.Logger;
/**
 * Flower tiles are bonus tiles used in some rules, they are associated to winds.
 */
public class FlowerTile extends SupremeHonor{
    /**
     * Symbol used to represent seasons during normalized naming
     */
    private static final char FLOWER_SYMBOL='F';
    
    // Logger
    private static final Logger LOGGER = Logger.getLogger(FlowerTile.class.getName());
    
    /**
     * Possible flowers of flower tiles
     */
    public enum Flower{
        PLUM(1, Wind.EAST), ORCHID(2, Wind.SOUTH), CHRYSANTHEMUM(3, Wind.WEST), BAMBOO(4, Wind.NORTH);
        private final int value;
        private final Wind wind;

        private Flower(int value, Wind wind){
            this.value = value;
            this.wind = wind;
        }
        
        public Wind getWind(){
            return this.wind;
        }
        
        public int getValue(){ 
            return this.value;
        }
    }

    private final Flower flower;
    
    /**
     * 
     * @param flower Flower of the Tile
     */
    public FlowerTile(Flower flower){
        super(flower.getWind());
        this.flower = flower;
    }
    
    /**
     * @return Returns this FlowerTile's flower. 
     */
    public Flower getFlower(){
        LOGGER.info("Enter to getFlower() method");
        return this.flower;
    }
    
    @Override
    public String toNormalizedName() {
        LOGGER.info("Enter to toNormalizedName() method");
        return String.format("%c%d", FLOWER_SYMBOL,this.flower.getValue());
    }
    
    @Override
    public String toString(){
        LOGGER.info("Enter to toString() method");
       return super.toString()+"wind_"+this.wind+"flower_"+this.flower;
    }
}

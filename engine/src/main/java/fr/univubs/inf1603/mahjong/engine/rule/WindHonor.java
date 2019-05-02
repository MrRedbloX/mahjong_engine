package fr.univubs.inf1603.mahjong.engine.rule;
import fr.univubs.inf1603.mahjong.Wind;

/**
 * WindHonor represents tiles which are associated to a wind.
 */
public abstract class WindHonor extends HonorTile{
    protected Wind wind;
    
    /**
     * Constructor
     * @param wind initialization of a windTile 
     */
    public WindHonor(Wind wind){
        this.wind = wind;
    }
    
    /**
     * @return Returns this tile's associated wind
     */
    @Override
    public Wind getWind(){
        return this.wind;
    }
    
    @Override
    public String toString(){
       return super.toString()+"windHonor_"+wind;
    }
}


/**
 * Write a description of class Gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Gun implements Locatable
{
    private int gunGauge; //only certain possible values.
    private double timePerShot; //in seconds? ms? 
    private ArrayList<Voxel> gunLocations;
    private String gunChoke;
    private Voxel gunTip;

    /**
     * Constructor for objects of class Gun
     */
    public Gun(int gauge, double firingRatePerShot, String choke)
    {
        setLocations();
        setTip();
        gunGauge = gauge;
        timePerShot = firingRatePerShot;
        setLocations();
        gunChoke = choke;

    }

    public void setLocations()
    {
        
    }
    public void setTip()
    {
        gunTip = ThreeDGrid.getOrigin(); //Replace with necessary voxel
    }
    public ArrayList<Voxel> getLocations()
    {
        return null;
    }
    public Voxel getGunTip()
    {
        return gunTip;
    }
}

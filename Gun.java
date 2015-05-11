
/**
 * Write a description of class Gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Gun extends MovingObj
{
    // instance variables - replace the example below with your own
    private int gGauge; //only certain possible values.
    private int timePerShot; //in seconds? ms? 
    private Object direction; //as two angles? how?
    private ArrayList<Voxel> gunLocations;
    private Object choke;
    

    /**
     * Constructor for objects of class Gun
     */
    public Gun()
    {

    }

    public void setLocations(){}
    public ArrayList<Voxel> getLocations(){return null;}
    public void velocity(){} //<-- see other notes abt velocity
}

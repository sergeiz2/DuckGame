
/**
 * Write a description of class Duck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Duck extends MovingObj
{
    private Voxel velocity; //<-- see other notes about velocity
    private ArrayList<Voxel> duckLocations;
    private int size;
    
    /**
     * Constructor for objects of class Duck
     */
    public Duck(int duckSize, Object initVelocity /*<--see other notes about velocity*/, Object initLocations)
    {
        size = duckSize;
    }

    public void setLocations(){}
    public ArrayList<Voxel> getLocations(){return null;}
    public void velocity(){} //<--see other notes about necessity of velocity method
}

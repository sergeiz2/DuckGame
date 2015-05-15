
/**
 * Write a description of class Duck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Duck extends MovingObj
{
    private Voxel duckVelocity;
    private ArrayList<Voxel> duckLocations;
    private final int duckSize;
    
    public Duck(int size, ArrayList<Voxel> initLocations, Voxel initVelocity)
    {
        super(initLocations.get(0), initVelocity);
        duckSize = size;
        duckLocations = initLocations;
    }
    public void setLocations()
    {
    }
    public ArrayList<Voxel> getLocations()
    {
        return duckLocations;
    }
    public void setReferanceVoxel()
    {
    }
    public void setVelocity()
    {
    }
}

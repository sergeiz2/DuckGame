
/**
 * Write a description of class Duck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import org.apache.commons.math3.geometry.euclidean.threed.*;

public class Duck extends MovingObj
{
    private Vector3D duckVelocity;
    private ArrayList<Vector3D> duckLocations;
    
    public Duck(ArrayList<Vector3D> initLocations, Vector3D initVelocity)
    {
        super(initLocations.get(0), initVelocity);
        duckLocations = initLocations;
    }
    public void setLocations()
    {
    }
    public ArrayList<Vector3D> getLocations()
    {
        return duckLocations;
    }
    public void setReferancePoint()
    {
    }
    public void setVelocity()
    {
    }
}

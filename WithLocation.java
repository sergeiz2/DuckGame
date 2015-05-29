
/**
 * Write a description of interface Locatable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import org.apache.commons.math3.geometry.euclidean.threed.*;
public abstract class WithLocation
{
    private ArrayList<Vector3D> locations;
    
    void setLocations(ArrayList<Vector3D> locations)
    {
        this.locations = locations;
    }
    abstract ArrayList<Vector3D> calcLocations(long time);
    ArrayList<Vector3D> getLocations()
    {
        return locations;
    }
}

/**
 * Write a description of class Gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import org.apache.commons.math3.geometry.euclidean.threed.*;

public class Gun implements Locatable
{
    private final int gunGauge = 12; //only certain possible values.
    private final double timePerShot = 1000; //in ms.
    private ArrayList<Vector3D> gunLocations;
    private Vector3D gunTip; //<-- maybe instead of this just find the appropriate point from gunLocations?

    /**
     * Constructor for objects of class Gun
     */
    public Gun()
    {
        setLocations();
        setTip(); //See note above for gunTip
        setLocations();
    }

    public void setLocations()
    {
        
    }
    public void setTip()
    {
        gunTip = Vector3D.ZERO; //Replace with necessary Vector3D
    }
    public ArrayList<Vector3D> getLocations()
    {
        return null;
    }
    public Vector3D getGunTip()
    {
        return gunTip;
    }
}

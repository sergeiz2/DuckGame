
/**
 * Write a description of class Gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import org.apache.commons.math3.geometry.euclidean.threed.*;

public class ComplexGun extends Gun
{
    private int gunGauge; //only certain possible values.
    private double timePerShot; //in seconds? ms? 
    private ArrayList<Vector3D> gunLocations;
    private String gunChoke;
    private Vector3D gunTip; //<-- maybe instead of this just find the appropriate point from gunLocations?

    /**
     * Constructor for objects of class Gun
     */
    public ComplexGun(int gauge, double firingRatePerShot, String choke)
    {
        setLocations();
        setTip(); //See note above for gunTip
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

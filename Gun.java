
/**
 * Write a description of class Gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import org.apache.commons.math3.geometry.euclidean.threed.*;

public class Gun extends WithLocation
{
    private final int gunGauge ; //only certain possible values.
    private ArrayList<Vector3D> gunLocations;
    private Vector3D gunTip; //<-- maybe instead of this just find the appropriate point from gunLocations?
    private String gunType;
    private Shot shot;
    private double xAim;
    private double zAim; //note that z is the up and down axis for vector ops, but y is the up and down axis for graphics.
    private int timesShot;
    private long timeLastShot;
    private final long DOUBLE_BARREL_RELOAD_TIME = 5000000000L;
    private final long DOUBLE_BARREL_SHOOT_TIME = 100000000L;


    /**
     * Constructor for objects of class Gun
     */
    public Gun(int gauge, String type, Shot shot)
    {
        gunGauge = gauge;
        gunType = type;
        setLocations(calcLocations(null, null));
        setTip(); //See note above for gunTip
        this.shot = shot;
    }
    public void setTip()
    {
        gunTip = Vector3D.ZERO; //Replace with necessary Vector3D
    }
    public ArrayList<Vector3D> calcLocations(ArrayList<Vector3D> relativeLocations, Vector3D referancePoint)
    {
        return null; //In this version there is no gun in play. 
    }
    public Vector3D getGunTip()
    {
        return gunTip;
    }
    public void shoot()
    {
        shot.fire(xAim, zAim);
        timeLastShot = System.nanoTime();
        timesShot++;
    }
        public boolean canShoot()
    {
        if (gunType.equals("double barrel"))
        {
            if (timesShot % 2 == 0)
                return System.nanoTime() - timeLastShot > DOUBLE_BARREL_RELOAD_TIME;//Reload time for double barrel
            else
                return System.nanoTime() - timeLastShot > DOUBLE_BARREL_SHOOT_TIME;//time between shots for double barrel
        }
        else
        {
            System.out.println("ERROR! /n Unsupported gun!");
            System.exit(0);
            return false;
        }
    }
}


/**
 * Write a description of class Shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import org.apache.commons.math3.geometry.euclidean.threed.*;

public class Shot extends MovingObj
{
    private final int shotGauge;
    private int shotSize; //Actual shot size of the round
    private final int nOfPellets;
    private Vector3D shotVelocity;
    private ArrayList<Vector3D> shotLocations;
    private double probablilityOfShotInVoxel; 

    /**
     * Constructor for objects of class Shot
     */
    public Shot(int gauge, int sizeOfShot, Vector3D initVelocity)
    {
        super(Vector3D.ZERO/*<--Change this ref pt later.*/,  initVelocity);
        setLocations();
        shotSize = sizeOfShot;
        shotGauge = gauge;
        nOfPellets = calcNOfPellets();
        setInitLocation();/*Calculate the point immediately in front of the barrel of the gun*/
    }
    private void setInitLocation()
    {

    }
    public void setLocations()
    {
    }
    public ArrayList<Vector3D> getLocations()
    {
        return shotLocations;
    }
    public void setVelocity()
    {
    }
    public void setReferancePoint()
    {
    }
    public int calcNOfPellets ()
    {
        return 0; //insert math later 
    }
    public void setProbablilityOfShotInPoint()
    {
        //calculate the probablility. There should still be exactly nOfPellets pellets per cloud. 
        //USE DENSITY
    }
}

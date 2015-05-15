
/**
 * Write a description of class Shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Shot extends MovingObj
{
    private final int shotGauge;
    private int shotSize; //Actual shot size of the round
    private final int nOfPellets;
    private Voxel shotVelocity;
    private ArrayList<Voxel> shotLocations;
    private double probablilityOfShotInVoxel; 

    /**
     * Constructor for objects of class Shot
     */
    public Shot(int gauge, int sizeOfShot, Voxel initVelocity)
    {
        super(ThreeDGrid.getOrigin(),  initVelocity);
        setLocations();
        shotSize = sizeOfShot;
        shotGauge = gauge;
        nOfPellets = calcNOfPellets();
        setInitVoxelLocation();/*Calculate the voxel immediately in front of the barrel of the gun*/
    }
    private void setInitVoxelLocation()
    {
        //shotLocations.add(Gun.getGunTip()); //Which instance of gun is this? Instance needs to be a param.
        //                              ^^^^^^^^^^ can't do this. calling from static constructor, getGunTip() is not
        //                                                         and can't be static... ???
    }
    public void setLocations()
    {
    }
    public ArrayList<Voxel> getLocations()
    {
        return shotLocations;
    }
    public void setVelocity()
    {
    }
    public void setReferanceVoxel()
    {
    }
    public int calcNOfPellets ()
    {
        return 0; //insert math later 
    }
    public void setProbablilityOfShotInVoxel()
    {
        //calculate the probablility. There should still be exactly nOfPellets pellets per cloud. 
        //USE DENSITY
    }
}

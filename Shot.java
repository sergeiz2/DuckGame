
/**
 * Write a description of class Shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Shot extends MovingObj
{
    private int sGauge;
    private int shotSize;
    private int nOfPellets;
    private Voxel velocity;
    private ArrayList<Voxel> shotLocations;
    private double probablilityOfShotInVoxel; //There should still be exactly nOfPellets pellets per cloud. More hardecore math. USE DENSITY

    /**
     * Constructor for objects of class Shot
     */
    public Shot()
    {
        
    }

    public void setLocations(){}
    public ArrayList<Voxel> getLocations(){return null;}
    public void velocity(){} //<-- see other velocity notes
    public int calcNOfPellets (int gauge, int shotSize){return 0;}
}


/**
 * Write a description of class ThreeDGrid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class ThreeDGrid
{
    private int size;
    private Voxel[][][] gridLocations;
    private final Voxel origin;

    /**
     * Constructor for objects of class ThreeDGrid
     */
    public ThreeDGrid(int size)
    {
        gridLocations = new Voxel[size*2][size*2][size*2];
        origin = gridLocations [size][size][size];
    }
    
    //private ArrayList[] conflicts(Object gridLocations){}
    //private boolean hit(){}
}

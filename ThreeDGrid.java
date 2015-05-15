
/**
 * Write a description of class ThreeDGrid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class ThreeDGrid
{
    private static /*<--Is this OK? Need it for call to this method from Shot constructor.*/ int size;
    private static /*<--Is this OK? Need it for call to this method from Shot constructor.*/ Voxel[][][] grid;
    private final Voxel origin;

    /**
     * Constructor for objects of class ThreeDGrid
     */
    public ThreeDGrid(int size)
    {
        grid = new Voxel[size*2][size*2][size*2];
        origin = grid [size][size][size];
    }
    public static /*<--Is this OK? Need it for call to this method from Shot constructor.*/Voxel getOrigin()
    {
        return grid[size][size][size];
    }
    //private ArrayList[] conflicts(Object gridLocations){}
    //private boolean hit(){}
}

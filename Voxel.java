
/**
 * Write a description of class Voxel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Voxel
{
    private ArrayList<MovingObj> occupants;
    private final double xYAngle /*delete this and calculate angle -->*/ = 0;
    private final double xZAngle /*delete this and calculate angle -->*/ = 0;
    private final double zYAngle /*delete this and calculate angle -->*/ = 0;

    /**
     * Constructor for objects of class Voxel
     */
    public Voxel()
    {
        
    }
    public double getXYAngle()
    {
        return xYAngle;
    }
    public double getXZAngle()
    {
        return xZAngle;
    }
    public double getZYAngle()
    {
        return zYAngle;
    }
}

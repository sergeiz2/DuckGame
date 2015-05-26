
/**
 * Write a description of class Duck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import org.apache.commons.math3.geometry.euclidean.threed.*;

public class Duck extends MovingObj
{
    private int xWindowSize;
    private int yWindowSize;
    
    public Duck(int xWindowSize, int yWindowSize) //graphics x and y
    {
        super(Vector3D.ZERO, Vector3D.ZERO);
        setVelocity(calcInitVelocity());
        setReferancePoint(calcInitReferancePoint());
        setRelativeLocations(calcRelativeLocations());
        this.xWindowSize = xWindowSize;
        this.yWindowSize = yWindowSize;
    }
    public Vector3D calcInitReferancePoint() //x and y in the graphics sense // get window size.
    {
        double xScale = (Math.random()*xWindowSize); //x and y in the 3D sense (z is height, x is graphics x, and y is depth)
        double yScale = (Math.random()*0.0); //change this in later versions.
        double zScale = (Math.random()*yWindowSize);
        
        return new Vector3D(xScale, yScale, zScale);
    }
    public Vector3D calcInitVelocity()
    {
        double xScale = Math.random()*(26.8224/Math.sqrt(2)); //x and y in the 3D sense (z is height, x is graphics x, and y is depth)
        double yScale = Math.random()*(26.8224/Math.sqrt(2)); //26.8224 meters/sec is max duck speed.
        double zScale = 0;//Math.random()*(26.8224/Math.sqrt(3)); // change in later versions
        
        return new Vector3D(xScale, Vector3D.PLUS_I, yScale, Vector3D.PLUS_J,
                                                           zScale, Vector3D.PLUS_K);
    }
    public Vector3D calcVelocity()
    {
        //Velocity is initVelocity here. Should never be called.
        return null;
    }
    public Vector3D calcReferancePoint(long time)
    {
         return getVelocity().scalarMultiply((double)(time)).add(getReferancePoint());
    }
    public ArrayList<Vector3D> calcRelativeLocations() //10 cm cubes
    {
        ArrayList<Vector3D> relativeLocations = new ArrayList<Vector3D>();
        
        double cubeSide = .1; //meters
        Vector3D origin = Vector3D.ZERO;
        
        relativeLocations.add(origin); //the head of the duck
        relativeLocations.add(origin.add(new Vector3D(cubeSide, Vector3D.PLUS_I)));
        relativeLocations.add(origin.add(new Vector3D(cubeSide, Vector3D.PLUS_I, cubeSide, Vector3D.PLUS_J)));
        relativeLocations.add(origin.add(new Vector3D(cubeSide, Vector3D.PLUS_I, 2*cubeSide, Vector3D.PLUS_J)));
        relativeLocations.add(origin.add(new Vector3D(cubeSide, Vector3D.PLUS_I, -1*cubeSide, Vector3D.PLUS_J)));
        relativeLocations.add(origin.add(new Vector3D(cubeSide, Vector3D.PLUS_I, -2*cubeSide, Vector3D.PLUS_J)));
        relativeLocations.add(origin.add(new Vector3D(2*cubeSide, Vector3D.PLUS_I, (1/2.0)*cubeSide, Vector3D.PLUS_J)));
        relativeLocations.add(origin.add(new Vector3D(2*cubeSide, Vector3D.PLUS_I, (-1/2.0)*cubeSide, Vector3D.PLUS_J)));
        relativeLocations.add(origin.add(new Vector3D(3*cubeSide, Vector3D.PLUS_I)));
        relativeLocations.add(origin.add(new Vector3D(cubeSide, Vector3D.PLUS_I, -1*cubeSide, Vector3D.PLUS_K)));
        relativeLocations.add(origin.add(new Vector3D(2*cubeSide, Vector3D.PLUS_I, -1*cubeSide, Vector3D.PLUS_K)));
        
        return relativeLocations;
    }
}

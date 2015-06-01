package duckgame;

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
    private double xWindowSize;
    private double yWindowSize;
    private long duckFallTime;
    
    public Duck(double xWindowSize, double yWindowSize) //graphics x and y
    {
        super(Vector3D.ZERO, Vector3D.ZERO);
        setVelocity(calcInitVelocity());
        setReferancePoint(calcInitReferancePoint());
        setRelativeLocations(calcRelativeLocations());
        this.xWindowSize = xWindowSize;
        this.yWindowSize = yWindowSize;
        duckFallTime = 0;
    }
    public Vector3D calcInitReferancePoint() //x and y in the graphics sense // get window size.
    {
        double xScale = (350 + (Math.random()*400 - 200) /*xWindowSize*/); //x and y in the 3D sense (z is height, x is graphics x, and y is depth) //FIX THIS LATER
        double yScale = (Math.random()*0.0); //change this in later versions.
        double zScale = (300 + (Math.random()*300 - 150)/*yWindowSize*/);  //FIX THIS LATER
        
        Vector3D duckInitRefPt = new Vector3D(xScale/10, yScale, zScale/10); // dividing by 10 to compensate for duck being too far.
        
        System.out.println("Duck InitReferancePoint: " + duckInitRefPt);
        
        return duckInitRefPt;
    }
    public Vector3D calcInitVelocity()
    {
        double xScale = (Math.random()*((10*2)/Math.sqrt(2))) - (10/Math.sqrt(2)); //x and y in the 3D sense (z is height, x is graphics x, and y is depth)
        double yScale = 0; //Math.random()*(10/Math.sqrt(3)); // change in later versions
        double zScale = (Math.random()*((10*2)/Math.sqrt(2))) - (10/Math.sqrt(2));//26.8224 meters/sec is max duck speed.
        Vector3D duckInitVelocity = new Vector3D(xScale, Vector3D.PLUS_I, yScale, Vector3D.PLUS_J,
                                                           zScale, Vector3D.PLUS_K);
        System.out.println("Duck Velocity = " + duckInitVelocity);
        
        return duckInitVelocity;
    }
    public Vector3D calcVelocity()
    {
        //Velocity is initVelocity here. Should never be called.
        return null;
    }
    public Vector3D calcReferancePoint(long time)
    {
        if (duckFallTime == 0) //USING TIME FROM LAST SHOT. THIS IS WHY DUCK IS "JUMPING." Calculating refpt based on time since latest shot. 
        {
            return getVelocity().scalarMultiply(((double)(time))/1000000000L).add(getReferancePoint());
        }
        else 
        {
            double sinceDuckHit = (double)(System.nanoTime() - duckFallTime);
            
            return getVelocity().scalarMultiply(sinceDuckHit/1000000000L).add(getReferancePoint()).
                       add(new Vector3D (0.0, 0.0, ((sinceDuckHit*9.8)/1000000000L)));
        }
    }
    public void setFallTime(long time)
    {
        duckFallTime = time;
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

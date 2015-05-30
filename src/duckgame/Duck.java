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
        double xScale = (Math.random()*700/*xWindowSize*/); //x and y in the 3D sense (z is height, x is graphics x, and y is depth) //FIX THIS LATER
        double yScale = (Math.random()*0.0); //change this in later versions.
        double zScale = (Math.random()*600 /*yWindowSize*/);  //FIX THIS LATER
        
        System.out.println("WIDTH :" + xWindowSize + yWindowSize + ": HEIGHT");
        
        return new Vector3D(xScale, yScale, zScale);
    }
    public Vector3D calcInitVelocity()
    {
        double xScale = (Math.random()*((26.8224*2)/Math.sqrt(2)))-(Math.random()*((26.8224)/Math.sqrt(2))); //x and y in the 3D sense (z is height, x is graphics x, and y is depth)
        double yScale = 0; //Math.random()*(26.8224/Math.sqrt(3)); // change in later versions
        double zScale = (Math.random()*((26.8224*2)/Math.sqrt(2)))-(Math.random()*((26.8224)/Math.sqrt(2)));//26.8224 meters/sec is max duck speed.
        
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
        if (time < duckFallTime || duckFallTime == 0)
        {
            return getVelocity().scalarMultiply((double)(time/1000000000L)).add(getReferancePoint());
        }
        else 
        {
            return getVelocity().scalarMultiply((double)(time/1000000000L)).add(getReferancePoint()).
                       subtract(new Vector3D (0.0, 0.0, (double)((time*-9.8)/1000000000L)));
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

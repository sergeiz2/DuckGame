package duckgame;

/**
 * Abstract class MovingObj - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
import org.apache.commons.math3.geometry.euclidean.threed.*;
import java.util.*;

public abstract class MovingObj extends WithLocation
{
    private Vector3D referancePoint; //point from which obj is referanced/built
    private Vector3D velocity;
    private ArrayList<Vector3D> relativeLocations;

    MovingObj(Vector3D refPoint, Vector3D vel)
    {
        referancePoint = refPoint;
        velocity = vel;
        relativeLocations = new ArrayList<Vector3D>();
    }
    public Vector3D getReferancePoint()
    {
        return referancePoint;
    }
    public abstract Vector3D calcReferancePoint(long time); //in nanosecs
    public abstract Vector3D calcInitReferancePoint();
    public void setReferancePoint(Vector3D refPoint)
    {
        referancePoint = refPoint;
    }
    public Vector3D getVelocity()
    {
        return velocity;
    }
    public abstract Vector3D calcVelocity();
    public void setVelocity(Vector3D vel)
    {
        velocity = vel;
    }
    public void setRelativeLocations(ArrayList<Vector3D> relativeLocations)
    {
        this.relativeLocations = relativeLocations;
    }
    public abstract ArrayList<Vector3D> calcRelativeLocations();
    public ArrayList<Vector3D> getRelativeLocations()
    {
        return relativeLocations;
    }
    public ArrayList<Vector3D> calcLocations(long time)
    {
        ArrayList<Vector3D> locations;
        locations = new ArrayList<Vector3D>();
        calcReferancePoint(time);
        
        for (Vector3D relative : relativeLocations)
        {
            locations.add(referancePoint.add(relative));
        }
        
        return locations;
    }
}

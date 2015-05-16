
/**
 * Abstract class MovingObj - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
import org.apache.commons.math3.geometry.euclidean.threed.*;

public abstract class MovingObj implements Locatable 
{
    private Vector3D referancePoint; //point from which obj is referanced/built
    private Vector3D velocity; 

    MovingObj(Vector3D refPoint, Vector3D vel)
    {
        referancePoint = refPoint;
        velocity = vel;
    }
    public Vector3D getReferancePoint()
    {
        return referancePoint;
    }
    public abstract void setReferancePoint();
    public Vector3D getVelocity()
    {
        return velocity;
    }
    public abstract void setVelocity();
}

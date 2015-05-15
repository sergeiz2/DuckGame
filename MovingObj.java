
/**
 * Abstract class MovingObj - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class MovingObj implements Locatable 
{
    private /*Voxel*/ referancePoint; //point from which obj is referanced/built
    private /*Voxel*/ velocity; //IS THIS VELOCITY INHERITED BY OTHER OBJS? AND ALL THE VELOCITY METHODS?

    MovingObj(Object refPoint, Object vel)
    {
        referanceVoxel = refPoint;
        velocity = vel;
    }
    public Object getReferancePoint()
    {
        return referancePoint;
    }
    public abstract void setReferancePoint();
    public Object getVelocity()
    {
        return velocity;
    }
    public abstract void setVelocity();
}

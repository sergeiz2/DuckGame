
/**
 * Abstract class MovingObj - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class MovingObj implements Locatable 
{
    private Voxel referanceVoxel; //voxel from which obj is referanced/built
    private Voxel velocity; //Voxel type because velocity vector is drawn from (x,y,z,): (0,0,0) to the Voxel's coordiantes. //IS THIS VELOCITY INHERITED BY OTHER OBJS? AND ALL THE VELOCITY METHODS?

    public Voxel getReferanceVoxel()
    {
        return referanceVoxel;
    }
    public void setReferanceVoxel()
    {
        
    }
    public Voxel getVelocity()
    {
        return velocity;
    }
    public void setVelocity()
    {
        
    }
}


/**
 * Write a description of interface Locatable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import org.apache.commons.math3.geometry.euclidean.threed.*;
public interface Locatable
{
    void setLocations();
    ArrayList<Vector3D> getLocations();
}

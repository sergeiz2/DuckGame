
/**
 * Write a description of class Shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import org.apache.commons.math3.geometry.euclidean.threed.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Shot extends MovingObj
{
    private final int shotGauge;
    private double shotNumber;
    private String shotMaterial;
    private final int nOfPellets;
    private double shotWeight;
    private double initSpeed;

    public Shot(int gauge, double numberOfShot, String material) throws FileNotFoundException//velocity must realistically be calculated
    {
        super(Vector3D.ZERO, Vector3D.ZERO);
        shotGauge = gauge;
        shotNumber = numberOfShot;
        shotMaterial = material;
        setShotWeight();
        nOfPellets = calcNOfPellets();
        calcInitReferancePoint(); /*In future versions, calculate the point immediately in front of the barrel of the gun*/
        setInitSpeed();
    }
    public Vector3D calcInitReferancePoint()
    {
        return Vector3D.ZERO; //Will be tip of gun in later versions.
    }
    public void calcLocations()
    {
    }
    public void setInitSpeed() throws FileNotFoundException
    {
        int sum =0 ;
        int ctr = 0;
        
        Scanner sc = new Scanner(new File("shot_Gauge-WeightOz-VelocityFPS.csv"));
        sc.useDelimiter(",");
        while (sc.hasNext())
        {
            if (sc.next().equals((new Integer(shotGauge)).toString()))
            {
                sc.next();
                sum += Double.parseDouble(sc.next());
                ctr++;
            }
        }
        
        sc.close();
        
        initSpeed = (sum/ctr)*0.3048; //converted to meters per second
    }
    public Vector3D calcInitVelocity(double xVector, double zVector) //Change to 3D in later version.
    {
        Vector3D vel2D = new Vector3D(xVector, 0.0, zVector);
        vel2D.normalize();
        vel2D.scalarMultiply(initSpeed);
        
        return vel2D;
    }
    public Vector3D calcVelocity()
    {
        //same as initVelocity in this version.
        return null;
    }
    public double setShotWeight() throws FileNotFoundException
    {
        int sum =0 ;
        int ctr = 0;
        
        Scanner sc = new Scanner(new File("shot_Gauge-WeightOz-VelocityFPS.csv"));
        sc.useDelimiter(",");
        while (sc.hasNext())
        {
            if (sc.next().equals((new Integer (shotGauge)).toString()))
            {
                sc.next();
                sum += Double.parseDouble(sc.next());
                ctr++;
            }
        }
        
        sc.close();
        
        return sum/ctr;
    }
    public int calcNOfPellets () throws FileNotFoundException
    {      
        int pelletsPerOz = 0 ;
        
        Scanner sc = new Scanner(new File("shot_Number-DiameterMillimeter-PelletsPerOz"));
        sc.useDelimiter(",");
        while (sc.hasNext())
        {
            if (sc.next().equals((new Double(shotNumber)).toString()))
            {
                sc.next();
                pelletsPerOz = Integer.parseInt(sc.next());
            }
        }
        
        sc.close();
        
        return (int)(pelletsPerOz*shotWeight);
    }
    public void fire(double xVector, double zVector)
    {
        setVelocity(calcInitVelocity(xVector, zVector));
        
        //         long refTime = System.nanoTime();
        //         while (Vector3D.ZERO.distance(getReferancePoint()) < 100) //meters 
        //                   {
        //                       startTimer();
        //                       if(timeHasElapsed())
        //                       {
        //                           setReferancePoint(calcReferancePoint());
        //                           //later insert velocity recalculation here.
        //                           refTime = System.nanoTime();
        //                        }
        //                   }
        
    }
    public Vector3D calcReferancePoint(long time) //in nanosecs
    {
        return getVelocity().scalarMultiply((double)(time)).add(getReferancePoint());
    }
    public ArrayList<Vector3D> calcRelativeLocations() //10 cm cubes, 80 cm constant radius sphere
    {
        ArrayList<Vector3D> relativeLocations = new ArrayList<Vector3D>();
        relativeLocations.add(Vector3D.ZERO);
        Vector3D iAdditionVector = new Vector3D(0.1,Vector3D.PLUS_I, 0.0,Vector3D.PLUS_J, 0.0,Vector3D.PLUS_K);
        Vector3D jAdditionVector = new Vector3D(0.1,Vector3D.PLUS_I, 0.0,Vector3D.PLUS_J, 0.0,Vector3D.PLUS_K);
        Vector3D kAdditionVector = new Vector3D(0.1,Vector3D.PLUS_I, 0.0,Vector3D.PLUS_J, 0.0,Vector3D.PLUS_K);
        
        Vector3D newIBox = relativeLocations.get(relativeLocations.size()-1).add(iAdditionVector);
        
        while (relLocFits(newIBox))
        {
            relativeLocations.add(newIBox);
            relativeLocations.add(newIBox.scalarMultiply(-1.0));
        }
        
        for (Vector3D box : relativeLocations)
        {
            Vector3D newJBox = box.add(jAdditionVector);
            
            while (relLocFits(newJBox))
            {
                relativeLocations.add(newJBox);
                relativeLocations.add(newJBox.scalarMultiply(-1.0));
            }
        }
        
        for (Vector3D box : relativeLocations)
        {
            Vector3D newKBox = box.add(kAdditionVector);
            
            while (relLocFits(newKBox))
            {
                relativeLocations.add(newKBox);
                relativeLocations.add(newKBox.scalarMultiply(-1.0));
            }
        }
        
        return relativeLocations;
    }
    private boolean relLocFits(Vector3D cubeCenter)
    {
        return (getReferancePoint().distance(cubeCenter.add(new Vector3D(.05,Vector3D.PLUS_I, .05,Vector3D.PLUS_J, .05,Vector3D.PLUS_K))) > .4 ||
                    getReferancePoint().distance(cubeCenter.add(new Vector3D(.05,Vector3D.MINUS_I, .05,Vector3D.PLUS_J, .05,Vector3D.PLUS_K))) > .4 ||
                    getReferancePoint().distance(cubeCenter.add(new Vector3D(.05,Vector3D.PLUS_I, .05,Vector3D.MINUS_J, .05,Vector3D.PLUS_K))) > .4 ||
                    getReferancePoint().distance(cubeCenter.add(new Vector3D(.05,Vector3D.PLUS_I, .05,Vector3D.PLUS_J, .05,Vector3D.MINUS_K))) > .4 ||
                    getReferancePoint().distance(cubeCenter.add(new Vector3D(.05,Vector3D.MINUS_I, .05,Vector3D.MINUS_J, .05,Vector3D.MINUS_K))) > .4 ||
                    getReferancePoint().distance(cubeCenter.add(new Vector3D(.05,Vector3D.PLUS_I, .05,Vector3D.MINUS_J, .05,Vector3D.MINUS_K))) > .4 ||
                    getReferancePoint().distance(cubeCenter.add(new Vector3D(.05,Vector3D.MINUS_I, .05,Vector3D.PLUS_J, .05,Vector3D.MINUS_K))) > .4 ||
                    getReferancePoint().distance(cubeCenter.add(new Vector3D(.05,Vector3D.MINUS_I, .05,Vector3D.MINUS_J, .05,Vector3D.PLUS_K))) > .4);
    }
}


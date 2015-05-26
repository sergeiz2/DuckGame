
/**
 * Write a description of class DuckCreator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class DuckCreator
{
    private Timer timer;
    private Duck duck;

    public DuckCreator()
    {
        timer = new Timer();
        timer.schedule(new DuckMaker(), (int)(Math.random()*14999+1));
    }
    public Duck getDuck()
    {
        return duck;
    }
    public void setDuck(Duck duck)
    {
        this.duck = duck;
    }
    private class DuckMaker extends TimerTask
    {  
        @Override
        public void run()
        {
            setDuck(new Duck(Runner.getXWindowSize(), Runner.getYWindowSize()));
            DuckCreator creator = new DuckCreator();
        }
    }
}

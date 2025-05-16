package JavaExamples.DesignPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class Subscribers {

    private List<Observer> observers=new ArrayList<>();

    public void subscribe(Observer o)
    {
            observers.add(o);
    }

    public void notifyAllObservers(String message){
        for(Observer o:observers)
        {
            o.update(message);
        }

    }

    
    
}

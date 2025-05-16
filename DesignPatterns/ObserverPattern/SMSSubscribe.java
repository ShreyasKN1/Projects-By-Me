package JavaExamples.DesignPatterns.ObserverPattern;

public class SMSSubscribe implements Observer{
     @Override
    public void update(String message) {
       System.out.println("Through SMS service");
    }
    
}

package JavaExamples.DesignPatterns.ObserverPattern;

public class EmailSubscribe implements Observer{

    @Override
    public void update(String message) {
       System.out.println("Through email service");
    }
    
}

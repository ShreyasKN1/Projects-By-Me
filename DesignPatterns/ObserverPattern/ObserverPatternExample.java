package JavaExamples.DesignPatterns.ObserverPattern;

public class ObserverPatternExample {
    
    public static void main(String[] args) {
         Subscribers subs=new Subscribers();
    subs.subscribe(new EmailSubscribe());
    subs.subscribe(new SMSSubscribe());
    subs.notifyAllObservers("New post published!");
        
    }
 
}

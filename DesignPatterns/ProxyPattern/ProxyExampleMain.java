package JavaExamples.DesignPatterns.ProxyPattern;

public class ProxyExampleMain {
     // A proxy controls access to the original object, often used for access control, logging, or lazy initialization.

    public static void main(String[] args) {
         Service service=new ServiceProxy();
    service.run();
    
        
    }
   
    
}

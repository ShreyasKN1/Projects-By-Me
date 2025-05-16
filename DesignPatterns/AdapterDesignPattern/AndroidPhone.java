package JavaExamples.DesignPatterns.AdapterDesignPattern;

public class AndroidPhone implements AndroidCharger{

    @Override
    public void charge() {
       System.out.println("Charging my samsung phone");
    }
    
}

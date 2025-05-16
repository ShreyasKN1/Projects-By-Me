package JavaExamples.DesignPatterns.AdapterDesignPattern;

public class Iphone implements IphoneCharger{

    @Override
    public void charge() {
        System.out.println("Charging my iphone");
    }
    
}

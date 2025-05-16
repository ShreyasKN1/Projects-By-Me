package JavaExamples.DesignPatterns.DecoratorPattern;

public class DecoratorPatternMain {
    public static void main(String[] args) {
        Bike bike=new BasicBike();
        LuxuryBike li=new LuxuryBike(bike);

       bike.design();
       li.design();
    }
}

package JavaExamples.DesignPatterns.DecoratorPattern;

public class LuxuryBike extends DecoratorBike{

    public LuxuryBike(Bike bike) {
        super(bike);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void design(){
        super.design();
        System.out.println("Adding more decoration to the bike to Luxury Bike");
     }


    
}
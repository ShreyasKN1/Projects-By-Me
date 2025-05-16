package JavaExamples.DesignPatterns.DecoratorPattern;

public abstract class DecoratorBike implements Bike{
    
    protected Bike bike;

    public DecoratorBike(Bike bike)
    {
        this.bike=bike;
    }

     public void design(){
        bike.design();
        System.out.println("Adding more decoration to the bike");
     }


}

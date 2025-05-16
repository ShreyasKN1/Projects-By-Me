package JavaExamples.DesignPatterns.AggregatorPattern;

public class AggregatorExample {

    //Definition: Collects and composes data from multiple sources/services and returns a combined result.
    //Real-life Example: A travel booking site aggregating data from hotel, flight, and cab services.

    private User user=new User();
    private Order order=new Order();

    public void getFullInfo(){
        System.out.println(user.something()+" "+order.getOrder());
    }
    
    public static void main(String[] args) {
        AggregatorExample aggregatorExample=new AggregatorExample();
        aggregatorExample.getFullInfo();
    }
}

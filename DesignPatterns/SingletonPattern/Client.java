package JavaExamples.DesignPatterns.SingletonPattern;

import java.lang.reflect.Constructor;

public class Client {
    public static void main(String[] args) throws Exception{
        SingletonPattern obj2=SingletonPattern.getSingletonPattern();
        System.out.println(obj2.hashCode());
        SingletonPattern obj1=SingletonPattern.getSingletonPattern();
        System.out.println(obj1.hashCode());

        Constructor<SingletonPattern> cons=SingletonPattern.class.getDeclaredConstructor();
        cons.setAccessible(true);
        SingletonPattern s1=cons.newInstance();
        System.out.println(s1.hashCode());
        // System.out.println(s2.hashCode());


        
    }
    
}

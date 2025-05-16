package JavaExamples.DesignPatterns.SingletonPattern;

public class SingletonPattern {
    

    private static SingletonPattern obj;
    
    private SingletonPattern()
    {
    if(obj!=null)
    {
        throw new RuntimeException();
    }
}
   
    public static SingletonPattern getSingletonPattern()
    {
        if(obj==null){
        synchronized(SingletonPattern.class)
        {
        if(obj==null)
        {
            obj=new SingletonPattern();
        }
    }
    }
    return obj;
    }
}

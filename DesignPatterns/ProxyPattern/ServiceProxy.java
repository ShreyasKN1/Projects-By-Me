package JavaExamples.DesignPatterns.ProxyPattern;

public class ServiceProxy implements Service{

private ProxyExample proxyExmaple;

    @Override
    public void run() {
        
    if(proxyExmaple==null)
    {

      proxyExmaple=  new ProxyExample();
    }
    proxyExmaple.run();
    System.out.println("Proxy Class in Action");
    }
    
}

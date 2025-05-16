package JavaExamples.DesignPatterns.AdapterDesignPattern;

public class AdapterDesignPatternExample {

    public static void main(String[] args) {
        AndroidCharger androidCharger=new AndroidPhone();

    ChargerAdapterImpl chargerAdapterImpl=new ChargerAdapterImpl(androidCharger);

    chargerAdapterImpl.IphoneToAndroid();
        
    }
    
    
}

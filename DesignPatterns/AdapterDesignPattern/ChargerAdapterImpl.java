package JavaExamples.DesignPatterns.AdapterDesignPattern;

public class ChargerAdapterImpl implements ChargerAdapter{

   private AndroidCharger androidCharger;

    ChargerAdapterImpl( AndroidCharger androidCharger)
    {
            this.androidCharger=androidCharger;
    }
    @Override
    public void IphoneToAndroid() {
        System.out.println("Something is adapting");
        androidCharger.charge();
        
    }
    
}

package JavaExamples.DesignPatterns.LazyLoadingPattern;

public class Products {
    private String name;
    private ProductDetails details;

    public Products(String name){
        this.name=name;
    }
   
    public ProductDetails getDetails() {
        if(details==null)
        {
         details=new ProductDetails();
        }
        return details;
    }

    public static void main(String[] args) {
        Products p=new Products("laptop");
        System.out.println(p.getDetails().getDesc());
    }
    

}

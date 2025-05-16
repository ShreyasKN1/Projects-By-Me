package JavaExamples.DesignPatterns.ChainOfReponsibilityPattern;

public class CORExample {
    public static void main(String[] args) {
    SupportLevel level1=new Level1Support() ;
    SupportLevel level2=new Level2Support() ;
    SupportLevel level3=new Level3Support() ;

        level1.setNext(level2);
        level2.setNext(level3);
        level1.handleRequest("password reset");
        level1.handleRequest("SOme Network issue");
        level1.handleRequest("SOme other issue");
    }
    
    
    
}

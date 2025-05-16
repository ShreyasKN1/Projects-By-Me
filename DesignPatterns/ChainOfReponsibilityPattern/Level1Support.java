package JavaExamples.DesignPatterns.ChainOfReponsibilityPattern;

public class Level1Support extends SupportLevel{

    @Override
    protected boolean canHandle(String issue) {
        return issue.equalsIgnoreCase("password reset");
      
    }

    @Override
    protected void process(String issue) {
        System.out.println("Level 1 process:");
    }
    
}

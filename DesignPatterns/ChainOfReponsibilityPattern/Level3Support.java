package JavaExamples.DesignPatterns.ChainOfReponsibilityPattern;

public class Level3Support extends SupportLevel{
    @Override
    protected boolean canHandle(String issue) {
        return issue.equalsIgnoreCase("SOme other issue");
    }

    @Override
    protected void process(String issue) {
         System.out.println("Level 3 process:");
    }
    
}

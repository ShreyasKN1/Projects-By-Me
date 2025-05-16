package JavaExamples.DesignPatterns.ChainOfReponsibilityPattern;

public class Level2Support extends SupportLevel{

    @Override
    protected boolean canHandle(String issue) {
        return issue.equalsIgnoreCase("SOme Network issue");
    }

    @Override
    protected void process(String issue) {
         System.out.println("Level 2 process:");
    }
    
}

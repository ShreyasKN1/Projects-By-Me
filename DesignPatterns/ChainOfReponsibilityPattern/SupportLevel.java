package JavaExamples.DesignPatterns.ChainOfReponsibilityPattern;

abstract class SupportLevel {
    protected SupportLevel next;

    public void setNext(SupportLevel next) {
        this.next = next;
    }

    public void handleRequest(String issue) { 
        if (canHandle(issue)) {
            process(issue);
        } else if (next != null) {
            next.handleRequest(issue);
        } else {
            System.out.println("Issue cannot be handled.");
        }
    }

    protected abstract boolean canHandle(String issue);
    protected abstract void process(String issue);
}

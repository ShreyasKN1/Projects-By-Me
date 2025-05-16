package JavaExamples.DesignPatterns.MementoPattern;

public class TextEditor {
    
    private String message="";

    public void write(String newMessage)
    {
        message=message+" "+newMessage;
    }

    public TextMemento save()
    {
        return new TextMemento(message);
    }

    public void restore(TextMemento memento)
    {
         this.message=memento.getMessage();
    }

    public void print(){
        System.out.println(message);
    }
}

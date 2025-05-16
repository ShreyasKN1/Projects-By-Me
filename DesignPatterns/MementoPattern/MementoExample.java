package JavaExamples.DesignPatterns.MementoPattern;

public class MementoExample {
    public static void main(String[] args) {
        TextEditor editor=new TextEditor();
        editor.write("Hello Shreyas");
        TextMemento textMemento=editor.save();
        editor.write("Welcome to DP");
        editor.print();
        editor.restore(textMemento);
        editor.print();
    }
}

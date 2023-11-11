package QuizAppli.QuizAppli;

import QuizAppli.QuizAppli.Question;
import QuizAppli.QuizAppli.QuizUI;

public class QuizApp {
    public static void main(String[] args) {
        Question[] questions = {
              
                new Question("1-What is the correct way to declare a constant in Java?", new String[]{"constant int VALUE = 10;", "final int VALUE = 10;", "const int VALUE = 10;", "static final int VALUE = 10;"}, 1),
                new Question("2-Which of the following is a valid method signature in Java?", new String[]{"void methodName()", "int methodName(void)", "methodName(void) void", "int methodName"}, 0),
                new Question("3-What is the purpose of the `super` keyword in Java?", new String[]{"It refers to the current instance of the class.", "It calls the superclass method.", "It is used for garbage collection.", "It declares a constant variable."}, 1),
                new Question("4-What is the difference between `==` and `equals()` method in Java when comparing objects?", new String[]{"They are interchangeable and can be used interchangeably.", "`==` compares object references, while `equals()` compares object content.", "`==` is used for primitive types, and `equals()` is used for objects.", "`equals()` compares object references, while `==` compares object content."}, 1),
                new Question("5-What is the default value of a local variable in Java?", new String[]{"0", "null", "Depends on the variable type", "Not defined"}, 3),
                new Question("6-What is the Java Virtual Machine (JVM)?", new String[]{"A compiler", "An interpreter", "A hardware component", "A runtime environment"}, 3),
                new Question("7-What does the `static` keyword mean in Java?", new String[]{"It indicates that a variable is constant.", "It means the variable is shared among all instances of the class.", "It signifies that a method belongs to the class rather than an instance.", "It indicates that a method can be overridden."}, 2),
                new Question("8-Which of the following is the correct way to create an array in Java?", new String[]{"array myList = new array();", "int[] myList = new int[];", "int[] myList = new int[5];", "array myList = new int[5];"}, 2),
                new Question("9-What is the purpose of the `finally` block in a try-catch-finally statement in Java?", new String[]{"To catch exceptions", "To execute code regardless of whether an exception occurs or not", "To specify the code that may throw an exception", "To handle checked exceptions"}, 1),
                new Question("10-In Java, what is the main purpose of the `StringBuilder` class?", new String[]{"To provide a mutable sequence of characters", "To convert between data types", "To read and write files", "To handle exceptions in string manipulation"}, 0)
        };

        QuizUI quizUI = new QuizUI(questions);
        quizUI.setTimerDelay(60000);
    }
}

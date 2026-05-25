package lab4;

// Наследуемся от базового класса Exception
public class CustomFileNotFoundException extends Exception {
    public CustomFileNotFoundException(String message) {
        super(message);
    }
}
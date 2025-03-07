import java.util.Scanner;

public class Chatbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        System.out.println("Hello! I'm your AI chatbot. How can I help you today?");
        while (true) {
            userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("exit")) break;
            generateResponse(userInput);
        }
        System.out.println("Goodbye!");
    }

    static void generateResponse(String input) {
        if (input.contains("hello")) {
            System.out.println("Hi there! How can I assist you?");
        } else {
            System.out.println("I'm not sure how to respond to that.");
        }
    }
}
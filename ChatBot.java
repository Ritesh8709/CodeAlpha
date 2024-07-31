import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        System.out.println("Hello! I'm your chatbot. Type 'exit' to end the conversation.");

        while (true) {
            System.out.print("You: ");
            userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("ChatBot: Goodbye!");
                break;
            }

            String response = getResponse(userInput);
            System.out.println("ChatBot: " + response);
        }

        scanner.close();
    }

    private static String getResponse(String input) {
        // Simple response logic
        input = input.toLowerCase();
        switch (input) {
            case "hello":
                return "Hi there!";
            case "how are you?":
                return "I'm just a program, so I don't have feelings, but I'm here to chat!";
            case "what's your name?":
                return "I'm a Java chatbot created to assist you.";
            case "how are you":
                return "I'm doing well, thank you! How can I assist you today?";
            case "what's going on":
            case "what's going on?":
            case "what is going on":
            case "what is going on?":
                return "Not much, just here to chat with you. How can I help?";
            default:
                return "I'm not sure how to respond to that.";
        }
    }
}
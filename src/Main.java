import controllers.PostController;
import dtos.requests.CreatePostRequest;
//import javax.swing.*;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static PostController postController = new PostController();
    public static void main(String[] args) {
        System.out.println("Hello world!");

        displayMainMenu();
    }

    private static void displayMainMenu() {
        String mainMenu = """
                Press 1 for Create Post
                Press 2 for View Post
                Press 3 to exit
                """;
        String userInput = input(mainMenu);
        switch (userInput.charAt(0)) {
            case '1' -> createPost();
            case '2' -> viewPost();
            case '3' -> exitFromApp();
        }
    }

    private static void createPost() {
        String title = input("Enter post title: ");
        String body = input("Enter post body: ");
        CreatePostRequest postRequest = new CreatePostRequest();
        postRequest.setTitle(title);
        postRequest.setBody(body);
        print(postController.createPost(postRequest));
        displayMainMenu();
    }

    private static void viewPost() {
        String userInput = input("Enter post id");
        print(postController.viewPost(Integer.parseInt(userInput)).toString());
        displayMainMenu();
    }

    private static void exitFromApp() {
        print("Thanks for using our blog!");
        System.exit(0);
    }

    private static String input(String prompt) {
        print(prompt);
        return scanner.nextLine();
//        return JOptionPane.showInputDialog(null, prompt);
    }

    private static void print(String prompt) {
        System.out.println(prompt);
//        JOptionPane.showMessageDialog(null, prompt);
    }
}
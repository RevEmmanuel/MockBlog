package africa.semicolon.Blog;

import africa.semicolon.Blog.controllers.PostController;
import africa.semicolon.Blog.dtos.requests.CreatePostRequest;
import africa.semicolon.Blog.exceptions.PostNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.swing.*;
import java.util.Scanner;

@SpringBootApplication
@EnableMongoRepositories
public class Main {
//    private static Scanner scanner = new Scanner(System.in);
    private static final PostController postController = new PostController();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
//        System.out.println("Hello User!");
//        displayMainMenu();
    }

    private static void displayMainMenu() {
        String mainMenu = """
                Press 1 to Create Post
                Press 2 to View Post
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
        String userInput = input("Enter post id or 0 to exit");
        if ("0".equals(userInput)) {
            displayMainMenu();
        }
        showPost(userInput);
    }

    private static void showPost(String postId) {
        try {
            print(postController.viewPost(postId));
            displayMainMenu();
        }
        catch (PostNotFoundException pnf) {
            print("Post not found. Check that id is correct");
            viewPost();
        }
    }

    private static void exitFromApp() {
        print("Thanks for using our blog!");
        System.exit(0);
    }

    private static String input(String prompt) {
//        print(prompt);
//        return scanner.nextLine();
        return JOptionPane.showInputDialog(null, prompt);
    }

    private static void print(String prompt) {
//        System.out.println(prompt);
        JOptionPane.showMessageDialog(null, prompt);
    }

    private static void print(Object obj) {
//        System.out.println(obj);
        JOptionPane.showMessageDialog(null, obj);
    }

}

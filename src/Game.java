import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Game {

    private static Scanner input = new Scanner(System.in);
    private static boolean gameRunning = true;

    // Takes in user input and makes sure that it is an integer between 0 and n inclusive
    private static int takeInput(int n) {
        String in = "";
        int returnValue = 0;
        while(true) {
            in = input.nextLine();
            try {
                returnValue = Integer.parseInt(in);
                if(returnValue >= 0 && returnValue <= n)
                    return returnValue;
                else
                    System.out.println("Error, not an option");
            }
            catch (NumberFormatException e) {
                System.out.println("Error, not an option");
            }
        }
    }

    private static void checkAdventurer() {
        try {
            String file = Files.readString(Paths.get("../data/Characters.txt"));
            System.out.println(file);
        } catch (IOException e) {
            System.out.println("Error, files are missing, please reinstall");
        }
    }

    private static void startMenu() {
        System.out.println("=======================================================");
        System.out.println("Welcome to the Text Dungeon, what would you like to do?");
        System.out.println("0. Enter the Dungeon");
        System.out.println("1. Create an Adventurer");
        System.out.println("2. Exit");
        System.out.println("=======================================================");
        int in = takeInput(1);
        if(in == 0) {
            System.out.println("Godspeed adventurer");
            enterDungeon();
        } else if(in == 1) {

        } else if(in == 2) {
            System.out.println("Farewell adventurer, may you return one day...");
            gameRunning = false;
        }
    }

    private static void enterDungeon() {
        
    }
    public static void main(String[] args) {
    //     while (gameRunning) {
    //         startMenu();
    //     }
        checkAdventurer();
    }

}
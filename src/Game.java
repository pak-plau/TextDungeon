import java.util.Scanner;

import Adventurer.Adventurer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Game {

    private static Scanner input = new Scanner(System.in);
    private static boolean gameRunning = true;
    private static Adventurer hero;

    // Takes in user input and makes sure that it is an integer between 0 and n inclusive
    private static int takeInput(int n) {
        String in = "";
        int returnValue = 0;
        while(true) {
            in = input.next();
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

    private static boolean checkAdventurer() {
        try {
            String file = Files.readString(Paths.get("../data/Characters.txt"));
            if(file.isEmpty())
                System.out.println("Please create an adventurer");
            return !file.isEmpty();
        } catch (IOException e) {
            System.out.println("Error, files are missing, please reinstall");
            return false;
        }
    }

    private static void makeAdventurer() {
        try {
            boolean valid = false;
            String name = "";
            File file = null;
            while(!valid) {
                System.out.println("What is the name of your adventurer?");
                name = input.next();
                file = new File("../data/" + name + "Stats.txt");
                if(!file.createNewFile()){
                    System.out.println("================================================");
                    System.out.println("This character already exists. Would you like to");
                    System.out.println("0. Reset the character?");
                    System.out.println("1. Rename your current character?");
                    System.out.println("================================================");
                    if(takeInput(1) == 0) {
                        file.delete();
                    }
                } else
                    valid = true;
            }
            System.out.println("You have 50 attribute points, how many would you like to put into health?");
            System.out.println("*Each attribute point = 1 point of health");
            System.out.println("*All remaining attribute points will be put into attack, choose wisely");
            int n = takeInput(50);
            hero = new Adventurer(name, n, 50 - n);
            newCharacter(file);
        }
        catch (IOException e) {
            System.out.println("IOException on makeAdventurer()");
        }
    }

    private static void newCharacter(File file) {
        try {
            FileReader fr = new FileReader(new File("../data/StatsTemplate.txt"));
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(file, false);
            String s = "";
            String str;
            while((str = br.readLine()) != null) {
                s += str + "\n";
            }
            String[] array = s.split("\n");
            for (int i = 0; i < array.length; i++)
                System.out.println(array[i]);
            String[][] Array = new String[array.length][];
            for (int i = 0; i < array.length; i++)
                Array[i] = array[i].split(" : ");
            // TODO 
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
        int in = takeInput(2);
        if(in == 0) {
            if(checkAdventurer()) {
                System.out.println("Godspeed adventurer");
                enterDungeon();
            }
        } else if(in == 1) {
            makeAdventurer();
        } else if(in == 2) {
            System.out.println("Farewell adventurer, may you return one day...");
            gameRunning = false;
        }
    }

    private static void enterDungeon() {
        
    }
    public static void main(String[] args) {
        // while (gameRunning) {
        //     startMenu();
        // }
        newCharacter(new File("../data/PakStats.txt"));
    }

}
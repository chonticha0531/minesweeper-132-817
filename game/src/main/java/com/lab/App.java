package com.lab;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    static Minesweeper initMineField() {
        Minesweeper game = new Minesweeper(9, 9);
        game.setMineCell(0, 1);
        game.setMineCell(1, 5);
        game.setMineCell(1, 8);
        game.setMineCell(2, 4);
        game.setMineCell(3, 6);        
        game.setMineCell(4, 2);
        game.setMineCell(5, 4);
        game.setMineCell(6, 2);
        game.setMineCell(7, 2);
        game.setMineCell(8, 6);
        return game;
    }

    static Minesweeper initMineFieldFromFile(String minefieldFile) {
        return new Minesweeper(minefieldFile);
    }
    
    static Minesweeper initMineFieldSmall() {
        Minesweeper game = new Minesweeper(5, 5);
        game.setMineCell(1, 1);
        game.setMineCell(2, 3);
        game.setMineCell(4, 0);
        return game;
    }
    static Minesweeper initMineFieldLarge() {
        Minesweeper game = new Minesweeper(15, 15);
        game.setMineCell(3, 2);
        game.setMineCell(5, 7);
        game.setMineCell(8, 10);
        game.setMineCell(12, 4);
        game.setMineCell(14, 14);
        game.setMineCell(0, 1);
        game.setMineCell(2, 4);
        game.setMineCell(5, 12);
        game.setMineCell(11, 10);
        game.setMineCell(10, 14);
        return game;
    }


    public static void main(String[] args) {
        // Task 3: Implement a menu to select the mine field template
        // Design the menu by yourself.
       
       Scanner scanner = new Scanner(System.in);
        System.out.println("Select Minefield Size:");
        System.out.println("1. 5x5");
        System.out.println("2. 9x9 (Default)");
        System.out.println("3. 15x15");
        System.out.println("4. Load from file");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        Minesweeper game;
        switch (choice) {
            case 1:
                game = initMineFieldSmall();
                break;
            case 2:
                game = initMineField();
                break;
            case 3:
                game = initMineFieldLarge();
                break;
            case 4:
                System.out.print("Enter file name: ");
                scanner.nextLine(); // Consume newline
                String filename = scanner.nextLine();
                game = initMineFieldFromFile(filename);
                break;
            default:
                System.out.println("Invalid choice! Defaulting to 9x9.");
                game = initMineField();
        }

        game.displayField();
        scanner.close();
        //Minesweeper game = initMineField();
        //Minesweeper game  = initMineFieldFromFile("minefield/minefield01.txt");
        //game.displayField();
    }
}
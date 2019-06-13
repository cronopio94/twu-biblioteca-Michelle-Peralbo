package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        Library biblioteca = new Library();

        while (true) {
            biblioteca.showWelcomeMessage("Welcome to Library. Your one-stop-shop for great book titles in Bangalore!\nMenu:\n");
            menuStrategy[] algorithms = {new ListBooks(), new CheckoutBook(), new ReturnBook(), new ListMovie(), new CheckoutMovie(), new ShowUserInformation(), new QuitApp(), new Error()};
            for (menuStrategy algorithm : algorithms) {
                executeMenu(algorithm);
            }
            try {
                Scanner reader = new Scanner(System.in);
                int optionSelected = reader.nextInt();
                for (menuStrategy algorithm : algorithms) {
                    executeSelectOption(algorithm, optionSelected, biblioteca);
                }
            } catch (InputMismatchException e) {
                System.out.println("Please select a valid option");
            }


        }
    }

    private static void executeMenu(menuStrategy strategy) {
        System.out.println(strategy.showOptionMessage());
    }

    private static void executeSelectOption(menuStrategy strategy, int optionSelected, Library library) {
        strategy.executeOption(library, optionSelected);
    }
}

